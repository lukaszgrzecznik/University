package Lab3_p;
import java.util.Scanner;
import java.util.Random;
public class Zad3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int liczba = (new Random()).nextInt(200) + 1;
        int zgadywana_liczba;
        do {
            System.out.print(liczba);
            System.out.print("Wpisz liczbe: ");
            zgadywana_liczba = sc.nextInt();
            if (zgadywana_liczba < liczba) {
                System.out.println("Liczba jest za mala");
            } else if (zgadywana_liczba > liczba) {
                System.out.println("Liczba jest za duza");
            } else {
                System.out.println("Odgadles liczbe: " + liczba);
            }
        } while (zgadywana_liczba != liczba);
    }
}
