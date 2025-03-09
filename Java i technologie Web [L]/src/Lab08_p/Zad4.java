package Lab8_p;

public class Zad4 {
    public static void main(String[] args) {
        System.out.print("Podaj adres email: ");
        String email = System.console().readLine();
        if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("Adres poprawny");
        } else {
            System.out.println("Adres niepoprawny");
        }
    }
}
