package Lab4_p;

public class Zad3 {
    public static void main(String[] args) {
        int[] tablica = new int[40];
        for(int i = 0; i < 40; i++) {
            if (i < 10) {
                tablica[i] = (int) (Math.random() * 5) + 1;
            } else if (i < 20) {
                tablica[i] = (int) (Math.random() * 5) + 6;
            } else if (i < 30) {
                tablica[i] = (int) (Math.random() * 45) + 11;
            } else {
                tablica[i] = (int) (Math.random() * 15) + 60;
            }
        }
        System.out.println("Tablica: ");
        for (int i = 0; i < 40; i++) {
            System.out.print(tablica[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}
