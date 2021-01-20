package PDC_RPG;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        Map_Reader.readmap("image\\map.map");
        new MainFrame();
        
//        ResultSet rs = DB.Get("NPC", "1");
//        System.out.println(rs.getInt("HP"));
//        DB.Close();
    }
}