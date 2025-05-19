package Lab08.Zad03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        final int N = 1_000_000;

        // Single-threaded approach
        long startSingle = System.nanoTime();
        List<Integer> primesSingleThread = findPrimesSingleThread(N);
        long endSingle = System.nanoTime();
        System.out.println("Single-threaded time: " + (endSingle - startSingle) / 1_000_000 + " ms");

        // Multi-threaded approach
        long startMulti = System.nanoTime();
        List<Integer> primesMultiThread = findPrimesMultiThread(N);
        long endMulti = System.nanoTime();
        System.out.println("Multi-threaded time: " + (endMulti - startMulti) / 1_000_000 + " ms");

        // Verify results
        System.out.println("Results are identical: " + primesSingleThread.equals(primesMultiThread));
        System.out.println("Speedup: " + (double) (endSingle - startSingle) / (endMulti - startMulti));
    }

    private static List<Integer> findPrimesSingleThread(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static List<Integer> findPrimesMultiThread(int n) throws Exception {
        int numThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Callable<List<Integer>>> tasks = new ArrayList<>();
        int range = n / numThreads;

        for (int i = 0; i < numThreads; i++) {
            final int start = i * range + 2;
            final int end = (i == numThreads - 1) ? n : (i + 1) * range + 1;
            tasks.add(() -> {
                List<Integer> primes = new ArrayList<>();
                for (int j = start; j <= end; j++) {
                    if (isPrime(j)) {
                        primes.add(j);
                    }
                }
                return primes;
            });
        }

        List<Integer> primes = new ArrayList<>();
        List<Future<List<Integer>>> results = executor.invokeAll(tasks);
        for (Future<List<Integer>> result : results) {
            primes.addAll(result.get());
        }

        executor.shutdown();
        return primes;
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
