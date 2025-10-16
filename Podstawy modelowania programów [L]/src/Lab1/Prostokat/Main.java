package Lab1.Prostokat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static boolean sprawdzenie(List<Prostokat> figury, String nazwa) {
        if (figury.stream().anyMatch(f -> f.getNazwa().equals(nazwa))) {
            System.out.println("Figura o nazwie " + nazwa + " już istnieje");
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        List<Prostokat> figury = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Witaj! Co chcesz zrobić?");
            System.out.println("1. Dodajemy prostokąt");
            System.out.println("2. Dodajemy kwadrat");
            System.out.println("3. Usuwamy figurę");
            System.out.println("4. Wyświetlamy figury");
            System.out.println("5. Kończymy");
            System.out.print("Wybierz opcję: ");

            int opcja = scanner.nextInt();
            scanner.nextLine();

            switch (opcja) {
                case 1 -> {
                    System.out.print("Podaj nazwę prostokąta: ");
                    String nazwa = scanner.nextLine().toUpperCase();
                    if (sprawdzenie(figury, nazwa)) {
                        break;
                    }
                    System.out.print("Podaj długość pierwszego boku: ");
                    double bok1 = scanner.nextDouble();
                    System.out.print("Podaj długość drugiego boku: ");
                    double bok2 = scanner.nextDouble();
                    figury.add(new Prostokat(nazwa, bok1, bok2));
                }
                case 2 -> {
                    System.out.print("Podaj nazwę kwadratu: ");
                    String nazwa = scanner.nextLine().toUpperCase();
                    if (sprawdzenie(figury, nazwa)) {
                        break;
                    }
                    System.out.print("Podaj długość boku: ");
                    double bok = scanner.nextDouble();
                    figury.add(new Kwadrat(nazwa, bok));
                }
                case 3 -> {
                    System.out.print("Podaj nazwę figury do usunięcia: ");
                    String nazwa = scanner.nextLine().toUpperCase();
                    if (figury.removeIf(f -> f.getNazwa().equals(nazwa))) {
                        System.out.println("Figura o nazwie " + nazwa + " została usunięta");
                    } else {
                        System.out.println("Figura o nazwie " + nazwa + " nie istnieje");
                    }
                }
                case 4 -> {
                    if (figury.isEmpty()) {
                        System.out.println("Brak figur w zbiorze.");
                    } else {
                        double lacznePole = 0;
                        for (Prostokat f : figury) {
                            System.out.println(f);
                            lacznePole += f.obliczPole();
                        }
                        System.out.println("Łączne pole wszystkich figur: " + lacznePole);
                    }
                }
                case 5 -> running = false;
                default -> System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        }

        scanner.close();
        System.out.println("Program zakończony.");
    }
}