package Lab04.Zad2;

public class DzialajacyZiemniak2
        implements Runnable{
    public void run(){
        while(true){
            System.out.println(Thread.
                    currentThread().getName());
            Thread.yield(); // pozwól
//działać innym wątkom
        }
    }
}
