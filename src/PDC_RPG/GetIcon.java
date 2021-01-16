package PDC_RPG;

import javax.swing.*;

public class GetIcon implements GameConfig{
    static ImageIcon geticon(int num){
        switch (num){
            case 0:
                return icon0;
            case 1:
                return icon1;
            case 2:
                return icon2;
            case 3:
                return icon3;
            case 9:
                return icon9;
            default:
                return null;
        }
    }
}