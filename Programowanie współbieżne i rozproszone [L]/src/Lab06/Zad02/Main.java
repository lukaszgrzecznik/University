package Lab06.Zad02;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int LICZBA_OSOB = 3;
    public static final int LICZBA_TELEFONOW = 2;

    public static void main(String[] args) {
        Semaphore telefon = new Semaphore(LICZBA_TELEFONOW);

        Thread[] osoby = new Thread[LICZBA_OSOB];
        String[] imiona = {"Mama", "Tata", "Dziecko"};

        for (int i = 0; i < LICZBA_OSOB; i++) {
            osoby[i] = new Osoba(imiona[i], telefon);
            osoby[i].start();
        }
    }
}

class Osoba extends Thread {
    private static final Random random = new Random();
    private final Semaphore telefon;

    public Osoba(String name, Semaphore telefon) {
        super(name);
        this.telefon = telefon;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            czytanieKsiazki();
            picieHerbaty();
            rozmowaTelefoniczna();
            pracaPrzyKomputerze();
        }
    }

    private void czytanieKsiazki() {
        System.out.println(getName() + " czyta książkę.");
        losoweOpoznienie();
    }

    private void picieHerbaty() {
        System.out.println(getName() + " pije herbatę.");
        losoweOpoznienie();
    }

    private void rozmowaTelefoniczna() {
        try {
            System.out.println(getName() + " chce rozmawiać przez telefon.");
            telefon.acquire();
            System.out.println(getName() + " rozmawia przez telefon...");
            losoweOpoznienie();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(getName() + " kończy rozmowę przez telefon.");
            telefon.release();
        }
    }

    private void pracaPrzyKomputerze() {
        System.out.println(getName() + " pracuje przy komputerze.");
        losoweOpoznienie();
    }

    private void losoweOpoznienie() {
        try {
            Thread.sleep(random.nextInt(1000) + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

