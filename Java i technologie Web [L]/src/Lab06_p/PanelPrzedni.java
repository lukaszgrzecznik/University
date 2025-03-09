package Lab6_p;

import java.util.concurrent.TimeUnit;

public class PanelPrzedni {
    public static void show(String message) {
        System.out.printf("%s", message);
        System.out.println();
    }

    public static void showStatus(String message) {
        System.out.printf("%s", message);
        System.out.println();
    }

    public static void showError(String message) {
        System.out.printf("Błąd: %s", message);
        System.out.println();
    }

    public static void showWarning(String message) {
        System.out.printf("Uwaga: %s", message);
        System.out.println();
    }

    public static void showSuccess(String message) {
        System.out.printf("%s", message);
        System.out.println();
    }

    public static void showInput(String message) {
        System.out.printf("%s", message);
        System.out.println();
    }

    public static void loading(int ms) {
        char loadingChar = '>';
        double variation = 0.25;
        int loadingLength = 20;

        System.out.print("Ładowanie: ");
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < loadingLength; i++) {
            System.out.printf("%c", loadingChar);
            try {
                double timeout = Math.random() * ((ms * (1 + variation)) / loadingLength) + ((ms * variation) / loadingLength);
                TimeUnit.MILLISECONDS.sleep((long) timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void turnOn() {
        System.out.print("Pralka jest włączona");
    }

    public void turnOff() {
        System.out.print("Pralka jest wyłączona");
    }
}
