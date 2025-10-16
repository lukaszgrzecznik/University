package Lab1.Ulamek;

public class Ulamek {
    private int licznik;
    private int mianownik;

    public int getLicznik() {
        return licznik;
    }

    public int getMianownik() {
        return mianownik;
    }

    public void setLicznik(int licznik) {
        this.licznik = licznik;
    }

    public void setMianownik(int mianownik) {
        if (mianownik == 0) {
            throw new IllegalArgumentException("Error: Mianownik nie może wynosić 0.");
        }
        this.mianownik = mianownik;
    }

    public void printskrocone() {
        int nwd = nwd(licznik, mianownik);
        licznik /= nwd;
        mianownik /= nwd;
        System.out.println("Skrócony: " + getMianownik() + "/" + getLicznik());
    }

    private int nwd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // Zwraca wartość bezwzględną
    }
}
