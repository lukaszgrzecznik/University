package Lab5_p;

import java.util.Scanner;

public class Zad1 {
    public static void main(String[] args) {
        Samochod samochod = new Samochod();
        Scanner sc = new Scanner(System.in);
        System.out.println("Marka: ");
        samochod.setMarka(sc.nextLine());
        System.out.println("Model: ");
        samochod.setModel(sc.nextLine());
        System.out.println("Typ nadwozia: ");
        samochod.setTyp_nadwozia(sc.nextLine());
        System.out.println("Typ silnika: ");
        samochod.setTyp_silnika(sc.nextLine());
        System.out.println("Pojemnosc: ");
        samochod.setPojemnosc_silnika(Double.parseDouble(sc.nextLine()));
        System.out.println("Cena: ");
        samochod.setCena(Double.parseDouble(sc.nextLine()));
        System.out.println("Rok produkcji: ");
        samochod.setRok_produkcji(Integer.parseInt(sc.nextLine()));
        System.out.println("Data pierwszej rejestracji: ");
        samochod.setData_pierwszej_rejestracji(sc.nextLine());

        System.out.println("Samochod: ");
        samochod.Wyswietl();
    }
}
