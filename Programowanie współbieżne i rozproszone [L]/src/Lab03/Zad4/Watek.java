package Lab03.Zad4;

class Watek extends Thread {
    private final String message;

    public Watek(String name, String message) {
        super(name);
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Watek: " + getName() + ", Wiadomosc: " + message);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
