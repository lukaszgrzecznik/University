package Lab6_p;

import java.util.Scanner;

public class InterfejsDotykowy {
    private final Scanner scanner = new Scanner(System.in);

    public TypyPrania selectProgram() {
        System.out.println("Wybierz program:");
        System.out.println("1 -> Pranie standardowe");
        System.out.println("2 -> Pranie delikatne");
        System.out.println("3 -> Pranie błyskawiczne");
        System.out.println("4 -> Pranie cieżkie");
        System.out.println("5 -> Pranie Eko");
        System.out.println("6 -> Własny program");

        int choice = scanner.nextInt();
        return switch (choice) {
            case 1 -> TypyPrania.dailyWash();
            case 2 -> TypyPrania.delicateWash();
            case 3 -> TypyPrania.expressWash();
            case 4 -> TypyPrania.heavyDutyWash();
            case 5 -> TypyPrania.ecoWash();
            case 6 -> customizeProgram();
            default -> {
                PanelPrzedni.showError("Niepoprawny wybór, uruchamianie prania standardowego...");
                yield TypyPrania.dailyWash();
            }
        };
    }

    public TypyPrania customizeProgram() {
        PanelPrzedni.showInput("Ustaw temperaturę wody: ");
        int temperature = scanner.nextInt();

        PanelPrzedni.showInput("Ustaw czas prania wstępnego w minutach: ");
        int preWashTime = scanner.nextInt();

        PanelPrzedni.showInput("Ustaw czas prania głównego w minutach: ");
        int mainWashTime = scanner.nextInt();

        PanelPrzedni.showInput("Dodatkowe płukanie (true/false): ");
        boolean extraRinsing = scanner.nextBoolean();

        PanelPrzedni.showInput("Ustaw prędkość wirowania (RPM): ");
        int spinSpeed = scanner.nextInt();

        return new TypyPrania(temperature, preWashTime, mainWashTime, extraRinsing, spinSpeed);
    }
}
