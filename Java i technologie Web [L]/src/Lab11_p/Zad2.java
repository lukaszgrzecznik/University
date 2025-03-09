package Lab11_p;

class MojWyjatek extends Exception {
    public MojWyjatek(String message) {
        super(message);
    }
}

public class Zad2 {
    public static void SprawdzenieWieku(int wiek) throws MojWyjatek {
        if (wiek < 18) {
            throw new MojWyjatek("Wiek jest zbyt mały, aby kontynuować.");
        }
        System.out.println("Wiek jest wystarczający.");
    }
    public static void main(String[] args) {
        try {
            System.out.println("Sprawdzanie wieku dla: 20");
            SprawdzenieWieku(20);
        } catch (MojWyjatek e) {

            System.err.println("Wystąpił wyjątek: " + e.getMessage());
        }
        try {
            System.out.println("Sprawdzanie wieku dla: 16");
            SprawdzenieWieku(16);
        } catch (MojWyjatek e) {
            System.err.println("Wystąpił wyjątek: " + e.getMessage());
        }
    }
}