package Lab6_p;

import java.util.Random;

public class SprawdzenieFiltru {
    private boolean isClear;

    public SprawdzenieFiltru() {
        this.isClear = true;
    }

    public boolean isFilterClear() {
        isClear = new Random().nextBoolean();
        return isClear;
    }

    public void cleanFilter() {
        PanelPrzedni.showStatus("Czyszczenie filtru");
        PanelPrzedni.loading(5000);
        isClear = true;
        System.out.println();
        PanelPrzedni.showSuccess("Filtr został wyczyszczony");
    }
}