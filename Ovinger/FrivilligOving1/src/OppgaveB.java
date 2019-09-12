import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import static javax.swing.JOptionPane.*;
import java.sql.ResultSet;

public class OppgaveB {
	public static void main(String[] args) {
		System.out.println("Starter opp...");
		String password = "8d7PCGSl";
		String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/maxts?user=maxts&password=" + password;
	      try(Connection con = DriverManager.getConnection(url);) {
		      Statement stmt = con.createStatement();
		      
		      String navnLest = showInputDialog("Skriv inn navn");
		      String isbnLest = showInputDialog("Skriv inn ISBN");
		      int eksNrLest = Integer.parseInt(showInputDialog("Skriv inn antall eksemplarer"));
		      
		      int resultat = stmt.executeUpdate("UPDATE eksemplar SET laant_av = " + "'"+ navnLest + "' WHERE isbn = '" +  isbnLest + "' AND eks_nr = " + eksNrLest + " AND laant_av is null");
		      if (resultat == 0) {
		    	  showMessageDialog(null, "Registrering var ikke vellykket");
		      } else {
		    	  showMessageDialog(null, "Registrering var vellykket");
		      }
		    	 
		      
	
	
		      //Må lukke strømmen til databasen
		      con.close();
	      }catch (Exception sq) {
	    	  System.out.println("SQL-Feil: " +sq);
	      }
	
	}
}
