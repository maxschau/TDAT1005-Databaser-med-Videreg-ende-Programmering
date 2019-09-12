import java.util.*;
public class Sykehusklient {
       public static void main(String[] args) {
             Sykehus sykehus = new Sykehus("St. Olav");

             //Opprett f�deavdeling
             Avdeling f�deAvdeling = new Avdeling("F�deavdeling");

             Lege lege1 =new Lege("Odd Even","Primtallet",456);

             f�deAvdeling.getAnsatte().add(lege1);

             Lege lege2 =new Lege("Huppasahn","DelFinito",123);

             f�deAvdeling.getAnsatte().add(lege2);

             Sykepleier sykepleier =new Sykepleier("Rigmor","Mortis",324);

             f�deAvdeling.getAnsatte().add(sykepleier);

             Ansatt ansatt = new Ansatt("Kurt","Isere", 345);

             f�deAvdeling.getAnsatte().add(ansatt);

             Pasient pasient = new Pasient("Horst","Nuppentaler", 11059);

             lege1.setDiagnose(pasient, "Forkj�let");

             f�deAvdeling.getPasienter().add(pasient);



             sykehus.registrer(f�deAvdeling);



             //Opprett lungeavdeling

             Avdeling lungeAvdeling = new Avdeling("Lungemedisinsk avdeling");



             Lege lege3 =new Lege("Salti","Kaffen", 7847);

             lungeAvdeling.getAnsatte().add(lege3);



             Sykepleier sykepleier2 =new Sykepleier("Anton","Nym",4443);

             lungeAvdeling.getAnsatte().add(sykepleier2);



             Ansatt ansatt2 = new Ansatt("Sesam","Lukkopphagen", 4352);

             lungeAvdeling.getAnsatte().add(ansatt2);





             Pasient pasient2 = new Pasient("Gene","Sis",6564);

             lege3.setDiagnose(pasient, "Kalle f�tter");

             lungeAvdeling.getPasienter().add(pasient2);



             sykehus.registrer(lungeAvdeling);


			for (Avdeling a: sykehus.getAvdelinger()) {
				System.out.println(a);
			}

             //Sortering
            //Antar at det eksisterer en getMetode for avdelingene i sykehus
            ArrayList<Avdeling> avdelinger = sykehus.getAvdelinger();
            Collections.sort(avdelinger, new AvdSortKomparator());


			Lege lege12 = new Lege("Max", "Rolig", 123);

			System.out.println(sykehus.fjern(ansatt2));
			System.out.println(sykehus.fjern(lege1));
			System.out.println(sykehus.fjern(lege1));
			System.out.println(sykehus.fjern(lege12));

			for (Avdeling a: sykehus.getAvdelinger()) {
							System.out.println(a);
			}



       }

}