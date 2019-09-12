import java.util.*;
class Rom {
  private int nr;
  private int storrelse;
  private ArrayList<Reservasjon> reservasjoner;

  public Rom(int nr, int storrelse) {
    this.nr = nr;
    this.storrelse = storrelse;
    reservasjoner = new ArrayList<Reservasjon>();
  }

  public int getNr(){
    return nr;
  }

  public int getStorrelse() {
    return storrelse;
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Rom)) {
      return false;
    }
    if (this == obj) {
      return true;
    }

    Rom instance = (Rom) obj;
    if (instance.getNr() == nr) {
      return true;
    }
    return false;
  }

  public boolean sjekkLedighet(Reservasjon r1) {
    for (int i = 0; i< reservasjoner.size(); i++) {
      if (reservasjoner.get(i).overlapp(r1.getFraTid(), r1.getTilTid())) { //Returnerer false dersom det ikke er ledig
        return false;
      }
    }
    return true;
  }

  public void addReservasjon(Reservasjon r1) { //Legger til en reservasjon i tabellen
	 reservasjoner.add(r1);
  }

  public String toString() {
	  String res = "Rom " + getNr() + "\n";
	  for (int i = 0; i < reservasjoner.size();i++) {
		  res += reservasjoner.get(i).toString() + "\n";
	  }
	  return res;

  }



  public static void main(String[] args) {
	Rom rom1 = new Rom(1,4);
	Kunde k1 = new Kunde("Max Schau", "91782159");
	Kunde k2 = new Kunde("Gunnar Gunnersen", "480127221");

	Tidspunkt t1 = new Tidspunkt(200301201200L);
	Tidspunkt t2 = new Tidspunkt(200301281200L);
	Tidspunkt t3 = new Tidspunkt(200302011200L);
	Tidspunkt t4 = new Tidspunkt(200302051200L);

	Reservasjon r1 = new Reservasjon(t1,t2,k1);
	Reservasjon r2 = new Reservasjon(t3,t4,k1);
	System.out.println(rom1.sjekkLedighet(r1));
	rom1.addReservasjon(r1);
	System.out.println(rom1.sjekkLedighet(r1));
	System.out.println(rom1.sjekkLedighet(r2));
	rom1.addReservasjon(r2);
	System.out.println(rom1.sjekkLedighet(r2));




  }
}
