package Lab5_p;

class AutoKomis {
    private final Samochod[] samochody;
    public AutoKomis() {
        this.samochody = new Samochod[10];
        for (int i = 0; i < 10; i++) {
            this.samochody[i] = new Samochod();
        }
    }
    public void Wyswietl() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Samochód " + (i + 1) + ":");
            this.samochody[i].Wyswietl();
        }
    }
}
