package Lab6_p;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Pralka {
    private final GrzalkaWody heater;
    private final Beben drum;
    private final PompaWody waterPump;
    private final PanelPrzedni controlPanel;
    private final PredkoscWirowania speedController;
    private final TemperaturaWody temperatureSensor;
    private final PoziomWody waterLevelSensor;
    private final WagaBebna weightSensor;
    private final SprawdzenieFiltru filterSensor;
    private final InterfejsDotykowy touchInterface;

    public Pralka() {
        this.heater = new GrzalkaWody();
        this.drum = new Beben();
        this.waterPump = new PompaWody();
        this.controlPanel = new PanelPrzedni();
        this.speedController = new PredkoscWirowania();
        this.temperatureSensor = new TemperaturaWody();
        this.waterLevelSensor = new PoziomWody();
        this.weightSensor = new WagaBebna();
        this.filterSensor = new SprawdzenieFiltru();
        this.touchInterface = new InterfejsDotykowy();
    }

    public void start() {
        System.out.print("Naciśnij Enter aby rozpocząć");
        try {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        } catch (Exception e) {
            System.err.println("Błąd: " + e.getMessage());
        }
        controlPanel.turnOn();
        System.out.println();

        TypyPrania program = touchInterface.selectProgram();
        System.out.println();
        PanelPrzedni.showStatus("Uruchomiono wybrany program");
        runProgram(program);
    }

    public void stop() {
        System.out.println();
        PanelPrzedni.showStatus("Zatrzymywanie pralki");
        waterPump.drainWater();
        speedController.stopSpinning();
        System.out.println("Program zakończony");
        controlPanel.turnOff();
    }

    public void stop(boolean emergency) {
        PanelPrzedni.showStatus("Zatrzymywanie pralki");
        waterPump.drainWater();
        speedController.stopSpinning();
        if (!emergency) {
            PanelPrzedni.showError("Program został przerwany");
        } else {
            PanelPrzedni.show("Program zakończony.");
        }
        controlPanel.turnOff();
    }

    private void runProgram(TypyPrania program) {
        double loadWeight = weightSensor.measureWeight();
        if (loadWeight > 8.0) {
            PanelPrzedni.showError("Proszę zmniejszyć obciążenie, pralka przeciążona.");
            stop(true);
            return;
        }

        PanelPrzedni.showStatus("Teraz: Pompowanie wody");
        waterPump.pumpWater();
        if (!waterLevelSensor.checkWaterLevel()) {
            PanelPrzedni.showError("Niewystarczający poziom wody");
            stop(true);
            return;
        }

        heater.setTemperature(program.getTemperature());
        heater.heatWater(temperatureSensor);
        if (!temperatureSensor.checkTemperature(program.getTemperature())) {
            PanelPrzedni.showError("Nie można osiągnąć docelowej temperatury");
            stop(true);
            return;
        }

        if (!filterSensor.isFilterClear()) {
            PanelPrzedni.showWarning("Filtr wymaga czyszczenia");
            filterSensor.cleanFilter();
        }

        PanelPrzedni.showStatus("Teraz: Wyważanie bębna");
        drum.balance();

        System.out.println();
        PanelPrzedni.show("Pranie wstępne przez " + program.getPreWashTime() + " minut.");
        simulateProcess(program.getPreWashTime());

        PanelPrzedni.show("Pranie główne przez " + program.getMainWashTime() + " minut.");
        simulateProcess(program.getMainWashTime());

        if (program.hasExtraRinsing()) {
            PanelPrzedni.showStatus("Teraz: Dodatkowe płukanie");
            simulateProcess(5);
        }

        PanelPrzedni.showStatus("Prędkość wirowania wynosi " + program.getSpinSpeed() + " RPM...");
        speedController.setSpinSpeed(program.getSpinSpeed());
        speedController.startSpinning();

        stop();
    }

    private void simulateProcess(int durationInMinutes) {
        try {
            TimeUnit.MILLISECONDS.sleep(durationInMinutes * 1000L / 4);
        } catch (InterruptedException e) {
            PanelPrzedni.showError("Proces przerwany: " + e.getMessage());
        }
    }
}
