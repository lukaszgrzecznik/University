package Lab02.Zad2;

public class Watek2 extends Thread {
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Watek2: " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
