class Person {
    private String fornavn;
    private String etternavn;
    private int persnr;

    public Person(String fornavn, String etternavn, int persnr) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.persnr = persnr;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public int getPersnr() {
        return persnr;
    }

    public void setFornavn(String newValue) {
        this.fornavn = newValue;
    }

    public void setEtternavn(String newValue) {
        this.etternavn = newValue;
    }

    public void setPersnr(int newValue) {
        this.persnr = newValue;
    }

    public boolean equals(Object o) {
       if (!(o instanceof Person)) {
           return false;
       }
       if (o == this) {
           return true;
       }

       Person pers = (Person) o;
       if (pers.getPersnr() == persnr) {
           return true;
       }
       return false;
    }
}