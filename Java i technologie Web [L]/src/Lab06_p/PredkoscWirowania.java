package Lab6_p;

public class PredkoscWirowania {
    private int spinSpeed;

    public void setSpinSpeed(int rpm) {
        this.spinSpeed = rpm;
        PanelPrzedni.showStatus("Ustawianie prędkości wirowania do " + spinSpeed + " RPM...");
    }

    public void startSpinning() {
        PanelPrzedni.showStatus("Bęben rozkręca się do " + spinSpeed + " RPM...");
        PanelPrzedni.loading(5000);
    }

    public void stopSpinning() {
        System.out.println();
        PanelPrzedni.showStatus("Bęben zatrzymuje sie.");
        PanelPrzedni.loading(5500);
        System.out.println();
        PanelPrzedni.show("Bęben przestał się kręcić.");
    }
}
