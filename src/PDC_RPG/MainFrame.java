package PDC_RPG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MainFrame extends JFrame implements PanelConfig{
    JPanel panel;
    static int[][] NPCS = new int[Map_Reader.height][Map_Reader.width];
    static NPC boss;
    
    public MainFrame(){
        for (int i = 0; i < Map_Reader.height; i++){
            for (int j = 0; j < Map_Reader.width; j++){
                MainFrame.NPCS[i][j] = 0;
            }
        }
        boss = new BOSS();
        
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
        boolean ifn = false;
        
        @Override
        public void paint(Graphics g){
            super.paint(g);
            MapRefresh(g);
            Player.PlayerRefresh(g);
            if (boss.isTrigger()) boss.drawtalk(g);
            
            repaint();
        }
            
        public void MapRefresh(Graphics g){
            int yi = Player.y - 5 > 0? Player.y - 5 : 0;
            int xj = Player.x - 6 > 0? Player.x - 6 : 0;
            int ym = Player.y - 5 < 0? Math.abs(Player.y - 5) : 0;
            int xm = Player.x - 6 < 0? Math.abs(Player.x - 6) : 0;
            
            for (int i = yi; (i <= Player.y + 5) && (i < 23); i++){
                for (int j = xj; (j <= Player.x + 6) && (j < 13); j++){
                    ImageIcon icon = GetIcon.geticon(Map_Reader.map[i][j]);
                    g.drawImage(icon.getImage(), 50 * (j - xj + xm), 50 * (i - yi + ym), elesize, elesize, null);
                    NPC dnpc = ifNpc(j, i, boss);
                    if (dnpc != null){
                        g.drawImage(dnpc.getIcon().getImage(), 50 * (j - xj + xm), 50 * (i - yi + ym) - 25, 50, 75, null);
                    }
                }
            }
        }
        
        public NPC ifNpc(int x, int y, NPC npc){
            if (x == npc.getx() && y == npc.gety()){
                ifn = true;
                return npc;
            }else return null;
        }
        
    }
    
    private static class PanelListenner extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            boolean x = boss.isTrigger();
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP:
                    if (!x) Player.up = true;
                    break;
                case KeyEvent.VK_DOWN:
                    if (!x) Player.down = true;
                    break;
                case KeyEvent.VK_LEFT:
                    if (!x) Player.left = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    if (!x) Player.right = true;
                    break;
                case KeyEvent.VK_Z:
                    DetectTalk(boss);
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

        private void DetectTalk(NPC npc) {
            if (Player.x == npc.getx() && Player.y - 1== npc.gety() && Player.towards == 1) {
                if (npc.isTrigger()){
                    npc.nextstep();
                }else{
                    npc.setTrigger(true);
                }
                
            }
            if (Player.x == npc.getx() && Player.y + 1 == npc.gety() && Player.towards == 2) {
                if (npc.isTrigger()){
                    npc.nextstep();
                }else{
                    npc.setTrigger(true);
                }
            }
            if (Player.x - 1 == npc.getx() && Player.y == npc.gety() && Player.towards == 3) {
                if (npc.isTrigger()){
                    npc.nextstep();
                }else{
                    npc.setTrigger(true);
                }
            }
            if (Player.x + 1 == npc.getx() && Player.y == npc.gety() && Player.towards == 4) {
                if (npc.isTrigger()){
                    npc.nextstep();
                }else{
                    npc.setTrigger(true);
                }
            }
        }
    }
}