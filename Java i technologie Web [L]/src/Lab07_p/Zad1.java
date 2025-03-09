package Lab7_p;

public class Zad1 {
    public static void main(String[] args) {
        Kalkulator kalkulator1 = new Kalkulator(5, 3, 2, 2);
        System.out.println("Wynik dodawania: " + kalkulator1.Obliczenia("dodawanie"));
        Kalkulator kalkulator2 = new Kalkulator(5, 3, 2, 2);
        System.out.println("Wynik odejmowania: " + kalkulator2.Obliczenia("odejmowanie"));
        Kalkulator kalkulator3 = new Kalkulator(2, 3, 4, 5);
        System.out.println("Wynik mnozenia: " + kalkulator3.Obliczenia("mnozenie"));
        Kalkulator kalkulator4 = new Kalkulator(8, 1, 2, 2);
        System.out.println("Wynik dzielenia: " + kalkulator4.Obliczenia("dzielenie"));
    }

public static class Kalkulator{
    private final double[] liczby;
    public Kalkulator (double a){
        liczby = new double[1];
        liczby[0] = a;
    }

    public Kalkulator (double a, double b, double c, double d){
        liczby = new double[4];
        liczby[0] = a;
        liczby[1] = b;
        liczby[2] = c;
        liczby[3] = d;
    }

    public Kalkulator (double a, double b, double c, double d, double e, double f, double g){
        liczby = new double[7];
        liczby[0] = a;
        liczby[1] = b;
        liczby[2] = c;
        liczby[3] = d;
        liczby[4] = e;
        liczby[5] = f;
        liczby[6] = g;
    }

    public Kalkulator(Kalkulator kopia){
        this.liczby = new double[kopia.liczby.length];
        System.arraycopy(kopia.liczby, 0, this.liczby, 0, kopia.liczby.length);
    }
    public double Obliczenia(String operacje) {
        double wynik = 0;

        switch (operacje) {
            case "dodawanie":
                for (double liczba : liczby) {
                    wynik += liczba;
                }
                break;
            case "odejmowanie":
                wynik = liczby[0];
                for (int i = 1; i < liczby.length; i++) {
                    wynik -= liczby[i];
                }
                break;
            case "mnozenie":
                wynik = 1;
                for (double liczba : liczby) {
                    wynik *= liczba;
                }
                break;
            case "dzielenie":
                if (liczby.length > 0) {
                    wynik = liczby[0];
                    for (int i = 1; i < liczby.length; i++) {
                        if (liczby[i] != 0) {
                            wynik /= liczby[i];
                        } else {
                            System.out.println("Nie dzielimy przez 0");
                        }
                    }
                }
                break;
        }
        return wynik;
    }
    }
    }
