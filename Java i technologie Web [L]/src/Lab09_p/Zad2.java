package Lab9_p;

    class StudentUZ extends Student {
        private String wydzial;

        StudentUZ() {
            super();
            this.wydzial = "";
        }

        StudentUZ(String imie, String nazwisko, int indeks, String wydzial) {
            super(imie, nazwisko, indeks);
            this.wydzial = wydzial;
        }

        public String getWydzial() {
            return wydzial;
        }
        public void setWydzial(String wydzial) {
            this.wydzial = wydzial;
        }
}
