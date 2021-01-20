package PDC_RPG;

import java.awt.*;

public class BOSS extends NPC{
    
    public BOSS(){
        this.ID = "2";
        this.nx = 6;
        this.ny = 1;
        MainFrame.NPCS[ny][nx] = 1;
        this.setMessage();
        setIcon("npc\\100.gif");
    }

    @Override
    public void trigger() {
        if (isTrigger()){
            
        }
    }
    
    @Override
    public void drawtalk(Graphics g){
        g.setColor(Color.RED);
        g.drawRect(10, 300, 131, 51);
        g.drawRect(10, 350, 581, 151);
        g.setColor(Color.BLACK);
        g.fillRect(11, 301, 130, 50);
        g.fillRect(11, 351, 580, 150);
        g.setColor(Color.RED);
        Font font = new Font("Arial", Font.BOLD, 30);
        g.setFont(font);
        g.drawString(this.getNpcName(), 15, 335);
        g.setColor(Color.WHITE);
        font = new Font("Courier", Font.PLAIN, 20);
        g.setFont(font);
        g.drawString("War...Slaughter...", 15, 375);
        g.setColor(Color.RED);
        
        font = new Font("Courier", Font.BOLD, 40);
        g.setFont(font);
        g.drawString("Kill!!! I'll Kill you!", 15, 440);
    }

    @Override
    public void nextstep() {
        this.setTrigger(false);
    }
    
}
