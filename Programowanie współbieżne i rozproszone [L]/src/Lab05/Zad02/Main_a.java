package Lab05.Zad02;

import java.util.Scanner;

public class Main_a {
    static int a, b;

    public static void main(String[] args) {
        Thread dane1 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj a: ");
            a = scanner.nextInt();
        });

        Thread dane2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj b: ");
            b = scanner.nextInt();
        });

        Thread obliczenia = new Thread(() -> {
            int suma = a + b;
            System.out.println("Suma: " + suma);
        });

        dane1.start();
        dane2.start();
        obliczenia.start();  // Brak gwarancji, że dane1 i dane2 się zakończą przed obliczeniami
    }
}

