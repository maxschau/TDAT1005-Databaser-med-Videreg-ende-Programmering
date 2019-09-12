class Lege extends Ansatt {

    public Lege(String fornavn, String etternavn, int persnr) {
        super(fornavn, etternavn, persnr);
    }

    public void setDiagnose(Pasient p1, String diagnose) {
        p1.setDiagnose(diagnose);
    }
}