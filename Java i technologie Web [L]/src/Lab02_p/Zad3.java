package Lab2_p;

public class Zad3 {
    public static void main(String[] args) {
        System.out.print("Podaj predkosc w milach: ");
        double mile = new java.util.Scanner(System.in).nextDouble();
        double kilometr = mile * 1.609344;
        System.out.print("Predkosc w km/h wynosi: " + kilometr);
    }
}
