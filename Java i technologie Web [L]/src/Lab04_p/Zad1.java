package Lab4_p;

public class Zad1 {
    public static void main(String[] args) {
        int [] tablica1 = new int[30];
        int [] tablica2 = new int[30];
        for (int i = 0; i < 30; i++) {
            tablica1[i] = (int) (Math.random() * 51) + 99;
            System.arraycopy(tablica1, 0, tablica2, 0, 30);
        }
        System.out.print("Tablica 1: ");
        for (int j : tablica1)
        {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.print("Tablica 2: ");
        for (int j : tablica2) {
            System.out.print(j + " ");
        }

    }
}
