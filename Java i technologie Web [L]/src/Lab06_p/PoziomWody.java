package Lab6_p;

public class PoziomWody {
    private int waterLevel;

    public void readWaterLevel() {
        this.waterLevel = 10;
    }

    public boolean isWaterLevelSafe() {
        return waterLevel <= 15;
    }

    public boolean checkWaterLevel() {
        readWaterLevel();
        return isWaterLevelSafe();
    }
}
