package dp4.register.d;

/**
 * Klassen Utstyr er mutabel. Antall p� lager og nedre grense for bestilling kan
 * endres.
 */
class Utstyr {
	public static final int BESTILLINGSFAKTOR = 5;
	private final String betegnelse;
	private final String leverand�r;
	private int p�Lager; // mengde p� lager
	private int nedreGrense;

	public Utstyr(String betegnelse, String leverand�r, int p�Lager, int nedreGrense) {
		this.betegnelse = betegnelse;
		this.leverand�r = leverand�r;
		this.p�Lager = p�Lager;
		this.nedreGrense = nedreGrense;
	}

	public String getBetegnelse() {
		return betegnelse;
	}

	public String getLeverand�r() {
		return leverand�r;
	}

	public int getP�Lager() {
		return p�Lager;
	}

	public int getNedreGrense() {
		return nedreGrense;
	}

	public void setNedreGrense(int nyNedreGrense) {
		nedreGrense = nyNedreGrense;
	}

	public int finnBestKvantum() {
		return (p�Lager < nedreGrense) ? BESTILLINGSFAKTOR * nedreGrense : 0;
	}

	/**
	 * Endring av lagerbeholdning. Den kan v�re positiv eller negativ. Men det er
	 * ikke mulig � ta ut mer enn det som fins p� lager. Hvis klienten pr�ver p�
	 * det, vil metoden returnere false, og intet uttak gj�res.
	 */
	public boolean endreLagerbeholdning(int endring) {
		if (p�Lager + endring < 0) {
			return false;
		} else {
			p�Lager += endring;
			return true;
		}
	}

	public String toString() {
		String resultat = "Betegnelse: " + betegnelse + ", ";
		resultat += "Leverand�r: " + leverand�r + ", ";
		resultat += "P� lager: " + p�Lager + ", ";
		resultat += "Nedre grense: " + nedreGrense;
		return resultat;
	}
}