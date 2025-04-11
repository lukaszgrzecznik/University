package Lab03.Zad4;

public class Main {
    public static void main(String[] args) {
        Watek[] threads = {
                new Watek("Watek1", "W1"),
                new Watek("Watek2", "W2"),
                new Watek("Watek3", "W3"),
                new Watek("Watek4", "W4"),
                new Watek("Watek5", "W5")
        };

        for (int i = 4; i >= 0; i--) {
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Koniec programu.");
    }
}