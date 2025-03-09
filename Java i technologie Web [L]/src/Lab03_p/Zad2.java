package Lab3_p;
import java.util.Scanner;
public class Zad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Wpisz liczbe: ");
        int liczba = sc.nextInt();
        System.out.println("Dzielniki wpisanej liczby to: ");
        for (int i = 1; i <= liczba; i++) {
            if (liczba % i == 0) {
                System.out.print(i + ",");
            }
        }
    }
}
