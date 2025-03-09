package Lab3_p;
import java.util.Scanner;
public class Zad1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbe: ");
        int liczba = sc.nextInt();
        int parzyste = 0;
        int nieparzyste = 0;
        int ilosc_p = 0;
        int ilosc_n = 0;
        int temp = liczba;
        while (temp > 0) {
            int cyfra = temp % 10;
            if (cyfra % 2 == 0) {
                parzyste += cyfra;
                ilosc_p++;
            } else {
                nieparzyste += cyfra;
                ilosc_n++;
            }
            temp /= 10;
        }
        System.out.println("Ilosc parzystych: " + ilosc_p);
        System.out.println("Ilosc nieparzystych: " + ilosc_n);
        double srednia_p = (double) parzyste / ilosc_p;
        double srednia_n = (double) nieparzyste / ilosc_n;
        System.out.println("Srednia parzystych: " + srednia_p);
        System.out.println("Srednia nieparzystych: " + srednia_n);
        System.out.println("Stosunek nieparzystych do parzystych: " + srednia_n / srednia_p);
        if (czyParzysta(liczba)) {
            System.out.println("Liczba pierwsza");
        } else {
            System.out.println("Liczba nie jest pierwsza");
        }
    }

    public static boolean czyParzysta(int liczba) {
        for (int i = 2; i <= Math.sqrt(liczba); i++) {
            if (liczba % i == 0) {
                return false;
            }
        }
        if (liczba < 2) {
            return false;
        }
        return true;
    }
}
