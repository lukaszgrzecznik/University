package Lab4_p;

public class Zad2 {
    public static void main(String[] args) {
        int [][] tablica1 = new int [7] [7];
        int [][] tablica2 = new int [7] [7];
        int suma = 0;
        int ilosc = 0;
        double srednia;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                tablica1[i][j] = (int)(Math.random() * 100);
                suma += tablica1[i][j];
                ilosc++;
            }
        }
        int min = tablica1[0][0], max = tablica1[0][0];
        for (int[] lista : tablica1) {
            for (int zmienna : lista) {
                if (zmienna > max) {
                    max = zmienna;
                }
                if (zmienna < min) {
                    min = zmienna;
                }
            }
        }
        srednia = (double) suma / ilosc;
        System.out.println("Tablica 1: ");
        for (int[] i : tablica1) {
            System.out.print("\t");
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
        System.out.println("Najmniejszy element tablicy: " + min);
        System.out.println("Najwiekszy element tablicy: " + max);
        System.out.println("Srednia: " + srednia);
        for (int[] lista : tablica1) {
            for (int zmienna : lista) {
                if (zmienna < srednia) {
                    ilosc++;
                }
            }
        }
        System.out.println("Ilosc elementow mniejszych od sredniej: " + ilosc);
        ilosc = 0;
        for (int[] lista : tablica1) {
            for (int j = 0; j < 7; j++){
                if (lista[j] > srednia) {
                    ilosc++;
                }
            }
        }
        System.out.println("Ilosc elementow wiekszych od sredniej: " + ilosc);
        for (int i = tablica1.length - 1; i >= 0; i--) {
            for (int j = tablica1[i].length - 1; j >= 0; j--) {
                tablica2[tablica1.length - 1 - i][tablica1[i].length - 1 - j] = tablica1[i][j];
            }
        }
        System.out.println("Tablica 2:");
        for (int[] i : tablica2) {
            System.out.print("\t");
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
        }
    }
