package Lab06.Zad03;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {
    static final int NUM_PHILOSOPHERS = 5;
    static final Semaphore[] forks = new Semaphore[NUM_PHILOSOPHERS];

    public static void main(String[] args) {
        //  Inicjalizacja semaforów dla każdego widelca
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Semaphore(1);
        }

        //  Uruchomienie wątków - filozofów
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            new Philosopher(i).start();
        }
    }
}

class Philosopher extends Thread {
    private final int id;
    private final Random random = new Random();

    public Philosopher(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (true) { //  Filozof żyje wiecznie
            think();
            eat();
        }
    }

    private void think() {
        System.out.println("Filozof " + id + " myśli.");
        randomDelay();
    }

    private void eat() {
        int leftFork = id;
        int rightFork = (id + 1) % Main.NUM_PHILOSOPHERS;

        // Zapobiegamy zakleszczeniu - najpierw zawsze podnosimy widelec o niższym numerze
        int firstFork = Math.min(leftFork, rightFork);
        int secondFork = Math.max(leftFork, rightFork);

        try {
            System.out.println("Filozof " + id + " próbuje podnieść widelec " + firstFork + ".");
            Main.forks[firstFork].acquire();
            System.out.println("Filozof " + id + " podniósł widelec " + firstFork + ".");

            System.out.println("Filozof " + id + " próbuje podnieść widelec " + secondFork + ".");
            Main.forks[secondFork].acquire();
            System.out.println("Filozof " + id + " podniósł widelec " + secondFork + ".");

            // Oba widelce zdobyte - je
            System.out.println("Filozof " + id + " je.");
            randomDelay();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //  Odkłada widelce
            Main.forks[firstFork].release();
            Main.forks[secondFork].release();
            System.out.println("Filozof " + id + " odłożył widelce " + firstFork + " i " + secondFork + ".");
        }
    }

    private void randomDelay() {
        try {
            Thread.sleep(random.nextInt(1000) + 500); //  Opóźnienie 500-1500ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
