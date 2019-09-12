import java.util.*;
class OppgaveOversikt2 {
  private ArrayList<Student> studenter = new ArrayList<Student>();
  private int antStud = 0;

  public OppgaveOversikt2() {
  }

  public boolean regNyStudent(String navn) {
    for (int i = 0; i < antStud; i++) {
      if (navn.equals(studenter.get(i).getNavn())) { //Sjekker at den ikke eksistrerer fra før av
        return false;
      }
    }
    Student nyStud = new Student(navn);
    studenter.add(nyStud);
    antStud++;
    return true;
    }

    public int finnAntStud() {
      return antStud;
    }

    public int finnAntOppgaver(String navn) {
      int indeks = -1;
      for (int i = 0; i < antStud; i++) {
        //Finner indeksen til navnet
        if (navn.equals(studenter.get(i).getNavn())) {
          indeks = i;
          return studenter.get(indeks).getAntOppg();
        }
      }
      return indeks;

    }

    public boolean okAntOppg(String navn, int okning) {
      int indeks = -1;
      for (int i = 0; i < antStud; i++) { //Finner indeksen til navnet
        if (navn.equals(studenter.get(i).getNavn())) {
          indeks = i;
        }
      }
      studenter.get(indeks).setAntOppg(finnAntOppgaver(navn) + okning);
      return true;

    }

    public String[] finnAlleNavn() {
      ArrayList<String> navnene = new ArrayList<String>();
      for (Student s1: studenter) {
        navnene.add(s1.getNavn());
      }
      String[] alleNavn = new String[navnene.size()];
      //Usikker på om den skulle returnere String[] eller arraylist. Velger å returnere String[] ved å konvertere til String[].
      //Kunne eventuelt droppet nedre dle og skrevet return navnene.
      for (int i = 0; i < antStud; i++) {
        alleNavn[i] = navnene.get(i);
      }
      return alleNavn;
    }

    public String toString() {
      String res = "";
      for (Student s1: studenter) {
        res += s1.toString() + "\n";
      }
      return res;
    }



}
