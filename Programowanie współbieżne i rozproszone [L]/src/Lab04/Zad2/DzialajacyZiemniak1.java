package Lab04.Zad2;

public class DzialajacyZiemniak1
        implements Runnable{
    public void run(){
        while(true){
            System.out.println(Thread.
                    currentThread().getName());
        }
    }
}
