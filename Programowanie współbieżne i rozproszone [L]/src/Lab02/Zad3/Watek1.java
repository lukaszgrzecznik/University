package Lab02.Zad3;

class Watek1 implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Watek1: " + i);
        }
    }
}