package Lab03.Zad2;

public class LicznikWatkow {
    private int wartoscKrytyczna;
    public synchronized int policzMnie() {
        wartoscKrytyczna += 1;
        wartoscKrytyczna--;
        return wartoscKrytyczna;
    }
}
