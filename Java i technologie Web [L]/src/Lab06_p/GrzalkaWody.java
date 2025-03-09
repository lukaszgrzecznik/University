package Lab6_p;

public class GrzalkaWody {
    private int targetTemperature;

    public void setTemperature(int temperature) {
        this.targetTemperature = temperature;
    }

    public void heatWater(TemperaturaWody sensor) {
        System.out.println();
        PanelPrzedni.showStatus("Podgrzewanie wody do " + targetTemperature + "°C");
        PanelPrzedni.loading(7000);
        sensor.setCurrentTemperature(targetTemperature);
        System.out.println();
        PanelPrzedni.showSuccess("Woda podgrzana do " + targetTemperature + "°C");
    }
}
