package Lab05.Zad01;
import java.util.Scanner;

public class Main_a {
    static int a, b;
    public static void main(String[] args) {
        Thread dane = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj a: ");
            Main_a.a = scanner.nextInt();
            System.out.print("Podaj b: ");
            Main_a.b = scanner.nextInt();
        });

        Thread obliczenia = new Thread(() -> {
            int suma = a+b;
            System.out.println("Suma: " + suma);
        });

        dane.start();
        obliczenia.start();
    }
}

