package PDC_RPG;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseControl {
    
    //private final String url = "jdbc:derby://localhost:1527/RPG_DB;create=true";
    private final String url = "jdbc:derby:database\\RPG_DB; create=true";
    private final String username = "users";
    private final String password = "123456";
    
    private static Connection conn;
    private static Statement state;
    
    private static ResultSet rs;
    private static final String DRIVERCLASS = "org.apache.derby.jdbc.EmbeddedDriver";
    
    public DatabaseControl(){
        try {
            Class.forName(DRIVERCLASS).newInstance();
        } catch (Exception ex) {
            Logger.getLogger(DatabaseControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Connect() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            state = conn.createStatement();
            System.out.println(conn.getSchema() + " is connected");
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        
    }
    
    public ResultSet Get(String table, String key) {
        try {
            rs = state.executeQuery( "SELECT * FROM " + table + " WHERE " + "ID=" + key);
            rs.next();
        } catch (SQLException e) {
            
        }
        return rs;
    }
    
    public void Close(){
        try {
            rs.close();
            state.close();
            conn.close();
            System.out.println("closed");
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }
}