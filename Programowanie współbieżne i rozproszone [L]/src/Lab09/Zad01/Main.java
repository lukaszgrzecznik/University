package Lab09.Zad01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 1000;
        int[][] A = new int[SIZE][SIZE];
        int[][] B = new int[SIZE][SIZE];
        int[][] C = new int[SIZE][SIZE];
        int[][] D = new int[SIZE][SIZE];

        FillMatrix.fill_matrix_A(A);
        FillMatrix.fill_matrix_B(B);

        // Jednowątkowe mnożenie macierzy
        long startJeden = System.nanoTime();
        multiplySingleThread(A, B, C);
        long koniecJeden = System.nanoTime();
        double czasJeden = (koniecJeden - startJeden) / 1_000_000_000.0;
        System.out.printf("Czas jednowątkowy: %.2f s%n", czasJeden);

        // Wielowątkowe mnożenie macierzy
        long startWiele = System.nanoTime();
        multiplyMultiThread(A, B, D);
        long koniecWiele = System.nanoTime();
        double czasWiele = (koniecWiele - startWiele) / 1_000_000_000.0;
        System.out.printf("Czas wielowątkowy: %.2f s%n", czasWiele);

        // Porównanie wyników
        System.out.println("Wyniki są zgodne: " + compareMatrices(C, D));
        System.out.printf("Przyspieszenie: %.2f razy%n", czasJeden / czasWiele);
    }

    public static void multiplySingleThread(int[][] A, int[][] B, int[][] C) {
        int rozmiar = A.length;
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                C[i][j] = 0;
                for (int k = 0; k < rozmiar; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }

    public static void multiplyMultiThread(int[][] A, int[][] B, int[][] D) throws InterruptedException {
        int rozmiar = A.length;
        int liczbaWatkow = 4;
        ExecutorService executor = Executors.newFixedThreadPool(liczbaWatkow);

        int chunkSize = rozmiar / liczbaWatkow;
        for (int thread = 0; thread < liczbaWatkow; thread++) {
            final int startRow = thread * chunkSize;
            final int endRow = (thread == liczbaWatkow - 1) ? rozmiar : startRow + chunkSize;

            executor.execute(() -> {
                for (int i = startRow; i < endRow; i++) {
                    for (int j = 0; j < rozmiar; j++) {
                        D[i][j] = 0;
                        for (int k = 0; k < rozmiar; k++) {
                            D[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(10);
        }
    }

    public static boolean compareMatrices(int[][] C, int[][] D) {
        int rozmiar = C.length;
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                if (C[i][j] != D[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

class FillMatrix {
    public static void fill_matrix_A(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.abs((int) Math.round(Math.sin(i + j) * 10));
            }
        }
    }

    public static void fill_matrix_B(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.abs((int) Math.round(Math.cos(i + j) * 10));
            }
        }
    }
}
