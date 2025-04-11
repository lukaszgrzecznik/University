package Lab03.Zad2;

public class TestWatkow {
    public static void main(String[] args) {
        int tnum = Integer.parseInt(args[0]); // liczba wątków
        int count = Integer.parseInt(args[1]); // liczba powtórzeń pętli w run()
// Tworzymy obiekt klasy balance
        LicznikWatkow licznik = new LicznikWatkow();
// Tworzymy i uruchamiamy wątki
        WatekLiczacy[] thread = new WatekLiczacy[tnum]; // tablica wątków
        for (int i = 0; i < tnum; i++)
            thread[i] = new WatekLiczacy("Watek" + (i + 1), licznik, count);
// czekaj na zakończenie wszystkich wątków
        try {
            for (int i = 0; i < tnum; i++) {thread[i].join();}
        } catch (InterruptedException exc) { System.exit(1); }
        System.out.println("Koniec programu");
    }
}
