public class Bord {
	private String[] oversikt;

	public Bord(String[] oversikt) {
		this.oversikt = oversikt;
	}

	public String[] getTabell() {
		return oversikt;
	}

	public int finnAntalLLedigBord() {
		int teller = 0;
		for (int i = 0; i < oversikt.length; i++) {
			if (oversikt[i] == null) { //Dvs. bordet er ledig
				teller++;
			}
		}
		return teller;
	}

	public int finnAntallOpptattBord() {
		int teller = 0;
		for (int i = 0; i < oversikt.length; i++) {
			if (oversikt[i] != null) { //Dvs. bordet er opptatt
				teller++;
			}
		}
		return teller;
	}

	public boolean reserverBord(String navn, int antall) {
		if (antall > finnAntalLLedigBord()) { //Dersom det ikke er plass
			return false;
		}
		for (int i = 0; i < oversikt.length; i++) {
			if (oversikt[i] == null) {
				oversikt[i] = navn;
			}
		}
		return true;

	}


}
