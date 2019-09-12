class Test {
  public static void main(String[] args) {
    Student s1 = new Student("Max");
    Student s2 = new Student("Zaim");

    OppgaveOversikt2 oversikt = new OppgaveOversikt2();

    oversikt.regNyStudent("Max");
    oversikt.regNyStudent("Zaim");
    System.out.println(oversikt.okAntOppg("Max",900));
    System.out.println(oversikt.finnAntOppgaver("Max"));
  }
}
