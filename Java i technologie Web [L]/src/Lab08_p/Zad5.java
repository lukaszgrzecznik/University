package Lab8_p;

import java.util.ArrayList;
import java.util.List;

public class Zad5 {
    public static void main(String[] args) {
        List<Samochod> carList = new ArrayList<>();
        Samochod auto1 = new Samochod();
        auto1.setMarka("Toyota");
        auto1.setModel("Corolla");
        auto1.setTyp_nadwozia("Hatchback");
        auto1.setTyp_silnika("Benzyna");
        auto1.setPojemnosc_silnika(1.6);
        auto1.setRok_produkcji(2018);
        auto1.setData_pierwszej_rejestracji("2019-05-12");

        Samochod auto2 = new Samochod();
        auto2.setMarka("Honda");
        auto2.setModel("Civic");
        auto2.setTyp_nadwozia("Hatchback");
        auto2.setTyp_silnika("Benzyna");
        auto2.setPojemnosc_silnika(2.0);
        auto2.setRok_produkcji(2020);
        auto2.setData_pierwszej_rejestracji("2020-08-10");

        Samochod auto3 = new Samochod();
        auto3.setMarka("Ford");
        auto3.setModel("Fiesta");
        auto3.setTyp_nadwozia("Kombi");
        auto3.setTyp_silnika("Diesel");
        auto3.setPojemnosc_silnika(1.2);
        auto3.setRok_produkcji(2017);
        auto3.setData_pierwszej_rejestracji("2018-03-15");

        carList.add(auto1);
        carList.add(auto2);
        carList.add(auto3);

        System.out.println("Lista samochodów:");
        carList.forEach(Samochod::Wyswietl);

        System.out.println("\nPosortowane pojemności silnika (rosnąco):");
        carList.stream()
                .map(Samochod::getPojemnosc_silnika)
                .sorted()
                .forEach(System.out::println);
    }
}
