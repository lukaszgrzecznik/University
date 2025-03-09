package Lab2_p;

public class Zad6 {
    private static double oprocentowanie(int miesiace){
        if (miesiace > 1 && miesiace <= 24) return 0.02;
        if (miesiace > 24 && miesiace <= 48) return 0.03;
        if (miesiace > 48 && miesiace <= 60) return 0.04;
        if (miesiace > 60 && miesiace <= 72) return 0.05;
        if (miesiace > 72 && miesiace <= 96) return 0.06;
        throw new IllegalArgumentException("Poza zakresem");
    }
    public static void main(String[] args) {
        System.out.print("Kapital: ");
        double kapital = new java.util.Scanner(System.in).nextDouble();
        if (kapital > 300000) {
            throw new IllegalArgumentException("Poza zakresem");
        }
        System.out.print("Wklad wlasny: ");
        double wklad = new java.util.Scanner(System.in).nextDouble();
        System.out.print("Ilosc rat: ");
        int miesiace = new java.util.Scanner(System.in).nextInt();
        System.out.print("Miesieczna rata leasingowa: " + platnosc(kapital, wklad, miesiace));
        }
        private static double platnosc(double kapital, double wklad, int miesiace) {
        return (kapital-wklad)*(oprocentowanie(miesiace)+1)/miesiace;
        }
    }
