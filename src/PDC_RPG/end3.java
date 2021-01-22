package PDC_RPG;

import java.awt.*;
import javax.swing.ImageIcon;

/**
 *
 * Both of them die
 */
public class end3 {
    public static int stage = 0;
    public static ImageIcon image1 = new ImageIcon("npc\\220.gif");
    public static ImageIcon image2 = new ImageIcon("npc\\320.gif");
    
    public static void enddrawer(Graphics g){
        g.setColor(Color.RED);
        g.drawRect(10, 300, 131, 51);
        g.drawRect(10, 350, 581, 151);
        g.setColor(Color.BLACK);
        g.fillRect(11, 301, 130, 50);
        g.fillRect(11, 351, 580, 150);
        first(g);
        if (stage >= 200) second(g);
        if (stage >= 500) Thanks.thank(g);
    }
    
    public static void first(Graphics g){
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 30);
        g.setFont(font);
        g.drawString("Princess", 15, 345);
        g.setColor(Color.WHITE);
        font = new Font("Courier", Font.PLAIN, 20);
        g.setFont(font);
        if (stage < 200) {
            g.drawString("Humm..There is no toy for me", 15, 425);
            g.drawImage(image2.getImage(), 300, 225, null);
        }
        stage++;
    }
    
    public static void second(Graphics g){
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 30);
        g.setFont(font);
        g.drawString("Princess", 15, 345);
        g.setColor(Color.WHITE);
        font = new Font("Courier", Font.PLAIN, 20);
        g.setFont(font);
        g.drawString("I'm going to search my new toy", 15, 425);
        g.drawImage(image1.getImage(), 300, 225, null);
        stage++;
    }
}
