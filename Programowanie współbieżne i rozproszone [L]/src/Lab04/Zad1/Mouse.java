package Lab04.Zad1;

import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Mouse extends Thread {
    private final Cake cake;
    public Mouse(final Cake cake, final String name) {
        super(name);
        this.cake = cake;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (cake.eat(new Random().nextInt(40)) <= 0) {
                System.out.println("======KONIEC=======");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Cake cake = new Cake();
        Thread mouse1 = new Mouse(cake, "Mysz_1");
        Thread mouse2 = new Mouse(cake, "Mysz_2");
        System.out.println("mouse1=" + mouse1.getState());
        System.out.println("mouse2=" + mouse2.getState());
        mouse1.start();
        mouse2.start();

        while (true) {
            System.out.println("mouse1=" + mouse1.getState());
            System.out.println("mouse2=" + mouse2.getState());
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (mouse1.getState().ordinal()
                    + mouse2.getState().ordinal() == 10) {
                break;
            }
        }
    }
}
