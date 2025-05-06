package Lab05.Zad02;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main_b {
    static int a, b;

    // semafory do synchronizacji
    static Semaphore semDane1Done = new Semaphore(0); // pozwala rozpocząć Dane2
    static Semaphore semDane2Done = new Semaphore(0); // pozwala rozpocząć Obliczenia

    public static void main(String[] args) {
        Thread dane1 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj a: ");
            a = scanner.nextInt();
            semDane1Done.release();  // zezwala na start Dane2
        });

        Thread dane2 = new Thread(() -> {
            try {
                semDane1Done.acquire();  // czeka na zakończenie Dane1
                Scanner scanner = new Scanner(System.in);
                System.out.print("Podaj b: ");
                b = scanner.nextInt();
                semDane2Done.release();  // zezwala na start Obliczenia
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread obliczenia = new Thread(() -> {
            try {
                semDane2Done.acquire();  // czeka na zakończenie Dane2
                int suma = a + b;
                System.out.println("Suma: " + suma);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start wszystkich wątków
        dane1.start();
        dane2.start();
        obliczenia.start();
    }
}
