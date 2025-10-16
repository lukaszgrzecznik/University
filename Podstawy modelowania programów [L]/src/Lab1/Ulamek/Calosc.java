package Lab1.Ulamek;

public class Calosc extends Ulamek {
    private int calosc;

    public void setCalosc(int calosc) {
        this.calosc = calosc;
    }

    public void print() {
        System.out.println("Ułamek: " + calosc + " " + getLicznik() + "/" + getMianownik());
    }

    public void printflip() {
        if(getLicznik() == 0 && calosc == 0) {
            throw new IllegalArgumentException("Error: Nie można odwrócić ułamka");
        } else {
            int temp = getLicznik() + (calosc*getMianownik());
            setLicznik(getMianownik());
            setMianownik(temp);
            System.out.println("Odwrócony: " + getLicznik() + "/" + getMianownik());
        }
    }
}
