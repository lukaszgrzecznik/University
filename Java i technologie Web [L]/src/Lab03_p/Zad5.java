package Lab3_p;
import java.util.Scanner;
public class Zad5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Wpisz liczbe: ");
        int liczba = sc.nextInt();
        int i = 0;
        int potega = 1;
        while (potega < liczba) {
            potega = (int) Math.pow(3, i);
            if (potega < liczba) {
                System.out.print(potega + " ");
            }
            i++;
        }
    }
}
