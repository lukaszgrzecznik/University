package Lab04.Zad2;

public class TestPriorytetuWatkow
{
    public static void main(String arg[])
    {
        DzialajacyZiemniak2 dZ = new DzialajacyZiemniak2();
        Thread t1 = new Thread(dZ,"Pierwszy ziemniak");
        Thread t2 = new Thread(dZ,"Drugi ziemniak");
        t2.setPriority(t1.getPriority() + 1);
        t1.start();
        t2.start();
    }
}

