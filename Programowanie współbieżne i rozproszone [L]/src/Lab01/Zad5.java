package Lab01;
import java.util.Random;
public class Zad5 {
    public static void main(String[] args) {
        int wiersze1 = 4;
        int kolumny1 = 3;

        int wiersze2 = 3;
        int kolumny2 = 5;

        int[][] macierz1 = new int[wiersze1][kolumny1];
        int[][] macierz2 = new int[wiersze2][kolumny2];
        int[][] wynik = new int[wiersze1][kolumny2];
        Random random = new Random();

        losoweWartosci(macierz1, random);
        losoweWartosci(macierz2, random);

        mnozenieMacierzy(macierz1, macierz2, wynik);

        System.out.println("Macierz 1:");
        wynikMnozenia(macierz1);
        System.out.println("\nMacierz 2:");
        wynikMnozenia(macierz2);
        System.out.println("\nWynik Mnozenia:");
        wynikMnozenia(wynik);
    }

    private static void losoweWartosci(int[][] macierz, Random random) {
        for (int i = 0; i < macierz.length; i++) {
            for (int j = 0; j < macierz[i].length; j++) {
                macierz[i][j] = random.nextInt(100);
            }
        }
    }

    private static void mnozenieMacierzy(int[][] macierz1, int[][] macierz2, int[][] wynik) {
        for (int i = 0; i < macierz1.length; i++) {
            for (int j = 0; j < macierz2[0].length; j++) {
                wynik[i][j] = 0;
                for (int k = 0; k < macierz1[0].length; k++) {
                    wynik[i][j] += macierz1[i][k] * macierz2[k][j];
                }
            }
        }
    }

    private static void wynikMnozenia(int[][] macierz) {
        for (int[] wiersz : macierz) {
            for (int wartosc : wiersz) {
                System.out.print(wartosc + "\t");
            }
            System.out.println();
        }
    }
}
