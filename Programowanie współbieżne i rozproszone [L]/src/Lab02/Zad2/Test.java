package Lab02.Zad2;

public class Test {
    public static void main(String[] args) {
        Watek1 w1 = new Watek1();
        Watek2 w2 = new Watek2();
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
