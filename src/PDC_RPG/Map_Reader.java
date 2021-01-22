package PDC_RPG;

import java.io.*;

public class Map_Reader {
    static int[][] map;
    static int height;
    static int width;
    
    static void readmap(String path){
        
        try{
            FileInputStream fis = new FileInputStream(path);
            DataInputStream dis = new DataInputStream(fis);
            
            height = dis.readInt();
            width = dis.readInt();
            
            map = new int[height][width];
            
            for (int i = 0; i < height; i++){
                for (int j = 0; j < width; j++){
                    map[i][j] = dis.readInt();
                }
            }
            
            dis.close();
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}