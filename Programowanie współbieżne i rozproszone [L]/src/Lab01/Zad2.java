package Lab01;

import java.util.Scanner;

public class Zad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę: ");
        int liczba = scanner.nextInt();
        scanner.close();

        if (czyPierwsza(liczba)) {
            System.out.println(liczba + " jest liczbą pierwszą.");
        } else {
            System.out.println(liczba + " nie jest liczbą pierwszą.");
        }
    }

    public static boolean czyPierwsza(int liczba) {
        if (liczba < 2)
            return false;
        for (int i = 2; i * i <= liczba; i++) {
            if (liczba % i == 0)
                return false;
        }
        return true;
    }
}

