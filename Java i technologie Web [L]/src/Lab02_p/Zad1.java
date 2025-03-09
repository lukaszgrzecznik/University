package Lab2_p;

public class Zad1 {
    public static void main(String[] args) {
        System.out.print("Podaj wysokosc: ");
        int wysokosc = new java.util.Scanner(System.in).nextInt();
        for (int i = 1; i <= wysokosc ; i++) {
            for (int j = 1; j <= wysokosc - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
