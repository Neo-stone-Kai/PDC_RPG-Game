package PDC_RPG;

import java.awt.Graphics;
import java.sql.*;
import javax.swing.*;

public abstract class NPC extends Thread{
    private boolean trigger = false;
    String ID;
    ResultSet rs;
    private String Name;
    private int HP;
    private int attack;
    int nx;
    int ny;
    
    
    private ImageIcon icon;
    

    @Override
    public void run() {
        while(isTrigger()){
            trigger();
        }
    }
    
    public void setMessage(){
        DatabaseControl DB = new DatabaseControl();
        DB.Connect();
        this.rs = DB.Get("NPC", ID);
        try {
            this.Name = rs.getString("Name");
            this.HP = rs.getInt("HP");
            this.attack = rs.getInt("attack");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
        
    
    public int getx(){
        return nx;
    }
    
    public int gety(){
        return ny;
    }
    
    public String getNpcName() {
        return Name;
    }

    public int getHP() {
        return HP;
    }

    public ImageIcon getIcon() {
        return icon;
    }
    
    public void setIcon(String path){
        icon = new ImageIcon(path);
    }

    public int getAttack() {
        return attack;
    }
    
    public boolean isTrigger() {
        return trigger;
    }

    public void setTrigger(boolean trigger) {
        this.trigger = trigger;
    }
    public abstract void trigger();
    public abstract void drawtalk(Graphics g);
    public abstract void nextstep();


}
