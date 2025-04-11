package Lab04.Zad2;

public class TestZiemniakow1{
    public static void
    main(String arg[]){
        DzialajacyZiemniak1 dZ
                = new DzialajacyZiemniak1();
        new Thread(dZ,"Pierwszy ziemniak")
                .start();
        new Thread(dZ,"Drugi ziemniak")
                .start();
    }
}

