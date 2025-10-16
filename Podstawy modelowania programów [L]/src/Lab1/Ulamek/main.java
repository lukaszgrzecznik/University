package Lab1.Ulamek;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Calosc obiekt = new Calosc();
        Scanner sc = new Scanner(System.in);
        System.out.println("Calosc: ");
        obiekt.setCalosc(sc.nextInt());
        System.out.println("Licznik: ");
        obiekt.setLicznik(sc.nextInt());
        System.out.println("Mianownik: ");
        obiekt.setMianownik(sc.nextInt());
        obiekt.print();
        obiekt.printflip();
        obiekt.printskrocone();
    }
}
