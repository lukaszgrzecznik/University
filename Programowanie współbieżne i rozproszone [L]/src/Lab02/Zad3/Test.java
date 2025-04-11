package Lab02.Zad3;

public class Test {
    public static void main(String[] args) {
        Thread w1 = new Thread(new Watek1());
        Thread w2 = new Thread(new Watek2());

        w1.start();
        w2.start();

        try {
            w1.join();
            w2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Koniec programu");
    }
}
