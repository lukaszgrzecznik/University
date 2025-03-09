package Lab10_p;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Zad2 {
        static class LogiFilmow {
            int IdFilmu;
            int IdUzytkownika;
            int Ocena;
            String DataGlosowania;

            public LogiFilmow(int IdFilmu, int IdUzytkownika, int Ocena, String DataGlosowania) {
                this.IdFilmu = IdFilmu;
                this.IdUzytkownika = IdUzytkownika;
                this.Ocena = Ocena;
                this.DataGlosowania = DataGlosowania;
            }

            @Override
            public String toString() {
                return IdFilmu + "," + IdUzytkownika + "," + Ocena + "," + DataGlosowania;
            }
        }

        static class LogWriterThread extends Thread {
            private final String sciezkaPliku;

            public LogWriterThread(String filePath) {
                this.sciezkaPliku = filePath;
            }

            @Override
            public void run() {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(sciezkaPliku))) {
                    for (int i = 0; i < 50; i++) {
                        LogiFilmow log = new LogiFilmow(i, i * 2, (i % 5) + 1, "2024-08-19");
                        writer.write(log.toString());
                        writer.newLine();
                    }
                    System.out.println("Log Thread zapisany do: " + sciezkaPliku);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        static class LogWriterRunnable implements Runnable {
            private final String sciezkaPliku;

            public LogWriterRunnable(String filePath) {
                this.sciezkaPliku = filePath;
            }

            @Override
            public void run() {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(sciezkaPliku))) {
                    for (int i = 50; i < 100; i++) {
                        LogiFilmow log = new LogiFilmow(i, i * 3, (i % 5) + 1, "2024-08-19");
                        writer.write(log.toString());
                        writer.newLine();
                    }
                    System.out.println("Log Runnable zapisany do: " + sciezkaPliku);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        static class LogReaderThread extends Thread {
            private final String sciezkaPliku;
            private final int linieDoCzytania;
            private final int offset;

            public LogReaderThread(String SciezkaPliku, int linieDoCzytania, int offset) {
                this.sciezkaPliku = SciezkaPliku;
                this.linieDoCzytania = linieDoCzytania;
                this.offset = offset;
            }

            @Override
            public void run() {
                try (BufferedReader reader = new BufferedReader(new FileReader(sciezkaPliku))) {
                    int currentLine = 0;
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (currentLine >= offset && currentLine < offset + linieDoCzytania) {
                            System.out.println(Thread.currentThread().getName() + ": " + line);
                        }
                        currentLine++;
                        if (currentLine >= offset + linieDoCzytania) break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            String sciezka1 = "logs_thread.txt";
            String sciezka2 = "logs_runnable.txt";

            Thread threadWriter = new LogWriterThread(sciezka1);
            Thread runnableWriter = new Thread(new LogWriterRunnable(sciezka2));

            threadWriter.start();
            runnableWriter.start();

            threadWriter.join();
            runnableWriter.join();

            int linesPerThread = 10;

            ExecutorService executorService = Executors.newFixedThreadPool(4);
            for (int i = 0; i < 5; i++) {
                int offset = i * linesPerThread;
                executorService.execute(new LogReaderThread(sciezka1, linesPerThread, offset));
                executorService.execute(new LogReaderThread(sciezka2, linesPerThread, offset));
            }
            executorService.shutdown();
        }
    }

