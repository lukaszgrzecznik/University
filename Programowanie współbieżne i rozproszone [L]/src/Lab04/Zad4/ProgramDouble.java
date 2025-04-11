package Lab04.Zad4;

import java.util.Random;

public class ProgramDouble {

    static final int WIELKOSC_TABLICY = 200_000_000;
    static final double[] tablica = new double[WIELKOSC_TABLICY];

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
            tablica[i] = random.nextDouble();
        }
    }

    static long liczenieMinMax(int uruchomWatki) throws InterruptedException {
        Thread[] watki = new Thread[uruchomWatki];
        MinMaxDoubleWynik[] wyniki = new MinMaxDoubleWynik[uruchomWatki];
        int elementyNaJedenWatek = WIELKOSC_TABLICY / uruchomWatki;

        long start = System.nanoTime();

        for (int i = 0; i < uruchomWatki; i++) {
            int startIndeks = i * elementyNaJedenWatek;
            int koniecIndeks = (i == uruchomWatki - 1) ? WIELKOSC_TABLICY - 1 : startIndeks + elementyNaJedenWatek - 1;
            wyniki[i] = new MinMaxDoubleWynik();
            watki[i] = new Thread(new ZadanieMinMaxDouble(tablica, startIndeks, koniecIndeks, wyniki[i]));
            watki[i].start();
        }

        for (Thread w : watki) w.join();

        double globalneMin = wyniki[0].min;
        double globalneMax = wyniki[0].max;
        for (int i = 1; i < uruchomWatki; i++) {
            if (wyniki[i].min < globalneMin) globalneMin = wyniki[i].min;
            if (wyniki[i].max > globalneMax) globalneMax = wyniki[i].max;
        }

        long koniec = System.nanoTime();
        long czas = (koniec - start) / 1_000_000;
        return czas;
    }
}

class MinMaxDoubleWynik {
    double min = Double.MAX_VALUE;
    double max = -Double.MAX_VALUE;
}

class ZadanieMinMaxDouble implements Runnable {
    private final double[] tablica;
    private final int start, koniec;
    private final MinMaxDoubleWynik wynik;

    public ZadanieMinMaxDouble(double[] tablica, int start, int koniec, MinMaxDoubleWynik wynik) {
        this.tablica = tablica;
        this.start = start;
        this.koniec = koniec;
        this.wynik = wynik;
    }

    public void run() {
        double lokalneMin = tablica[start];
        double lokalneMax = tablica[start];
        for (int i = start + 1; i <= koniec; i++) {
            if (tablica[i] < lokalneMin) lokalneMin = tablica[i];
            if (tablica[i] > lokalneMax) lokalneMax = tablica[i];
        }
        wynik.min = lokalneMin;
        wynik.max = lokalneMax;
    }
}
