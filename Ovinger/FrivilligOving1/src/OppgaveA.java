import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import static javax.swing.JOptionPane.*;
import java.sql.ResultSet;

public class OppgaveA {
	public static void main(String[] args) {
		System.out.println("Starter opp...");
		String password = "8d7PCGSl";
		String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/maxts?user=maxts&password=" + password;
	      try(Connection con = DriverManager.getConnection(url);) {
		      Statement stmt = con.createStatement();
		      
		      String isbnLest = showInputDialog("Skriv inn ISBN");
	
		      ResultSet res = stmt.executeQuery("SELECT forfatter, tittel FROM boktittel WHERE isbn ='" +  isbnLest + "'");
		      
		      while (res.next()) {
		    	  System.out.println("Forfatter: " + res.getString("forfatter"));
		    	  System.out.println("Tittel: " + res.getString("tittel"));
		      }
		      
		      ResultSet antall = stmt.executeQuery("SELECT COUNT(*) antall FROM eksemplar WHERE isbn ='" +  isbnLest+ "'");
		      while (antall.next()) {
		    	  System.out.println("Antall eksemplarer: " + antall.getInt("antall"));
		      }
		      
	
	
		      //Må lukke strømmen til databasen
		      con.close();
	      }catch (Exception sq) {
	    	  System.out.println("SQL-Feil: " +sq);
	      }
	
	}
}
