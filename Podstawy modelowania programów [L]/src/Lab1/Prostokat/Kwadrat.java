package Lab1.Prostokat;

public class Kwadrat extends Prostokat {
    private double bok;

    public Kwadrat(String nazwa, double bok) {
        super(nazwa, bok, bok);
        this.bok = bok;
    }

    @Override
    public String toString() {
        return "Kwadrat " + getNazwa() + ": bok = " + bok + ", pole = " + obliczPole();
    }
}