package Lab08.Zad02;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class Main {
    public static void main(String[] args) {
        final int numberOfLecturers = 4;
        int[] grades = new int[numberOfLecturers];

        // CyclicBarrier with a task to calculate the average
        CyclicBarrier barrier = new CyclicBarrier(numberOfLecturers, () -> {
            double sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            double average = sum / numberOfLecturers;
            System.out.println("Średnia ocen semestralnych: " + average);
        });

        // Create and start lecturer threads
        for (int i = 0; i < numberOfLecturers; i++) {
            final int lecturerIndex = i;
            new Thread(() -> {
                try {
                    // Simulate grade assignment
                    int grade = (int) (Math.random() * 5) + 1; // Random grade between 1 and 5
                    grades[lecturerIndex] = grade;
                    System.out.println("Prowadzący " + (lecturerIndex + 1) + " wystawił ocenę: " + grade);

                    // Wait at the barrier
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Wątek prowadzącego " + (lecturerIndex + 1) + " został przerwany.");
                }
            }).start();
        }
    }
}
