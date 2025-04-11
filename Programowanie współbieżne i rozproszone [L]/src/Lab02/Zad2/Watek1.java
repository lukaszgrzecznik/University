package Lab02.Zad2;

public class Watek1 extends Thread{
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Watek1: " + i);
        }
    }
}
