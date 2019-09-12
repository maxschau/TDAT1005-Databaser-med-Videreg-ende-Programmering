class Pasient extends Person {
    private String diagnose;
    
    public Pasient(String fornavn, String etternavn, int persnr) {
        super(fornavn, etternavn, persnr);
    }
    
    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }
}