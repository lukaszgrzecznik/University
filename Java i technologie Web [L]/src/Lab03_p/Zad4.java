package Lab3_p;
import java.util.Scanner;
public class Zad4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int liczba;
        int iloczyn = 1;
        do {
            System.out.print("Wpisz liczbe: ");
            liczba = sc.nextInt();
            if (liczba != 5) {
                iloczyn *= liczba;
            }
        } while (liczba != 5);
        System.out.println("Iloczyn podanych liczb wynosi: " + iloczyn);
    }
}
