package Lab6_p;

public class TemperaturaWody {
    private double currentTemperature;

    public TemperaturaWody() {
        this.currentTemperature = 20.0;
    }

    public void setCurrentTemperature(double temperature) {
        this.currentTemperature = temperature;
    }

    public boolean checkTemperature(double targetTemperature) {
        return currentTemperature >= targetTemperature;
    }

}
