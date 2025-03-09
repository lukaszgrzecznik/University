package Lab2_p;
import java.util.Scanner;
public class Zad4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int suma = 0;
        System.out.print("Wpisz ilosc liczb: ");
        int ilosc = scanner.nextInt();
        System.out.print("Wpisz liczbe: ");
        int liczba = scanner.nextInt();
        int min = liczba;
        int max = liczba;
        suma += liczba;
        for (int i = 2; i <= ilosc; i++){
            System.out.print("Wpisz liczbe: ");
            liczba = new java.util.Scanner(System.in).nextInt();
            if (liczba < min){
                min = liczba;
            }
            if (liczba > max){
                max = liczba;
            }
            suma += liczba;
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Srednia: " + (double) suma / ilosc);
        System.out.println("Ilosc: " + ilosc);
        }

}
