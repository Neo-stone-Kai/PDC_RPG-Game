package Map_Drawer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/**
 * In order to draw the .map for rpg maps, I create a map drawer to create this file
 * We can click the panel to draw the block we choose to the panel
 * @author Weikai Zhang
 */

public class map_drawer extends JFrame implements MapConfig{
    
    JComboBox<ImageIcon> box;
    
    static int[][] map = new int[23][13];
    static ImageIcon[][] icons = new ImageIcon[23][13];
    static JPanel panel;
    
    public void init(){
        this.setTitle("Map Drawer");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
        
        panel = new MySetPanel();
        panel.setPreferredSize(new Dimension(MapWidth, MapHeight));
        
        JScrollPane jsp = new JScrollPane(panel);
        jsp.setPreferredSize(new Dimension(600, 600));
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        box = new JComboBox<ImageIcon>();
        setBox(box);
        
        JButton create = new JButton("Crate map");
        create.setActionCommand("create");
        
        PanelListenner plis = new PanelListenner();
	panel.addMouseListener(plis);
	Buttonlistenner blis = new Buttonlistenner();
	create.addActionListener(blis);
        
        this.add(jsp);
        this.add(box);
        this.add(create);
        this.setVisible(true);
    }
    
    public void setBox(JComboBox box){
        for(int i=0;i<allicons.length;i++){
            box.addItem(allicons[i]);
        }
    }
    
    class MySetPanel extends JPanel{
        
        public void paint(Graphics g) {
            super.paint(g);
            for(int i = 0; i < MapHeight/eleHeight; i++){
                for(int j = 0; j < MapWidth/eleWidth; j++){
                    if(icons[i][j] != null){
                        g.drawImage(icons[i][j].getImage(), getDrawX(j), getDrawY(i), eleWidth, eleHeight, null);
                    }
                }
            }
        }
		
        public int getDrawX(int j){
            int x = j * 50;
            return x;
        }
        
        public int getDrawY(int i){
            int y = i * 50; 	
            return y;
        }
    }
    
    class PanelListenner extends MouseAdapter{
        
        public void mouseClicked(MouseEvent e) {
            int i = e.getY() / eleHeight;
            int j = e.getX() / eleWidth;
            
            System.out.println(i + "<>" + j);
            
            ImageIcon icon = (ImageIcon)box.getSelectedItem();
            int num = Integer.valueOf(icon.toString().substring(6, 7));
            
            map[i][j] = num;
            icons[i][j] = icon;
            
            panel.repaint();
        }
    }
    
    class Buttonlistenner implements ActionListener{
        
        public void actionPerformed(ActionEvent e) {     
            if(e.getActionCommand().equals("create")){
                try{
                    System.out.println("start save");
                    FileOutputStream fos = new FileOutputStream(path);
                    DataOutputStream dos = new DataOutputStream(fos);
                    
                    int i = MapHeight / eleHeight;
                    int j = MapWidth / eleWidth;
                    
                    dos.writeInt(i);
                    dos.writeInt(j);
                    
                    for (int ii = 0; ii < i; ii++){
                        for(int jj = 0; jj < j; jj++){
                            dos.writeInt(map[ii][jj]);
                        }
                    }
                    
                    dos.flush();
                    dos.close();
                    
                    System.out.println("complete!");
                    
                }catch(Exception ex){
                    ex.printStackTrace();
		}
            }
        }
    }
    
    public static void main(String[] args) {
        map_drawer md = new map_drawer();
        md.init();
    }
}