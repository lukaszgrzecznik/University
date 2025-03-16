package Lab01;

import java.util.Arrays;
import java.util.Random;

public class Zad3 {
    public static void main(String[] args) {
        int rozmiar = 10;
        int[] tablica = new int[rozmiar];
        Random random = new Random();

        for (int i = 0; i < rozmiar; i++) {
            tablica[i] = random.nextInt(100);
        }

        System.out.println("Tablica: " + Arrays.toString(tablica));

        int min = tablica[0], max = tablica[0];
        for (int liczba : tablica) {
            if (liczba < min) min = liczba;
            if (liczba > max) max = liczba;
        }
        System.out.println("Najmniejszy: " + min + ", Największy: " + max);

        int[] trzyNajwieksze = trzynajwieksze(tablica);
        System.out.println("3 największe liczby: " + Arrays.toString(trzyNajwieksze));

        double suma = 0;
        for (int liczba : tablica) suma += liczba;
        double srednia = suma / rozmiar;
        System.out.println("Średnia: " + srednia);

        System.out.print("Tablica w odwrotnej kolejności: ");
        for (int i = rozmiar - 1; i >= 0; i--) {
            System.out.print(tablica[i] + " ");
        }
        System.out.println();

        odwroconatablica(tablica);
        System.out.println("Tablica po odwróceniu: " + Arrays.toString(tablica));
    }

    private static int[] trzynajwieksze(int[] tablica) {
        int pierwszy = Integer.MIN_VALUE, drugi = Integer.MIN_VALUE, trzeci = Integer.MIN_VALUE;
        for (int liczba : tablica) {
            if (liczba > pierwszy) {
                trzeci = drugi;
                drugi = pierwszy;
                pierwszy = liczba;
            } else if (liczba > drugi) {
                trzeci = drugi;
                drugi = liczba;
            } else if (liczba > trzeci) {
                trzeci = liczba;
            }
        }
        return new int[]{pierwszy, drugi, trzeci};
    }

    private static void odwroconatablica(int[] tablica) {
        int lewo = 0, prawo = tablica.length - 1;
        while (lewo < prawo) {
            int temp = tablica[lewo];
            tablica[lewo] = tablica[prawo];
            tablica[prawo] = temp;
            lewo++;
            prawo--;
        }
    }
}

