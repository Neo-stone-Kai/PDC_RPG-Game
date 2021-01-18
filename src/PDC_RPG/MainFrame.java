package PDC_RPG;

import static PDC_RPG.Player.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MainFrame extends JFrame implements PanelConfig{
    JPanel panel;
    
    public MainFrame(){
        init();
    }
    
    private void init(){
        this.setTitle("A simple RPG Game");
        this.setSize(FrameWidth, FrameHeight);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(3);
        
        panelinit();
        
        this.add(panel);
        this.setVisible(true);
        
        PanelListenner plis = new PanelListenner(); 
        this.addKeyListener(plis);
        
        Player player = new Player();
        player.start();
        
        UpdateThread ut = new UpdateThread(panel);
        ut.start();
    }

    private void panelinit() {
        panel = new MyPanel();
        panel.setPreferredSize(new Dimension(PanelWidth, PanelHeight));  
        panel.setLayout(null);  
        panel.setBackground(Color.RED);
    }

    
    class MyPanel extends JPanel{
        @Override
        public void paint(Graphics g){
            super.paint(g); 
            
            //Map refresh
            int yi = Player.y - 6 > 0? Player.y - 6 : 0;
            int xj = Player.x - 6 > 0? Player.x - 6 : 0;
            int ym = Player.y - 6 < 0? Math.abs(Player.y - 6) : 0;
            int xm = Player.x - 6 < 0? Math.abs(Player.x - 6) : 0;
            
            for (int i = yi; (i <= Player.y + 6) && (i < 23); i++){
                for (int j = xj; (j <= Player.x + 6) && (j < 13); j++){
                    ImageIcon icon = GetIcon.geticon(Map_Reader.map[i][j]);
                    g.drawImage(icon.getImage(), 50 * (j - xj + xm), 50 * (i - yi + ym), elesize, elesize, null);
                }
            }
            
            //Player Model
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
                       
            
            repaint();
        }
            
        
    }
    
    private static class PanelListenner extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP:
                    Player.up = true;
                    break;
                case KeyEvent.VK_DOWN:
                    Player.down = true;
                    break;
                case KeyEvent.VK_LEFT:
                    Player.left = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    Player.right = true;
                    break;
                default:
                    break;
            }
            
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP:
                    Player.up = false;
                    break;
                case KeyEvent.VK_DOWN:
                    Player.down = false;
                    break;
                case KeyEvent.VK_LEFT:
                    Player.left = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    Player.right = false;
                    break;
                default:
                    break;
            }
        }
        
        
    }
}