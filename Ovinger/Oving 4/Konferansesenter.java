import java.util.*;
class Konferansesenter {
  private ArrayList<Rom> rom;

  public Konferansesenter() {
    rom = new ArrayList<Rom>();
  }

  public boolean reserver(Tidspunkt t1, Tidspunkt t2, int antallPersoner, String navn, String telefon) {
    //Oppretter kundeobjekt
    Kunde nyKunde = new Kunde(navn, telefon);

    //Oppretter reservasjonsobjekt
    Reservasjon r1 = new Reservasjon(t1, t2, nyKunde);

    //Må gå gjennom rom og sjekk ledighet og størrelse.
    for (int i = 0; i < rom.size(); i++) {
      if (rom.get(i).getStorrelse() >= antallPersoner && (rom.get(i).sjekkLedighet(r1)))  { //Sjekker størrelse og ledighet
        rom.get(i).addReservasjon(r1);
        return true;
      }
    }
    return false;

  }

  public boolean regNyttRom(int nr, int storrelse) {
    for (int i = 0; i < rom.size(); i++) {
      if (nr == rom.get(i).getNr()) { //Returnerer false dersom rommet allerede er leid ut 
        return false;
      }
    }
    Rom r1 = new Rom(nr, storrelse);
    rom.add(r1);
    return true;
  }

  public int getAntallRom() {
    return rom.size();
  }

  public Rom finnRomGittIndeks(int indeks) {
    return rom.get(indeks);
  }

  public Rom finnRomGittRomNr(int romNr) {
    int indeks = -1;
    for (int i = 0; i < rom.size(); i++) {
      if (romNr == rom.get(i).getNr()) {
        indeks = i;
      }
    }
    return rom.get(indeks);
  }

  public String toString() {
	  String res = "Konferansesenter:" + "\n";
	  for (int i = 0; i < rom.size(); i++) {
		  res += rom.get(i).toString();
	  }
	  return res;
  }


}
