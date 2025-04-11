package Lab02.Zad3;

class Watek2 implements Runnable {
    public void run() {
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
