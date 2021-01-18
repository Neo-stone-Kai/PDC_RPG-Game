package PDC_RPG;

import java.awt.Graphics;
import javax.swing.*;

public class Player extends Thread implements PanelConfig{
    static int px = PanelWidth / 2;
    static int py = PanelHeight / 2;
    
    private int speed = 1;
    
    static int x = 6;
    static int y = 10;
    
    static boolean up = false;
    static boolean down = false;
    static boolean left = false;
    static boolean right = false;
    
    static int towards = 1;
    
    static int u = 0;
    static int d = 0;
    static int l = 0;
    static int r = 0;
    
    @Override
    public void run() {
        while(true){
            move();
            try {
                Thread.sleep(80);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void move() {
        if (up){
            u++;
            if (u >= 12) u = 0;
            towards = 1;
            y = y - speed > 0 ? (y - speed) : y;
            System.out.println(x + " " + y);
        }
        if (down){
            d++;
            if (d >= 12) d = 0;
            towards = 2;
            y = y + speed < 22 ? (y + speed) : y;
            System.out.println(x + " " + y);
        }
        if (left){
            l++;
            if (l >= 12) l = 0;
            towards = 3;
            x = x - speed > 0 ? (x - speed) : x;
            System.out.println(x + " " + y);
        }
        if (right){
            r++;
            if (r >= 12) r = 0;
            towards = 4;
            x = x + speed < 12 ? (x + speed) : x;
            System.out.println(x + " " + y);
        }
    }
    
    
    static ImageIcon up1 = new ImageIcon("npc\\001.gif");
    static ImageIcon up2 = new ImageIcon("npc\\002.gif");
    static ImageIcon up3 = new ImageIcon("npc\\003.gif");
    static ImageIcon up4 = new ImageIcon("npc\\004.gif");
    
    static ImageIcon down1 = new ImageIcon("npc\\011.gif");
    static ImageIcon down2 = new ImageIcon("npc\\012.gif");
    static ImageIcon down3 = new ImageIcon("npc\\013.gif");
    static ImageIcon down4 = new ImageIcon("npc\\014.gif");
    
    static ImageIcon left1 = new ImageIcon("npc\\021.gif");
    static ImageIcon left2 = new ImageIcon("npc\\022.gif");
    static ImageIcon left3 = new ImageIcon("npc\\023.gif");
    static ImageIcon left4 = new ImageIcon("npc\\024.gif");
    
    static ImageIcon right1 = new ImageIcon("npc\\031.gif");
    static ImageIcon right2 = new ImageIcon("npc\\032.gif");
    static ImageIcon right3 = new ImageIcon("npc\\033.gif");
    static ImageIcon right4 = new ImageIcon("npc\\034.gif");
}