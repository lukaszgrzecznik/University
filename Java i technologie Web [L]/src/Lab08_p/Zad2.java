package Lab8_p;

class Student {
    private final String imie;
    private final String nazwisko;
    private final int indeks;

    public Student(String imie, String nazwisko, int indeks) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.indeks = indeks;
    }

    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public int getIndeks() {
        return indeks;
    }
}

public class Zad2 {
    public static void main(String[] args) {
        Student[] studenci = new Student[]{
                new Student("Łukasz", "Grzecznik", 1),
                new Student("Janek", "Pączek", 2),
                new Student("Jan", "Kowalski", 3)
                };

        System.out.println("Liczba elementów: " + studenci.length);
        System.out.println("Trzeci element w tablicy: " + studenci[2].getImie() + " " + studenci[2].getNazwisko() + " " + studenci[2].getIndeks());
    }
}
