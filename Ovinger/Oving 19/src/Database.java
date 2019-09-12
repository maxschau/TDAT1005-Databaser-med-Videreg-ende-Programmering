import java.sql.*;

public class Database {
    private static final String username = "maxts";
    private static final String password = "8d7PCGSl";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String dBUrl = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/" + username + "?user=" + username + "&password=" + password;

    private static Connection con;
    private static Statement stmt;

    public Database() {
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(dBUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            lukkForbindelse();
        }

    }

    public void lukkForbindelse() {
        try {
            con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void rullTilbake() {
        try {
            con.rollback();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void slåPåAutoCommit() {
        try {
            con.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean regNyBok(Bok nyBok){
        try {
            stmt = con.createStatement();
            con.setAutoCommit(false);
            String isbn = nyBok.getIsbn();
            String tittel = nyBok.getTittel();
            String forfatter = nyBok.getForfatter();
            //prepare statements
            stmt.executeUpdate("insert into boktittel(isbn, forfatter, tittel) values ('" + isbn + "','" + tittel + "','" + forfatter + "');");
            stmt.executeUpdate("insert into eksemplar(isbn, eks_nr) values ('" + isbn + "',1);");
            con.commit();
            return true;
        } catch (SQLException e) {
            rullTilbake();
            e.printStackTrace();
        } finally {
            slåPåAutoCommit();
            lukkForbindelse();
        }
        return false;
    }

    public int regNyttEksemplar(String isbn) {
        try {
            stmt = con.createStatement();
            int antallEksemplarer = -1;
            ResultSet rs = stmt.executeQuery("select max(eks_nr) from eksemplar as antall where isbn = '" + isbn + "\'" + ";");
            while (rs.next()) {
                antallEksemplarer = rs.getInt("max(eks_nr)");
            }
            if (antallEksemplarer == -1) { //Dersom antallEksemplarer ikke er oppdatert
                return 0;
            }
            int nyttEksemplarNr = antallEksemplarer += 1;
            stmt.executeUpdate("insert into eksemplar(isbn, eks_nr) values ('" + isbn + "\'" + "," + nyttEksemplarNr + ");");
            return nyttEksemplarNr;
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            lukkForbindelse();
        }
        return 0;
    }

    public boolean lånUtEksemplar(String isbn, String navn, int eksNr) {
        try {
            stmt = con.createStatement();
            String sql = "update eksemplar set laant_av = '" + navn + "' where isbn ='" + isbn + "' and eks_nr = " + eksNr +";";
            if (stmt.executeUpdate(sql) == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            lukkForbindelse();
        }
        return false;
    }

}
