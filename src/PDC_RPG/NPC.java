package PDC_RPG;

import java.awt.Graphics;
import java.sql.*;
import javax.swing.*;

/**
 * 
 * This abstract class is used for the model of NPCs
 */


public abstract class NPC extends Thread{
    private boolean trigger = false;
    private boolean fight = false;
    String ID;
    ResultSet rs;
    private String Name;
    private int HP;
    private int attack;
    int nx;
    int ny;
    private int towards = 2;
    private int ftstage;
    
    private ImageIcon up;
    private ImageIcon down;
    private ImageIcon left;
    private ImageIcon right;
    private ImageIcon arrow = new ImageIcon("image\\arrow.png");
    private int choose;
    
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
    
    public ImageIcon getIcon(){
        switch (towards){
            case 1:
                return this.getUp();
            case 2:
                return this.getDown();
            case 3:
                return this.getLeft();
            case 4:
                return this.getRight();
            default:
                return null;
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
    
    public void setHp(int hp){
        this.HP = hp;
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
    
    public ImageIcon getUp() {
        return up;
    }

    public void setUp(String path) {
        this.up = new ImageIcon(path);
    }

    public ImageIcon getDown() {
        return down;
    }

    public void setDown(String path) {
        this.down = new ImageIcon(path);
    }

    public ImageIcon getLeft() {
        return left;
    }

    public void setLeft(String path) {
        this.left = new ImageIcon(path);
    }

    public ImageIcon getRight() {
        return right;
    }

    public void setRight(String path) {
        this.right = new ImageIcon(path);
    }
    
    public int getTowards() {
        return towards;
    }

    public void setTowards(int towards) {
        this.towards = towards;
    }
    
    public boolean isFight() {
        return fight;
    }

    public void setFight(boolean fight) {
        this.fight = fight;
    }
    
    public ImageIcon getArrow() {
        return arrow;
    }
    
    public abstract void drawtalk(Graphics g);
    public abstract void nextstep();
    public abstract void drawfight(Graphics g);
    public abstract void attack();
    public abstract void beattack();

    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    public int getFtstage() {
        return ftstage;
    }

    public void setFtstage(int ftstage) {
        this.ftstage = ftstage;
    }

}