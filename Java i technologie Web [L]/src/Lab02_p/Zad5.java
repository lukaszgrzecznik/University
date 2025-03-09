package Lab2_p;

public class Zad5 {
    public static void main(String[] args) {
        System.out.print("Wpisz pierwsza liczbe: ");
        double a = new java.util.Scanner(System.in).nextDouble();
        System.out.print("Wybierz znak + - * / : ");
        char znak = new java.util.Scanner(System.in).next().charAt(0);
        System.out.print("Wpisz druga liczbe: ");
        double b = new java.util.Scanner(System.in).nextDouble();
        switch (znak){
            case '+':
                double wynik1 = a+b;
                System.out.print(wynik1);
                break;
            case '-':
                double wynik2 = a-b;
                System.out.print(wynik2);
                break;
            case '*':
                double wynik3 = a*b;
                System.out.print(wynik3);
                break;
            case '/':
                if (b == 0){
                    System.out.print("Nie dzieli sie przez 0");
                    break;
                }
                double wynik4 = a/b;
                System.out.print(wynik4);
                break;
        }
    }
}
