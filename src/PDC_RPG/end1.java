package PDC_RPG;

import java.awt.*;

/**
* this shows the ending of hero defeat the boss
*/
public class end1 {
    public static int stage = 0;
    public static void enddrawer(Graphics g){
        endset();
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
    
    public static void endset(){
        MainFrame.NPCS[6][1] = 0;
        Player.x = 6;
        Player.y = 1;
        Player.towards = 2;
    }
    
    public static void first(Graphics g){
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 30);
        g.setFont(font);
        g.drawString("Princess", 15, 345);
        g.setColor(Color.WHITE);
        font = new Font("Courier", Font.PLAIN, 20);
        g.setFont(font);
        g.drawString("A new toy?", 15, 385);
        stage++;
    }
    
    public static void second(Graphics g){
        g.setColor(Color.WHITE);
        Font font = new Font("Courier", Font.PLAIN, 20);
        g.setFont(font);
        g.drawString("NICE JOB!", 15, 415);
        g.setColor(Color.RED);
        font = new Font("Courier", Font.PLAIN, 30);
        g.setFont(font);
        g.drawString("My \"Hero\".", 15, 445);
        stage++;
    }
}