import java.util.Date;
import java.util.ArrayList;
import java.util.*;

public class Restaurant {
    private String navn;
    private int etablert;
    private Bord bord;

    public Restaurant(String navn, int etablert, Bord bord) {
        this.navn = navn;
        this.etablert = etablert;
        this.bord = bord;
    }

    public String getNavn() {
        return navn;
    }
    public int getEtablert() {
        return etablert;
    }

    public boolean setNavn(String newValue) {
        if (newValue == null) {
            return false;
        }
        this.navn = newValue;
        return true;
    }

    public int finnAlder() {
        Date dato = new Date();
        int ar = dato.getYear() + 1900;
        return ar - etablert;
    }

    public int finnAntalLLedigBord() {
        return bord.finnAntalLLedigBord();
    }

    public int finnAntallOpptattBord() {
        return bord.finnAntallOpptattBord();
    }

    public boolean reserverBord(String navn, int antall) {
        return bord.reserverBord(navn,antall);
    }

    public int[] finnAntallBord(String navn) {
        String [] tabell = bord.getTabell();
        ArrayList<Integer> bordnummer = new ArrayList<Integer>();
        for (int i = 0; i < tabell.length; i++) {
            if (navn.equals(tabell[i])) {
                bordnummer.add(i);
            }
        }
        //Parser til int[]
        int[] bordnummer2 = new int[bordnummer.size()];
        int teller = 0;
        for (Integer i: bordnummer) {
          bordnummer2[teller++] = i.intValue();
        }
        return bordnummer2;
    }

    public int[] finnRyddeteBord() {
      String[] tabell = bord.getTabell();
      ArrayList<Integer> bordnummer = new ArrayList<Integer>();
      for (int i = 0; i < tabell.length; i++) {
            if(tabell[i] == null) {
              bordnummer.add(i);
            }
      }
      //Parser til int[]
      int[] bordnummer2 = new int[bordnummer.size()];
      int teller = 0;
      for (Integer i: bordnummer) {
        bordnummer2[teller++] = i.intValue();
      }
      return bordnummer2;
    }
}
