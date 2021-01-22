package PDC_RPG;

import java.awt.*;
import javax.swing.*;

public class BOSS extends NPC{
    static ImageIcon background = new ImageIcon("background\\1.jpg");
    static ImageIcon fighticon = new ImageIcon("npc\\120.gif");
    static Fight ft;
    
    public BOSS(){
        this.ID = "2";
        this.nx = 6;
        this.ny = 1;
        MainFrame.NPCS[ny][nx] = 1;
        this.setMessage();
        this.setFtstage(0);
        this.setChoose(0);
        ft = new Fight(this);
        setUp("npc\\110.gif");
        setDown("npc\\120.gif");
        setLeft("npc\\130.gif");
        setRight("npc\\140.gif");
    }

    @Override
    public void run() {
        while(true){ 
            ending();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        this.setFtstage(1);
        this.setFight(true);
    }
    
    @Override
    public void drawfight(Graphics g){
        g.drawImage(background.getImage(), 0, 0, null);
        g.drawImage(Player.up1.getImage(), 150, 250, null);
        g.drawImage(fighticon.getImage(), 450, 50, null);
        g.setColor(Color.BLACK);
        g.fillRect(11, 351, 430, 150);
        g.fillRect(441, 351, 200, 150);
        g.fillRect(61, 41, 260, 100);
        g.fillRect(351, 221, 260, 100);
        g.setColor(Color.RED);
        g.drawRect(10, 350, 431, 151);
        g.drawRect(440, 350, 201, 151);
        g.drawRect(60, 40, 261, 101);
        g.drawRect(350, 220, 261, 101);
        Font font = new Font("Courier", Font.PLAIN, 20);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString("BOOS?", 70, 60);
        g.drawString("HP", 70, 110);
        g.setColor(Color.WHITE);
        g.drawString("Hero", 360, 240);
        g.drawString("HP", 360, 290);
        g.drawString("Attack", 510, 390);
        if (this.getFtstage() == 4) g.drawString("WAIT!", 510, 460);
        g.setColor(Color.GREEN);
        g.drawRect(110, 90, 201, 21);
        g.fillRect(111, 91, getHP() * 5, 20);
        g.drawRect(400, 270, 201, 21);
        g.fillRect(401, 271, Player.HP * 5, 20);
        g.drawString(String.valueOf(Player.HP), 40, 40);
        StageTalk(g);
        g.drawImage(this.getArrow().getImage(), 480, 370 + getChoose() * 70, null);
    }
    
    public void StageTalk(Graphics g){
        Font font = new Font("Courier", Font.PLAIN, 20);
        g.setFont(font);
        g.setColor(Color.WHITE);
        if (this.getFtstage() == 1) g.drawString("He looks manic, but a little tired?", 15, 375);
        if (this.getFtstage() == 2){
            g.drawString("\"Please, please kill me, ", 15, 375);
            g.drawString("I don't wanan fight anymore...\"", 15, 400);
            g.drawString("He said.", 15, 440);
        }
        if (this.getFtstage() == 3){
            g.drawString("\"NO! You can't against my will!\"", 15, 375);
            g.drawString("Said by a woman's voice.", 15, 415);
            g.drawString("Like the voice of princess?", 15, 440);
        }
        if (this.getFtstage() == 4){
            g.drawString("You remember that!", 15, 375);
            g.drawString("He's a hero you've seen in storybooks.", 15, 400);
            g.drawString("Why is he here?", 15, 425);
        }
    }
    
    public void attack(){
        ft.Attack();
        this.setFtstage(this.getFtstage() + 1);
    }
    
    public void beattack(){
        ft.beAttack();
    }
    
    public void ending(){
        if (this.isFight()){
            if (Player.HP <= 0 && this.getHP() <= 0){
                    System.out.println("end3");
                    MainFrame.end = 3;
                    this.setFight(false);
            }else{
                if (Player.HP <= 0){
                        System.out.println("end2");
                        MainFrame.end = 2;
                        this.setFight(false);
                }
                if (this.getHP() <= 0){
                        System.out.println("end1");
                        MainFrame.end = 1;
                        this.setFight(false);
                }
            }
        }
    }
}