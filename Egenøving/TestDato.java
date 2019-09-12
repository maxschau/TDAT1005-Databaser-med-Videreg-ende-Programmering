import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
class TestDato {
  public static void main(String[] args) {
    LocalDate innmeldtDato = LocalDate.of(2007,4,10);
    LocalDate testdato = LocalDate.of(2008, 3, 10);

    long days = ChronoUnit.DAYS.between(innmeldtDato, testdato);
    System.out.println(days);

/*
    int arMellom = Period.between(innmeldtDato, testdato).getYears();
    System.out.println(arMellom);
    int dagerMellom = Period.between(innmeldtDato, testdato).getDays();
    System.out.println(dagerMellom);
  */
  }
}
