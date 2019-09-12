package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DBConnection {

    private static final String username = "maxts";
    private static final String password = "8d7PCGSl";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String dBUrl = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/" + username + "?user=" + username + "&password=" + password;

    // Standard JDBC components
    private static Connection con;
    private static Statement stmt;
    private static ResultSet res;
    private static ResultSetMetaData rsmd;

    // Use this whenever you want to connect to the database
    public static Connection getCon() {
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(dBUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static boolean insertMessage(Connection con, String message) {
        try {
            //Fungerer
            stmt = con.createStatement();
            String varname1 = insert into chat(userID, input) values (userId, message);";
            stmt.executeUpdate("insert into messages(userID, input) values ('" + g  +'" + message +"', );");
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<String> getMessages(Connection con) {
        try {
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from messages");
            ArrayList<String> words = new ArrayList<>();
            while (res.next()) {
                if (!(res.getString("message").equals(""))) {
                    words.add(res.getString("message"));
                }
            }
            return words;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void clearTable(Connection con) {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("delete from messages");
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }


    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
