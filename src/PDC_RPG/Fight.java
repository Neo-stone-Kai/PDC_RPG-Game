package PDC_RPG;

public class Fight{
    NPC npc;
    
    public Fight(NPC npc){
        this.npc = npc;
    }
    
    //attack the npc
    public void Attack(){
        npc.setHp(npc.getHP() - Player.attack);
    }
    
    //be attacked
    public void beAttack(){
        Player.HP -= npc.getAttack();
        System.out.println(npc.getAttack());
    }
}