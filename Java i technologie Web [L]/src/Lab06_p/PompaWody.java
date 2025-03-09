package Lab6_p;

public class PompaWody {
    public void pumpWater() {
        PanelPrzedni.showStatus("Pompowanie wody do bębna");
        PanelPrzedni.loading(4000);
    }

    public void drainWater() {
        PanelPrzedni.showStatus("Odprowadzanie wody z bębna");
        PanelPrzedni.loading(10000);
    }
}
