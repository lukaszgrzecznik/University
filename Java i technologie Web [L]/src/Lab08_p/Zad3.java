package Lab8_p;

public class Zad3 {
    public static void main(String[] args) {
        System.out.print("Podaj zdanie: ");
        String zdanie = System.console().readLine();
        String[] slowa = zdanie.split("\\s+");
        for (String slowo : slowa){
            System.out.println(slowo);
        }
    }
}
