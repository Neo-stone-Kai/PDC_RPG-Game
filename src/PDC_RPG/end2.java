package PDC_RPG;

import java.awt.*;

/**
 *
 * Boss defeat hero
 */
public class end2 {
    public static int stage = 0;
    public static void enddrawer(Graphics g){
        g.setColor(Color.RED);
        g.drawRect(10, 300, 131, 51);
        g.drawRect(10, 350, 581, 151);
        g.setColor(Color.BLACK);
        g.fillRect(11, 301, 130, 50);
        g.fillRect(11, 351, 580, 150);
        first(g);
        if (stage >= 300) Thanks.thank(g);
    }
    
    public static void first(Graphics g){
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 30);
        g.setFont(font);
        g.drawString("Princess", 15, 345);
        g.setColor(Color.WHITE);
        font = new Font("Courier", Font.PLAIN, 20);
        g.setFont(font);
        g.drawString("Is that all you got?", 15, 425);
        g.drawString("Boring.", 15, 455);
        stage++;
    }
    
}
