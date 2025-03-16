package Lab01;

public class Zad1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        strzalka();
    }

    public static void strzalka() {
        int[] ilosc = {1, 3, 5, 7, 9, 11, 1, 1, 1};
        int max_szerokosc = 11;

        for (int gwiazdka : ilosc) {
            srodek(gwiazdka, max_szerokosc);
        }
    }

    private static void srodek(int ilosc, int max_szerokosc) {
        int spacja = (max_szerokosc - ilosc) / 2;

        for (int i = 0; i < spacja; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < ilosc; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}


