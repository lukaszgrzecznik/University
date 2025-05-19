package Lab09.Zad02;

import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, NoSuchAlgorithmException {
        int[] rozmiary = {500, 1000, 1500};
        int procesor = Runtime.getRuntime().availableProcessors();
        System.out.println("Liczba procesorów: " + procesor);

        try (FileWriter writer = new FileWriter("wyniki.txt", true)) {
            writer.write("Liczba procesorów: " + procesor + "\n");

            for (int rozmiar : rozmiary) {
                int[][] A = new int[rozmiar][rozmiar];
                int[][] B = new int[rozmiar][rozmiar];
                int[][] C = new int[rozmiar][rozmiar];
                int[][] D = new int[rozmiar][rozmiar];

                FillMatrix.fill_matrix_A(A);
                FillMatrix.fill_matrix_B(B);

                // Single-threaded multiplication
                long startJeden = System.nanoTime();
                multiplySingleThread(A, B, C);
                long koniecJeden = System.nanoTime();
                double czasJeden = (koniecJeden - startJeden) / 1_000_000_000.0;

                // Multi-threaded multiplication
                long startWiele = System.nanoTime();
                multiplyMultiThread(A, B, D, procesor);
                long koniecWiele = System.nanoTime();
                double czasWiele = (koniecWiele - startWiele) / 1_000_000_000.0;

                // Compare results
                boolean czyRowne = compareMatrices(C, D);
                double przyspieszenie = czasJeden / czasWiele;

                // Calculate MD5 checksums
                String checksumC = calculateMD5(C);
                String checksumD = calculateMD5(D);

                // Log results
                String result = String.format(
                        "Rozmiar macierzy: %dx%d\nCzas jednowątkowy: %.2f s\nCzas wielowątkowy: %.2f s\n" +
                                "Zgodność wyników: %b\nPrzyspieszenie: %.2f razy\nMD5 C: %s\nMD5 D: %s\n\n",
                        rozmiar, rozmiar, czasJeden, czasWiele, czyRowne, przyspieszenie, checksumC, checksumD
                );

                System.out.print(result);
                writer.write(result);
            }
        }
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

    public static void multiplyMultiThread(int[][] A, int[][] B, int[][] D, int numThreads) throws InterruptedException {
        int rozmiar = A.length;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        int chunkSize = rozmiar / numThreads;
        for (int thread = 0; thread < numThreads; thread++) {
            final int startRow = thread * chunkSize;
            final int endRow = (thread == numThreads - 1) ? rozmiar : startRow + chunkSize;

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

    public static String calculateMD5(int[][] matrix) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        for (int[] row : matrix) {
            for (int value : row) {
                md.update((byte) (value & 0xFF));
                md.update((byte) ((value >> 8) & 0xFF));
                md.update((byte) ((value >> 16) & 0xFF));
                md.update((byte) ((value >> 24) & 0xFF));
            }
        }
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
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
