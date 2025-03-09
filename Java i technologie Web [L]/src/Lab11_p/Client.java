package Lab11_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Client {
    private static final String ID = "[Klient] ";
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            String serverMessage = in.readLine();
            System.out.println(ID + "Otrzymano od serwera: " + serverMessage);
            if ("Komunikat dla klienta".equals(serverMessage)) {
                out.println("Nawiązano komunikacje, wysłano odpowiedź");
                System.out.println(ID + "Wysłano odpowiedź do serwera.");
            }
            TimeUnit.SECONDS.sleep(120);
            System.out.println(ID + "Oczekiwanie przez 120 sekund.");
            out.println("Kończę pracę");
            System.out.println(ID +  "Kończę pracę i zamykam połączenie.");
        } catch (IOException | InterruptedException e) {
            System.out.print(ID);
            System.err.println("Wystąpił błąd: " + e.getMessage());
        }
    }
}
