package Lab6_p;

import java.util.concurrent.TimeUnit;

public class TypyPrania {
    private final int temperature;
    private final int preWashTime;
    private final int mainWashTime;
    private final boolean extraRinsing;
    private final int spinSpeed;

    public TypyPrania(int temperature, int preWashTime, int mainWashTime, boolean extraRinsing, int spinSpeed) {
        PanelPrzedni.showStatus("Uruchamianie wybranego programu");
        this.temperature = temperature;
        this.preWashTime = preWashTime;
        this.mainWashTime = mainWashTime;
        this.extraRinsing = extraRinsing;
        this.spinSpeed = spinSpeed;
        PanelPrzedni.loading(3000);
    }

    public static TypyPrania dailyWash() {
        return new TypyPrania(40, 10, 30, false, 800);
    }

    public static TypyPrania delicateWash() {
        return new TypyPrania(30, 5, 20, true, 600);
    }

    public static TypyPrania expressWash() {
        return new TypyPrania(20, 0, 15, false, 1000);
    }

    public static TypyPrania heavyDutyWash() {
        return new TypyPrania(60, 15, 45, true, 1200);
    }

    public static TypyPrania ecoWash() {
        return new TypyPrania(30, 10, 25, true, 700);
    }

    public int getTemperature() {
        wait(1000);
        return temperature;
    }

    public int getPreWashTime() {
        wait(800);
        return preWashTime;
    }

    public int getMainWashTime() {
        wait(1200);
        return mainWashTime;
    }

    public boolean hasExtraRinsing() {
        wait(500);
        return extraRinsing;
    }

    public int getSpinSpeed() {
        wait(1000);
        return spinSpeed;
    }

    void wait(int ms){
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            PanelPrzedni.showError("Proces przerwany: " + e.getMessage());
        }
    }
}
