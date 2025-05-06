package Lab07.Zad01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        final int tasma = 5;
        BlockingQueue<Integer> tasmowa = new ArrayBlockingQueue<>(tasma);

        Thread cukiernik = new Thread(new Cukiernik(tasmowa));
        Thread pakowacz = new Thread(new Pakowacz(tasmowa));

        cukiernik.start();
        pakowacz.start();
    }
}

class Cukiernik implements Runnable {
    private BlockingQueue<Integer> tasmowa;
    private int numerCiasteczka = 1;

    public Cukiernik(BlockingQueue<Integer> tasmowa) {
        this.tasmowa = tasmowa;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Robol: robi nadgodziny i piecze ciastko " + numerCiasteczka);
                Thread.sleep((int)(Math.random() * 2000));
                tasmowa.put(numerCiasteczka);
                System.out.println("Robol: robi nadgodziny i odkłada ciastko " + numerCiasteczka + " na taśmę.");
                numerCiasteczka++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Robol zakończył pracę (chyba).");
        }
    }
}

class Pakowacz implements Runnable {
    private BlockingQueue<Integer> tasmowa;

    public Pakowacz(BlockingQueue<Integer> tasmowa) {
        this.tasmowa = tasmowa;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer ciastko = tasmowa.take();
                System.out.println("Cygan: zawinął ciastko " + ciastko + " z taśmy.");
                Thread.sleep((int)(Math.random() * 3000));
                System.out.println("Cygan: zapakował ciastko " + ciastko + " do kieszeni");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Cygan zakończył pracę (o ile nic nie ukradł).");
        }
    }
}

