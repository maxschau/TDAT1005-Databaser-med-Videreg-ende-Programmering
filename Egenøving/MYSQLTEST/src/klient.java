import static javax.swing.JOptionPane.*;
import java.sql.*;

public class klient {
    public static void main(String[] args) {
        String[] ALTERNATIVER = {"Registrer ny person", "Vis alle personer", "Avslutt"};
        int valg = showOptionDialog(null, "Velg et alternativ", "Boks", YES_NO_OPTION, QUESTION_MESSAGE , null, ALTERNATIVER, ALTERNATIVER[0]);


        while (valg != 2) {
            switch(valg) {
                case 0:
                    //int alder = Integer.parseInt(alderLest);
                    //Student s1 = new Student(navnLest, alder);
                    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/registrering?" + "user=root&password=Saraerbest123&seJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")) {
                        String navnLest = showInputDialog("Skriv inn nanvet");
                        String alder2 = showInputDialog("Skriv inn alder");
                        String alder = "'" + alder2 + "'";
                        String navn = "'" + navnLest + "'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("insert into student (navn, alder) values ('" + navn + "','" +  alder + "')");
                        con.close();
                    }catch(Exception sq) {
                        System.out.println("Feil: " + sq);
                    }
                    break;

                case 1:
                    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/registrering?" + "user=root&password=Saraerbest123&seJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")) {
                        Statement stmt = con.createStatement();
                        String resultat = "Registrerte studenter: " + "\n";
                        ResultSet res = stmt.executeQuery("Select * from student order by id");
                        while (res.next()) {
                            resultat += "ID: " + res.getInt("id") + "\n";
                            resultat += "Navn: " + res.getString("navn") + "\n";
                            resultat += "Alder: " + res.getInt("alder") + "\n";

                        }
                        showMessageDialog(null,resultat);
                        con.close();
                    }catch(Exception sq) {
                        System.out.println("Feil: " + sq);
                    }
                    break;
            }

            valg = showOptionDialog(null, "Velg et alternativ", "Boks", YES_NO_OPTION, QUESTION_MESSAGE , null, ALTERNATIVER, ALTERNATIVER[0]);
        }
    }
}
