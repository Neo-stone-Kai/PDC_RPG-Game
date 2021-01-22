package PDC_RPG;

import java.awt.*;

/**
 *
 * Thanks for your playing
 */
public class Thanks {
    public static void thank(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 650, 550);
         g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 50);
        g.setFont(font);
        g.drawString("Thanks for your playing!", 15, 275);
        font = new Font("Arial", Font.BOLD, 30);
        g.setFont(font);
        g.drawString("@Author: Weikai Zhang", 45, 325);
        g.drawString("For AUT_PDC", 45, 360);
    }
}
