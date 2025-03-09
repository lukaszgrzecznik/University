package Lab11_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Server {
    private static final String ID = "[Serwer] ";
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println(ID + "Serwer uruchomiony, oczekiwanie na połączenie");
            Socket socket = serverSocket.accept();
            System.out.println(ID + "Połączono z klientem.");
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                out.println("Komunikat dla klienta");
                System.out.println(ID + "Komunikat wysłany do klienta, oczekiwanie na odpowiedź");
                String response = in.readLine();
                System.out.println(ID + "Odpowiedź klienta: " + response);
                if ("Nawiązano komunikacje, wysłano odpowiedź".equals(response)) {
                    TimeUnit.SECONDS.sleep(5);
                    out.println("Połączenie zatwierdzone");
                    System.out.println(ID + "Połączenie zatwierdzone.");
                } else {
                    System.out.println(ID + "Zła odpowiedź. Serwer kończy pracę.");
                    socket.close();
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.print(ID);
            System.err.println("Wystąpił błąd: " + e.getMessage());
        }
    }
}
