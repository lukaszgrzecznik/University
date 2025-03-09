package Lab5_p.Zad5;

public class Pompa {
    private double cisnienie;

    public Pompa() {
        this.cisnienie = 0;
    }

    public void wlaczPompe(String typ) {
        System.out.println("Włączam pompę dla: " + typ);
    }

    public void ustawCisnienie(double cisnienie) {
        this.cisnienie = cisnienie;
        System.out.println("Ustawione ciśnienie pompy: " + cisnienie + " barów");
    }

    public double getCisnienie() {
        return cisnienie;
    }
}
