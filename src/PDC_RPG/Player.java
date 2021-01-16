package PDC_RPG;


public class Player extends Thread implements GameConfig{
    static int px = PanelWidth / 2;
    static int py = PanelHeight / 2;
    
    static int speed = 1;
    
    static int x = 6;
    static int y = 10;
    
    static int mx = 6;
    static int my = 10;
    
    static boolean up = false;
    static boolean down = false;
    static boolean left = false;
    static boolean right = false;
    
    public void move() {
        if (up){
            y = y - speed > 0 ? (y - speed) : y;
        }
        if (down){
            y = y + speed < 23 ? (y + speed) : y;
        }
        if (left){
            x = x - speed > 0 ? (x - speed) : x;
        }
        if (right){
            x = x + speed < 13 ? (x + speed) : x;
        }
        
    }
    
    @Override
    public void run() {
        while(true){
            move();
            try {
                Thread.sleep(80);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
