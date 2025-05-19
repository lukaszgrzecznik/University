package Lab08.Zad01;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread seller = new Thread(() -> {
            try {
                String sellerData = "Bilet do filharmonii";
                System.out.println("Oliwer widzi debila i proponuje mu: " + sellerData);
                sellerData = exchanger.exchange(sellerData);
                System.out.println("Oliwer nabrał frajera i ma teraz: " + sellerData);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Kierownik złoty wrócił do sklepu.");
            }
        });

        Thread client = new Thread(() -> {
            try {
                String clientData = "30 złotych";
                System.out.println("Łukasz stwierdza że może by poszedł do filharmonii i ma: " + clientData);
                clientData = exchanger.exchange(clientData);
                System.out.println("Łukasz nie wie co się dzieje wokół niego ale przynajmniej ma: " + clientData);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Menel poszedł do domu.");
            }
        });

        seller.start();
        client.start();
    }
}
