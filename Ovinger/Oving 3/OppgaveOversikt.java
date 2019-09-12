import java.util.*;
public class OppgaveOversikt {
  private Student[] studenter = new Student[5];
  private int antStud = 0;

  public OppgaveOversikt() {
  }

  public boolean regNyStudent(String navn) {
    //Sjekker at det ikke eksisterer fra før av
    for (int i = 0; i < antStud; i++) {
      if (navn.equals(studenter[i].getNavn())) {
        return false;
      }
    }
    //Sjekker at det er plass
    if (antStud == 5) {
      utvidTabell();
    }
    Student nyStud = new Student(navn);
    studenter[antStud] = nyStud;
    antStud++;
    return true;

  }

  public int finnAntStud() {
    return antStud;
  }


  public int finnAntOppgaver(String navn) {
    for (int i = 0; i < antStud; i++) {
      if (navn.equals(studenter[i].getNavn())) {
        return studenter[i].getAntOppg();
      }
    }
    return -1;
  }

  public boolean okAntOppg(String navn, int okning) {
    for (int i = 0; i < antStud; i++) {
      if (navn.equals(studenter[i].getNavn())) { //Finner studenten
        studenter[i].setAntOppg(studenter[i].getAntOppg() + okning); //Øker antall oppgaver
        return true;
      }
    }
    return false;
  }

  public String[] finnAlleNavn() {
    String[] navnene = new String[antStud]; //Lager en ny tabell lik antStud
    for (int i = 0; i < antStud; i++) {
      navnene[i] = studenter[i].getNavn(); //Legger inn hvert navn inn i tabellen
    }
    return navnene; //Returnerer tabellen
  }

  public String toString() {
    String res = "";
    for (int i = 0; i < antStud; i++) {
      res += studenter[i].toString() + "\n";
    }
    return res;
  }

  private void utvidTabell() {
    Student[] nyTab = new Student[studenter.length + 5];
    for (int i = 0; i < antStud; i++) {
      nyTab[i] = studenter[i];
    }
    studenter = nyTab;
  }
}
