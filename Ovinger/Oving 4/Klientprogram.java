import static javax.swing.JOptionPane.*;
public class Klientprogram {
	private static String[] ALTERNATIVER = {"Les inn reservasjoner", "Skriv ut registrert informasjon", "Finn rom gitt romnummer", "Avslutt"};
	private static final int LES_RESERVASJONER = 0;
	private static final int SKRIV_UT = 1;
	private static final int FINN_ROM = 2;
	private static final int AVSLUTT = 3;

	public static void main(String[] args) {
		Konferansesenter k = new Konferansesenter();
		k.regNyttRom(1,4);
		k.regNyttRom(2, 4);
		k.regNyttRom(3,8);
		k.regNyttRom(4, 8);
		k.regNyttRom(5,10);
		k.regNyttRom(6, 2);

		boolean lesValget = true;

		while(lesValget) {
			int valg = showOptionDialog(null, "Gj�r et valg", "Oh Yes", DEFAULT_OPTION, PLAIN_MESSAGE,null, ALTERNATIVER,ALTERNATIVER[0]);
			if (valg == 3) {
				lesValget = false;
			}
			switch(valg) {
			case LES_RESERVASJONER:
				String fraTidLest = showInputDialog("Tid fra: YYYYMMDDTTTT");
				String tilTidLest = showInputDialog("Til tid: YYYYMMDDTTTT");
				Tidspunkt t1 = new Tidspunkt(Long.parseLong(fraTidLest));
				Tidspunkt t2 = new Tidspunkt(Long.parseLong(tilTidLest));
				int antallPers = Integer.parseInt(showInputDialog("Skriv inn antall personer"));
				String navn = showInputDialog("Skriv inn navnet ditt");
				String tlf = showInputDialog("Skriv inn TLF");

				if (k.reserver(t1, t2, antallPers, navn, tlf)) {
					showMessageDialog(null, "Vellykket reservasjon");
				} else {
					showMessageDialog(null, "Ikke vellykket reservasjon");
				}

				break;
			case SKRIV_UT:
				showMessageDialog(null, k.toString());
				break;
			case FINN_ROM:
				String nrLest = showInputDialog("Skriv inn romnummeret");
				int nr = Integer.parseInt(nrLest);
				if (nr > k.getAntallRom()) {
					showMessageDialog(null,"Ugyldig nummer");
				}  else {
					Rom rommet = k.finnRomGittRomNr(nr);
					showMessageDialog(null, rommet.toString());
				}
				break;
			default:
				break;


			}
		}



	}

}
