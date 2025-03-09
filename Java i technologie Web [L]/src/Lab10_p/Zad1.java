package Lab10_p;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Zad1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            final int id_watku = i;
            Thread thread = new Thread(() -> {
                String AktualnaData = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                System.out.println("Watek: " + id_watku + "\tdata: " + AktualnaData);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.err.println("Watek: " + id_watku + "zostal przerwany");
            }
            });
            thread.start();
        }
    }
}
