public class Oppgave2 {
  public static void main(String[] args) {
    OppgaveOversikt2 oversikt = new OppgaveOversikt2();
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
