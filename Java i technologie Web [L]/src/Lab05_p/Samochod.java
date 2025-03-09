package Lab5_p;

public class Samochod {
    private String marka;
    private String model;
    private String typ_nadwozia;
    private String typ_silnika;
    private String data_pierwszej_rejestracji;
    private double pojemnosc_silnika;
    private double cena;
    private int rok_produkcji;

    public Samochod() {
        this.marka = "Skoda";
        this.model = "Fabia";
        this.typ_nadwozia = "Kombi";
        this.typ_silnika = "16V";
        this.data_pierwszej_rejestracji = "2005";
        this.pojemnosc_silnika = 1.4;
        this.cena = 1500;
        this.rok_produkcji = 2003;
    }

    public String getMarka() {
        return this.marka;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public String getModel() {
        return this.model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getTyp_nadwozia() {
        return this.typ_nadwozia;
    }
    public void setTyp_nadwozia(String typ_nadwozia) {
        this.typ_nadwozia = typ_nadwozia;
    }
    public String getTyp_silnika() {
        return this.typ_silnika;
    }
    public void setTyp_silnika(String typ_silnika) {
        this.typ_silnika = typ_silnika;
    }
    public String getData_pierwszej_rejestracji() {
        return this.data_pierwszej_rejestracji;
    }
    public void setData_pierwszej_rejestracji(String data_pierwszej_rejestracji) {
        this.data_pierwszej_rejestracji = data_pierwszej_rejestracji;
    }
    public double getPojemnosc_silnika() {
        return this.pojemnosc_silnika;
    }
    public void setPojemnosc_silnika(double pojemnosc_silnika) {
        this.pojemnosc_silnika = pojemnosc_silnika;
    }
    public double getCena() {
        return this.cena;
    }
    public void setCena(double cena) {
        this.cena = cena;
    }
    public int getRok_produkcji() {
        return this.rok_produkcji;
    }
    public void setRok_produkcji(int rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }
public boolean getGwarancja() {
        int obecny_rok = 2025;
        int rok_pierwszej_rejestracji = Integer.parseInt(this.data_pierwszej_rejestracji.substring(0, 4));
        int wiek = obecny_rok - rok_pierwszej_rejestracji;
        return wiek <= 2;
}
public void Wyswietl(){
        System.out.println("Marka: " + this.marka);
        System.out.println("Model: " + this.model);
        System.out.println("Typ nadwozia: " + this.typ_nadwozia);
        System.out.println("Typ silnika: " + this.typ_silnika);
        System.out.println("Data pierwszej rejestracji: " + this.data_pierwszej_rejestracji);
        System.out.println("Pojemnosc: " + this.pojemnosc_silnika);
        System.out.println("Cena: " + this.cena);
        System.out.println("Rok produkcji: " + this.rok_produkcji);
    }
}