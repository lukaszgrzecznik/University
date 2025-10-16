package Lab1.Prostokat;

public class Prostokat {
    private String nazwa;
    private double bok1;
    private double bok2;

    public Prostokat(String nazwa, double bok1, double bok2) {
        this.nazwa = nazwa;
        this.bok1 = bok1;
        this.bok2 = bok2;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double obliczPole() {
        return bok1 * bok2;
    }

    @Override
    public String toString() {
        return "Prostokąt " + nazwa + ": bok1 = " + bok1 + ", bok2 = " + bok2 + ", pole = " + obliczPole();
    }
}
