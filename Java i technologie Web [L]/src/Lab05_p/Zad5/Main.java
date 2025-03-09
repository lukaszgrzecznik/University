package Lab5_p.Zad5;

public class Main {
    public static void main(String[] args) {
        EkspresDoKawy ekspres = new EkspresDoKawy();
        PanelSterujacy panel = new PanelSterujacy(ekspres);

        while(true) {
            panel.wybierzKawe();
        }
    }
}
