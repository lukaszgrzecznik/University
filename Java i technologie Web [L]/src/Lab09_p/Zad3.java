package Lab9_p;

class StudentInstytut extends StudentUZ {
    private String instytut;

    StudentInstytut(){
        super();
        this.instytut = "";
    }

    StudentInstytut(String imie, String nazwisko, int indeks, String wydzial, String instytut){
        super(imie, nazwisko, indeks, wydzial);
        this.instytut = instytut;
    }

    public String getInstytut(){
        return instytut;
    }
    public void setInstytut(String instytut){
        this.instytut = instytut;
    }

    @Override
    public String toString(){
        return " \n" +
                "Imie = " + getImie() + "\n" +
                "Nazwisko = " + getNazwisko() + "\n" +
                "Indeks = " + getIndeks() + "\n" +
                "Wydzial = " + getWydzial() + "\n" +
                "Instytut = " + getInstytut() +
                "\n";
    }
}
