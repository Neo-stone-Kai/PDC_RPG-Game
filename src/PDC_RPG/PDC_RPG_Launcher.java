package PDC_RPG;

import java.sql.SQLException;

/**
 * Main launcher
 * @author Weikai Zhang
 */

public class PDC_RPG_Launcher {

public static void main(String[] args) throws SQLException {
        Map_Reader.readmap("image\\map.map");
        new MainFrame();
    }
    
}
