import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

class DatabaseWrapper {
	
  public static void main(String[] args) throws Exception {
      System.out.println("Starter opp...");
      String password = "8d7PCGSl";


      String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/maxts?user=maxts&password=" + password;
      try(Connection con = DriverManager.getConnection(url);) {

      Statement stmt = con.createStatement();
      
      //stmt.executeUpdate("INSERT INTO person (`persnr`, `fornavn`, `etternavn`) VALUES ('99','Anders','Nilsen')");
      //stmt.executeUpdate("INSERT INTO person (`persnr`, `fornavn`, `etternavn`) VALUES ('102','Guro','Andersen')");
      
      ResultSet res = stmt.executeQuery("SELECT * FROM person ORDER BY persnr");
      
      while (res.next()) {
    	System.out.println("Personnr: " + res.getInt("persnr"));
        System.out.println("Fornavn: " + res.getString("fornavn"));
        System.out.println("Etternavn: " + res.getString("etternavn"));
      }

      //Må lukke strømmen til databasen
      con.close();
      }catch (Exception sq) {
    	  System.out.println("SQL-Feil: " +sq);
      }

  	
  }
}
