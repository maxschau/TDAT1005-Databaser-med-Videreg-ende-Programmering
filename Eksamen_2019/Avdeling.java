import java.util.*;
class Avdeling {
    private String avdelingsnavn;
    ArrayList<Ansatt> ansatte = new ArrayList<Ansatt>();
    ArrayList<Pasient> pasienter = new ArrayList<Pasient>();

    public Avdeling(String avdelingsnavn) {
        this.avdelingsnavn = avdelingsnavn;
    }

    public String getAvdelingsnavn() {
        return avdelingsnavn;
    }

    public ArrayList<Ansatt> getAnsatte() {
        return ansatte;
    }

    public ArrayList<Pasient> getPasienter() {
        return pasienter;
    }

    public void setAvdelingsnavn(String newValue) {
        this.avdelingsnavn = avdelingsnavn;
    }

    public void setAnsatte(ArrayList<Ansatt> newValue) {
        this.ansatte = newValue;
    }

    public void setPasienter(ArrayList<Pasient> newValue) {
        this.pasienter = newValue;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Avdeling)) { //Må være av typen avdeling
            return false;
        }

        if(this == o) { //Dersom vi peker til samme referansen
            return true;
        }

        Avdeling instance = (Avdeling) o; //Caster objektet til Avdeling
        if (instance.getAvdelingsnavn() == avdelingsnavn) {
            return true;
        }
        return false;
    }

    public boolean fjernPasient(Pasient p) {
        int indeks = pasienter.indexOf(p);
        if (indeks != -1) {
            pasienter.remove(indeks);
            return true;
        }
        return false;
    }

    public String toString() {
		return avdelingsnavn + " antallAnsatte: " + finnAntallAnsatte();
	}

    public boolean fjernAnsatt(Ansatt a) {
        int indeks = ansatte.indexOf(a);
        if (indeks != -1) {
            ansatte.remove(indeks);
            return true;
        }
        return false;
    }

    //Metode som brukes til senere da man må vite hvor mange ansatte det er i hver avdeling
    public int finnAntallAnsatte() {
        return ansatte.size();
    }
    //TRENGER KANSKJE IKKE DENNE
    private boolean sjekkRegPasient(Pasient p) {
        for (Pasient pas : pasienter) {
            if (pas.equals(p)) {//Må definere equalsmetode for pasienter
                return true;
            }
        }
        return false;
    }
}