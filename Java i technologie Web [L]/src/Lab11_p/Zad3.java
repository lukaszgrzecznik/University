package Lab11_p;

public class Zad3 {
    private static final String ID = "[Główny] ";
    public static void main(String[] args) {
        Thread serverThread = new Thread(() -> {
            try {
                Server.main(null);
            } catch (Exception e) {
                System.err.println(ID + "Błąd -> wątek serwera: " + e.getMessage());
            }
        });
        Thread clientThread = new Thread(() -> {
            try {
                Client.main(null);
            } catch (Exception e) {
                System.err.println(ID + "Błąd -> wątek klienta: " + e.getMessage());
            }
        });
        serverThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(ID + "Wątek główny -> przerwany: " + e.getMessage());
        }
        clientThread.start();
        try {
            serverThread.join();
            clientThread.join();
        } catch (InterruptedException e) {
            System.err.println(ID + "Błąd podczas oczekiwania na zakończenie wątków: " + e.getMessage());
        }
        System.out.println(ID + "Koniec działania programu.");
    }
}
