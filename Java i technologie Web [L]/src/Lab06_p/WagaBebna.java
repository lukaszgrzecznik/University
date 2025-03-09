package Lab6_p;

public class WagaBebna {
    private int weight;

    public void readWeight() {
        this.weight = 5000;
        PanelPrzedni.show("Waga Bębna: " + weight + " gram");
    }

    public double measureWeight() {
        readWeight();
        return weight / 1000.0;
    }
}
