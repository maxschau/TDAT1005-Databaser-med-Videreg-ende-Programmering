public class Student {
  private final String navn;
  private int antOppg;

  public Student(String navn) {
    this.navn = navn;
  }

  public String getNavn() {
    return navn;
  }

  public int getAntOppg() {
    return antOppg;
  }

  public void setAntOppg(int antOppg) {
    if (antOppg < 0) {
      throw new IllegalArgumentException("Ugyldig argument");
    }
    this.antOppg = antOppg;
  }

  public String toString() {
    return "Navn: " + navn + ", Antall oppgaver: " + antOppg;
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Student)) {
      return false;
    }
    if (this == obj) {
      return true;
    }

    Student s1 = (Student) obj;
    if (s1.getNavn().equals(navn)) {
      return true;
    }
    return false;
  }



}
