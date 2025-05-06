package Lab07.Zad02;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        final int tasma = 5;
        final int LICZBA_CUKIERNIKOW = 3;
        final int LICZBA_PAKOWACZY = 2;

        BlockingQueue<Integer> tasmowa = new ArrayBlockingQueue<>(tasma);
        AtomicInteger licznikCiastek = new AtomicInteger(1);

        for (int i = 0; i < LICZBA_CUKIERNIKOW; i++) {
            new Thread(new Cukiernik(tasmowa, licznikCiastek, i + 1)).start();
        }

        for (int i = 0; i < LICZBA_PAKOWACZY; i++) {
            new Thread(new Pakowacz(tasmowa, i + 1)).start();
        }
    }
}

class Cukiernik implements Runnable {
    private final BlockingQueue<Integer> tasmowa;
    private final AtomicInteger licznikCiastek;
    private final int id;

    public Cukiernik(BlockingQueue<Integer> tasmowa, AtomicInteger licznikCiastek, int id) {
        this.tasmowa = tasmowa;
        this.licznikCiastek = licznikCiastek;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int ciastko = licznikCiastek.getAndIncrement();
                System.out.println("Słodziak " + id + ": robi nadgodziny i piecze ciastko " + ciastko);
                Thread.sleep((int) (Math.random() * 2000));
                tasmowa.put(ciastko);
                System.out.println("Słodziak " + id + ": robi nadgodziny i odkłada ciastko " + ciastko + " na taśmę.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Cukiernik " + id + " zakończył pracę.");
        }
    }
}

class Pakowacz implements Runnable {
    private final BlockingQueue<Integer> tasmowa;
    private final int id;

    public Pakowacz(BlockingQueue<Integer> tasmowa, int id) {
        this.tasmowa = tasmowa;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer ciastko = tasmowa.take();
                System.out.println("Cygan " + id + ": zawinął ciastko " + ciastko + " z taśmy.");
                Thread.sleep((int) (Math.random() * 3000));
                System.out.println("Cygan " + id + ": zapakował ciastko " + ciastko + " do kieszeni");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Pakowacz " + id + " zakończył pracę.");
        }
    }
}

