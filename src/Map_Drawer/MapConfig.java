package Map_Drawer;
import javax.swing.*;

public interface MapConfig {
    int eleWidth = 50;
    int eleHeight = 50;
    int MapWidth = 650;
    int MapHeight= 1150;

    String path = "image\\map.map";
	
    ImageIcon icon0 = new ImageIcon("image\\0.png");
    ImageIcon icon1 = new ImageIcon("image\\1.png");
    ImageIcon icon2 = new ImageIcon("image\\2.png");
    ImageIcon icon3 = new ImageIcon("image\\3.png");
    
    ImageIcon icon9 = new ImageIcon("image\\9.png");
    
    ImageIcon[] allicons = {icon0,icon1,icon2,icon3,icon9};
}
