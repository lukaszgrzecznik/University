package Lab11_p;

import java.util.Scanner;

public class Zad1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj a: ");
        int a = sc.nextInt();

        System.out.print("Podaj b: ");
        int b = sc.nextInt();

        System.out.printf("a / b = %d / %d = ", a, b);
        try {
            System.out.println(dzielenie(a, b));
        } catch (ArithmeticException e) {
            throw new ArithmeticException(e.getMessage() + ": Nie dziel przez zero");
        }
    }

    static double dzielenie(int a, int b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("[Div0]");
        return (double) a / b;
    }
}
