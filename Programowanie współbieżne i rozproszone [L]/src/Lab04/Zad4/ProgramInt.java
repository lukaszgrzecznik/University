package Lab04.Zad4;

import java.util.Random;

public class ProgramInt {

    static final int WIELKOSC_TABLICY = 200_000_000;
    static final int[] tablica = new int[WIELKOSC_TABLICY];

    public static void main(String[] args) throws InterruptedException {
        wypelnienieTablicy();
        int[] liczbaWatkow = {1, 2, 3, 4, 5, 6, 7, 8, 20, 100, 500};
        for (int licznikWatkow : liczbaWatkow) {
            long t = liczenieMinMax(licznikWatkow);
            System.out.println("Wątki: " + licznikWatkow + " - czas (ms): " + t);
        }
    }

    static void wypelnienieTablicy() {
        Random random = new Random();
        for (int i = 0; i < WIELKOSC_TABLICY; i++) {
            tablica[i] = random.nextInt();
        }
    }

    static long liczenieMinMax(int uruchomWatki) throws InterruptedException {
        Thread[] threads = new Thread[uruchomWatki];
        MinMaxIntWynik[] wynik = new MinMaxIntWynik[uruchomWatki];
        int elementyNaJedenWatek = WIELKOSC_TABLICY / uruchomWatki;

        long start = System.nanoTime();

        for (int i = 0; i < uruchomWatki; i++) {
            int startIndeks = i * elementyNaJedenWatek;
            int koniecIndeks = (i == uruchomWatki - 1) ? WIELKOSC_TABLICY - 1 : startIndeks + elementyNaJedenWatek - 1;
            wynik[i] = new MinMaxIntWynik();
            threads[i] = new Thread(new ZadanieMinMaxInt(tablica, startIndeks, koniecIndeks, wynik[i]));
            threads[i].start();
        }

        for (Thread t : threads) t.join();

        int globalneMin = wynik[0].min;
        int globalneMax = wynik[0].max;
        for (int i = 1; i < uruchomWatki; i++) {
            if (wynik[i].min < globalneMin) globalneMin = wynik[i].min;
            if (wynik[i].max > globalneMax) globalneMax = wynik[i].max;
        }

        long end = System.nanoTime();
        long czas = (end - start) / 1_000_000;
        return czas;
    }
}

class MinMaxIntWynik {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
}

class ZadanieMinMaxInt implements Runnable {
    private final int[] tablica;
    private final int start, koniec;
    private final MinMaxIntWynik wynik;

    public ZadanieMinMaxInt(int[] tablica, int start, int koniec, MinMaxIntWynik wynik) {
        this.tablica = tablica;
        this.start = start;
        this.koniec = koniec;
        this.wynik = wynik;
    }

    public void run() {
        int lokalneMin = tablica[start];
        int lokalneMax = tablica[start];
        for (int i = start + 1; i <= koniec; i++) {
            if (tablica[i] < lokalneMin) lokalneMin = tablica[i];
            if (tablica[i] > lokalneMax) lokalneMax = tablica[i];
        }
        wynik.min = lokalneMin;
        wynik.max = lokalneMax;
    }
}

