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
    
    static int HP = 40;
    static int attack = 10;
    
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
            if (MainFrame.NPCS[y - speed][x] != 1) y = y - speed > 0 ? (y - speed) : y;
            System.out.println(x + " " + y);
        }
        if (down){
            d++;
            if (d >= 12) d = 0;
            towards = 2;
            if (MainFrame.NPCS[y + speed][x] != 1)y = y + speed < 22 ? (y + speed) : y;
            System.out.println(x + " " + y);
        }
        if (left){
            l++;
            if (l >= 12) l = 0;
            towards = 3;
            if (MainFrame.NPCS[y][x - speed] != 1) x = x - speed > 0 ? (x - speed) : x;
            System.out.println(x + " " + y);
        }
        if (right){
            r++;
            if (r >= 12) r = 0;
            towards = 4;
            if (MainFrame.NPCS[y][x + speed] != 1) x = x + speed < 12 ? (x + speed) : x;
            System.out.println(x + " " + y);
        }
    }
    
    public static void PlayerRefresh(Graphics g){
            if(!up && !down && !left && !right){
                switch (towards){
                    case 1:
                        g.drawImage(up1.getImage(), px - 25, py - 50, 50, 75, null);
                        break;
                    case 2:
                        g.drawImage(down1.getImage(), px - 25, py - 50, 50, 75, null);
                        break;
                    case 3:
                        g.drawImage(left1.getImage(), px - 25, py - 50, 50, 75, null);
                        break;
                    case 4:
                        g.drawImage(right1.getImage(), px - 25, py - 50, 50, 75, null);
                        break;
                }
            }else{
                if (up){
                    if (u < 3){
                        g.drawImage(up1.getImage(), px - 25, py - 50, 50, 75, null);
                    }else if (u < 6){
                        g.drawImage(up2.getImage(), px - 25, py - 50, 50, 75, null);
                    }else if (u < 9){
                        g.drawImage(up3.getImage(), px - 25, py - 50, 50, 75, null);
                    }else if (u < 12){
                        g.drawImage(up4.getImage(), px - 25, py - 50, 50, 75, null);
                    }
                }
                if (down){
                    if (d < 3){
                        g.drawImage(down1.getImage(), px - 25, py - 50, 50, 75, null);
                    }else if (d < 6){
                        g.drawImage(down2.getImage(), px - 25, py - 50, 50, 75, null);
                    }else if (d < 9){
                        g.drawImage(down3.getImage(), px - 25, py - 50, 50, 75, null);
                    }else if (d < 12){
                        g.drawImage(down4.getImage(), px - 25, py - 50, 50, 75, null);
                    }
                }
                if (left){
                    if (l < 3){
                        g.drawImage(left1.getImage(), px - 25, py - 50, 50, 75, null);
                    }else if (l < 6){
                        g.drawImage(left2.getImage(), px - 25, py - 50, 50, 75, null);
                    }else if (l < 9){
                        g.drawImage(left3.getImage(), px - 25, py - 50, 50, 75, null);
                    }else if (l < 12){
                        g.drawImage(left4.getImage(), px - 25, py - 50, 50, 75, null);
                    }
                }
                if (right){
                    if (r < 3){
                        g.drawImage(right1.getImage(), px - 25, py - 50, 50, 75, null);
                    }else if (r < 6){
                        g.drawImage(right2.getImage(), px - 25, py - 50, 50, 75, null);
                    }else if (r < 9){
                        g.drawImage(right3.getImage(), px - 25, py - 50, 50, 75, null);
                    }else if (r < 12){
                        g.drawImage(right4.getImage(), px - 25, py - 50, 50, 75, null);
                    }
                }
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