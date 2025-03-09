package Lab9_p;

class Testowy {
    public static void main(String[] args) {
        StudentInstytut student = new StudentInstytut();
        student.setImie("Łukasz");
        student.setNazwisko("Grzecznik");
        student.setIndeks(112069);
        student.setWydzial("Wydział Informatyki, Elektrotechniki i Automatyki");
        student.setInstytut("Instytut Sterowania i Systemów Informatycznych");
        System.out.println(student);
    }
}
