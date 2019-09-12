import java.util.*;
class Sykehus implements ISykehus {
    private String sykehusnavn;
    private ArrayList<Avdeling> avdelinger = new ArrayList<Avdeling>();

    public Sykehus(String sykehusnavn) {
        this.sykehusnavn = sykehusnavn;
    }

    public boolean registrer(Object o) {
        if (!(o instanceof Avdeling)) { //Dersom den ikke er av klassen Avdeling returneres false
            return false;
        }
        Avdeling instance = (Avdeling) o; //Caster det til et Avdelings-objekt

        if(sjekkRegAvd(instance)) { //Dersom den allerede er registrert returneres false
            return false;
        }
        //Vet her at den ikke er registrert og at det er av klassen Avdeling. Derfor kan den registreres
        avdelinger.add(instance);
        return true;
    }

    public boolean fjern(Object o) {
        if (o instanceof Avdeling) {
            Avdeling instance = (Avdeling) o;
            int indeks = avdelinger.indexOf(instance);
            if (indeks == -1) { //Avdelingen er ikke registrert
                return false;
            }
            avdelinger.remove(indeks);
            return true;
        } else if (o instanceof Pasient) {
            Pasient instance = (Pasient) o;
            for (Avdeling avd : avdelinger) {
                //Antar her at en pasient kun kan være registrert på en avdeling
                if (avd.fjernPasient(instance)) {
                    return true;
                    //Returnerer true dersom pasienten er fjernet i en avdeling
                }
            }
            //Returnere false dersom den ikke har fjernet en pasient i noen av avdelingene
            return false;
        } else if (o instanceof Ansatt) {
            //Samme tankemåte som med Pasient
            Ansatt instance = (Ansatt) o;
            for (Avdeling avd : avdelinger) {
                if (avd.fjernAnsatt(instance)) {
                    return true;
                }
            }
            return false;
        } else {
            //Objektet ikke av typen avdeling, pasielt eller ansatt returnere false
            return false;
        }
    }

    public ArrayList<Avdeling> getAvdelinger() {
		return avdelinger;
	}


    private boolean sjekkRegAvd(Avdeling a) { //Privat hjelpemetode for å avgjøre om en avdeling er registrert fra før av eller ikke
        for (Avdeling avd : avdelinger) {
            if(avd.equals(a)) {
                return true; //Returnerer true om den er reg.
            }
        }
         return false;
    }
}