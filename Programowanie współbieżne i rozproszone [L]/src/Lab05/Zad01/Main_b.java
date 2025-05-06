package Lab05.Zad01;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main_b {
    static int a, b;
    static Semaphore sem = new Semaphore(0);

    public static void main(String[] args) {
        Thread dane = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj a: ");
            a = scanner.nextInt();
            System.out.print("Podaj b: ");
            b = scanner.nextInt();
            sem.release();
        });

        Thread obliczenia = new Thread(() -> {
            try {
                sem.acquire();
                int suma = a + b;
                System.out.println("Suma: " + suma);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        dane.start();
        obliczenia.start();
    }
}

