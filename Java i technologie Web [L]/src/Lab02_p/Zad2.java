package Lab2_p;

public class Zad2 {
    public static void main(String[] args) {
        System.out.print("Podaj parametr a: ");
        int a = new java.util.Scanner(System.in).nextInt();
        System.out.print("Podaj parametr b: ");
        int b = new java.util.Scanner(System.in).nextInt();
        System.out.print("Podaj parametr c: ");
        int c = new java.util.Scanner(System.in).nextInt();
        double delta = Math.pow(b, 2)-4*a*c;
        System.out.println("Wynik: " + delta);

        if (delta < 0){
            System.out.println("Nie ma rozwiazania");
        }
        if (delta == 0){
            int x1 = -b/2*a;
            System.out.println(x1);
        }
        if (delta > 0){
            double x1 = (-b-Math.sqrt(delta))/(2*a);
            System.out.println(x1);
            double x2 = (-b+Math.sqrt(delta))/(2*a);
            System.out.println(x2);
        }
    }
}
