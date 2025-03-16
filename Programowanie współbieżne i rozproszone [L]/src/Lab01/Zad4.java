package Lab01;
import java.util.Random;

public class Zad4 {
    public static void main(String[] args) {
        int ilosc = 10;
        int[] tablica1 = new int[ilosc];
        int[] tablica2 = new int[ilosc];
        int[] tablica3 = new int[ilosc];
        Random random = new Random();

        losoweLiczby(tablica1, random);
        losoweLiczby(tablica2, random);
        losoweLiczby(tablica3, random);

        int max1 = maksymalnaWartosc(tablica1);
        int max2 = maksymalnaWartosc(tablica2);
        int max3 = maksymalnaWartosc(tablica3);

        int maxWartosc = Math.max(max1, Math.max(max2, max3));

        System.out.println("Maksymalna wartosc w tablicy 1: " + max1);
        System.out.println("Maksymalna wartosc w tablicy 2: " + max2);
        System.out.println("Maksymalna wartosc w tablicy 3: " + max3);
        System.out.println("Maksymalna wartosc: " + maxWartosc);
    }

    private static void losoweLiczby(int[] tablica, Random wartosc) {
        for (int i = 0; i < tablica.length; i++) {
            tablica[i] = wartosc.nextInt(100);
        }
    }

    private static int maksymalnaWartosc(int[] tablica) {
        int max = tablica[0];
        for (int wartosc : tablica) {
            if (wartosc > max) {
                max = wartosc;
            }
        }
        return max;
    }
}
