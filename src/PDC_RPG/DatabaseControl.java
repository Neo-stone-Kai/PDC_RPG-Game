package PDC_RPG;

import java.sql.*;

public class DatabaseControl {
    private final String url = "jdbc:derby://localhost:1527/RPG_DB";
    private final String username = "users";
    private final String password = "123456";
    
    private static Connection conn;
    private static Statement state;
    
    private static ResultSet rs;

    public DatabaseControl(){
        
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