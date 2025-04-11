package Lab04.Zad3;
import java.util.Random;

public class Program {
    static final int ARRAY_SIZE = 320_000_000;
    static final int[] array = new int[ARRAY_SIZE];

    public static void main(String[] args) throws InterruptedException {
        fillArray();
        int[] threadCounts = {1, 2, 3, 4, 5, 6, 7, 8, 20, 100, 500};
        for (int threadCount : threadCounts) {
            parallelMinMax(threadCount);
        }
    }

    static void fillArray() {
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt();
        }
    }

    static void parallelMinMax(int numThreads) throws InterruptedException {
        Thread[] threads = new Thread[numThreads];
        MinMaxResult[] results = new MinMaxResult[numThreads];

        int chunkSize = ARRAY_SIZE / numThreads;

        long start = System.nanoTime();

        for (int i = 0; i < numThreads; i++) {
            int startIdx = i * chunkSize;
            int endIdx = (i == numThreads - 1) ? ARRAY_SIZE - 1 : (startIdx + chunkSize - 1);
            results[i] = new MinMaxResult();
            threads[i] = new Thread(new MinMaxTask(array, startIdx, endIdx, results[i]));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        int globalMin = results[0].min;
        int globalMax = results[0].max;
        for (int i = 1; i < numThreads; i++) {
            if (results[i].min < globalMin) globalMin = results[i].min;
            if (results[i].max > globalMax) globalMax = results[i].max;
        }

        long end = System.nanoTime();
        System.out.println(numThreads + " wątków - czas: " + (end - start) / 1_000_000 + " ms");
    }
}

class MinMaxResult {
    public int min = Integer.MAX_VALUE;
    public int max = Integer.MIN_VALUE;
}

class MinMaxTask implements Runnable {
    private final int[] array;
    private final int start;
    private final int end;
    private final MinMaxResult result;

    public MinMaxTask(int[] array, int start, int end, MinMaxResult result) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.result = result;
    }

    public void run() {
        int localMin = array[start];
        int localMax = array[start];
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < localMin) localMin = array[i];
            if (array[i] > localMax) localMax = array[i];
        }
        result.min = localMin;
        result.max = localMax;
    }
}

