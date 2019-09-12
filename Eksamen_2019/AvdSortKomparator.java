import java.util.Comparator;
class AvdSortKomparator implements Comparator {

	@Override
    public int compare(Object o, Object o2) {
        //Antar at det alltid blir sendt inn Avdelingsobjekter

        Avdeling a1 = (Avdeling) o;
        Avdeling a2 = (Avdeling) o2;

        //Bruker metoden i Avdeling som finner totalt antall ansatte
        if (a1.finnAntallAnsatte() < a2.finnAntallAnsatte()) {
            return -1;
        } else if (a1.finnAntallAnsatte() == a2.finnAntallAnsatte()) {
            return 0;
        } else {
            return 1;
        }
    }
}
