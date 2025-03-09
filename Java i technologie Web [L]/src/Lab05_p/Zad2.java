package Lab5_p;

public class Zad2 {
        public static void main(String[] args) {
            Samochod samochod = new Samochod();

            samochod.setMarka("Skoda");
            samochod.setModel("Fabia");
            samochod.setPojemnosc_silnika(1.4);
            samochod.setTyp_nadwozia("Kombi");
            samochod.setTyp_silnika("Benzyna");
            samochod.setRok_produkcji(2003);
            samochod.setData_pierwszej_rejestracji("2005-04-03");
            samochod.setCena(1500.0);

            System.out.println("Samochod: ");
            samochod.Wyswietl();

            String gwarancja = samochod.getGwarancja() ? "Ważna" : "Nieważna";
            System.out.println("Gwarancja samochodu: " + gwarancja);
        }
    }
