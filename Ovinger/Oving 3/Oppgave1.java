/**
 * Hovedprogrammet. Går i løkke og lar brukeren gjøre valg.
 */
class Oppgave1 {
  public static void main(String[] args) {

    //Klientprogram for Oppgave 1
  OppgaveOversikt oversikt = new OppgaveOversikt();
  GodkjenningBGS bgs = new GodkjenningBGS(oversikt);

  String valg = bgs.lesValg();
  while (valg != null) {
    bgs.utforValgtOppgave(valg);
    valg = bgs.lesValg();
  }

  /* Prøver toString() */
  System.out.println("\nHer kommer informasjon om alle studentene: ");
  System.out.println(oversikt);
}
}
