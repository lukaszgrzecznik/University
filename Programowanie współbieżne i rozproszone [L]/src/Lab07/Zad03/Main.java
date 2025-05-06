package Lab07.Zad03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        final int ROZMIAR_TASMY1 = 10;
        final int ROZMIAR_TASMY2 = 5;
        final int LICZBA_CUKIERNIKOW = 3;
        final int LICZBA_PAKOWACZY = 2;
        final int LICZBA_PALECIARZY = 2;

        BlockingQueue<Integer> tasma1 = new ArrayBlockingQueue<>(ROZMIAR_TASMY1); // ciastka
        BlockingQueue<List<Integer>> tasma2 = new ArrayBlockingQueue<>(ROZMIAR_TASMY2); // zapakowane podwójne

        AtomicInteger licznikCiastek = new AtomicInteger(1);

        for (int i = 0; i < LICZBA_CUKIERNIKOW; i++) {
            new Thread(new Cukiernik(tasma1, licznikCiastek, i + 1)).start();
        }

        for (int i = 0; i < LICZBA_PAKOWACZY; i++) {
            new Thread(new Pakowacz(tasma1, tasma2, i + 1)).start();
        }

        for (int i = 0; i < LICZBA_PALECIARZY; i++) {
            new Thread(new Paleciarz(tasma2, i + 1)).start();
        }
    }
}

class Cukiernik implements Runnable {
    private final BlockingQueue<Integer> tasma1;
    private final AtomicInteger licznikCiastek;
    private final int id;

    public Cukiernik(BlockingQueue<Integer> tasma1, AtomicInteger licznikCiastek, int id) {
        this.tasma1 = tasma1;
        this.licznikCiastek = licznikCiastek;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int ciastko = licznikCiastek.getAndIncrement();
                System.out.println("Cukiernik #" + id + ": piecze ciastko " + ciastko);
                Thread.sleep((int) (Math.random() * 2000));
                tasma1.put(ciastko);
                System.out.println("Cukiernik #" + id + ": odkłada ciastko " + ciastko + " na taśmę 1");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Cukiernik #" + id + " zakończył pracę.");
        }
    }
}

class Pakowacz implements Runnable {
    private final BlockingQueue<Integer> tasma1;
    private final BlockingQueue<List<Integer>> tasma2;
    private final int id;

    public Pakowacz(BlockingQueue<Integer> tasma1, BlockingQueue<List<Integer>> tasma2, int id) {
        this.tasma1 = tasma1;
        this.tasma2 = tasma2;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer c1 = tasma1.take();
                Integer c2 = tasma1.take();
                System.out.println("Pakowacz #" + id + ": zabiera ciastka " + c1 + " i " + c2 + " z taśmy 1");
                Thread.sleep((int) (Math.random() * 3000));
                List<Integer> zapakowane = new ArrayList<>();
                zapakowane.add(c1);
                zapakowane.add(c2);
                tasma2.put(zapakowane);
                System.out.println("Pakowacz #" + id + ": zapakował ciastka " + c1 + " i " + c2 + " i odłożył na taśmę 2");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Pakowacz #" + id + " zakończył pracę.");
        }
    }
}

class Paleciarz implements Runnable {
    private final BlockingQueue<List<Integer>> tasma2;
    private final int id;

    public Paleciarz(BlockingQueue<List<Integer>> tasma2, int id) {
        this.tasma2 = tasma2;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                List<List<Integer>> paleta = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    List<Integer> zapakowane = tasma2.take();
                    System.out.println("Paleciarz #" + id + ": bierze pakunek " + zapakowane + " z taśmy 2");
                    paleta.add(zapakowane);
                    Thread.sleep((int) (Math.random() * 1000));
                }
                System.out.println("Paleciarz #" + id + ": zapakował paletę z pakunkami: " + paleta);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Paleciarz #" + id + " zakończył pracę.");
        }
    }
}

