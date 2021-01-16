package PDC_RPG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MainFrame extends JFrame implements GameConfig{
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
            int yi = Player.y - 6 > 0? Player.y - 6 : 0;
            int xj = Player.x - 7 > 0? Player.x - 7 : 0;
            int ym = Player.y - 6 < 0? Math.abs(Player.y - 6) : 0;
            int xm = Player.x - 7 < 0? Math.abs(Player.x - 7) : 0;
            for (int i = yi; (i < Player.y + 6) && (i < 23); i++){
                for (int j = xj; (j < Player.x + 7) && (j < 13); j++){
                    ImageIcon icon = GetIcon.geticon(Map_Reader.map[i][j]);
                    g.drawImage(icon.getImage(), 50 * (j - xj + xm), 50 * (i - yi + ym), elesize, elesize, null);
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
