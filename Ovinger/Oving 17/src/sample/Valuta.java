package sample;

public class Valuta {
    private String navn;
    private double kurs;
    private int enhet;

    public Valuta(String navn, double kurs, int enhet) {
        this.navn = navn;
        this.kurs = kurs;
        this.enhet = enhet;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getKurs() {
        return kurs;
    }

    public void setKurs(double kurs) {
        this.kurs = kurs;
    }

    public int getEnhet() {
        return enhet;
    }

    public void setEnhet(int enhet) {
        this.enhet = enhet;
    }
}
