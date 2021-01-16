package PDC_RPG;

import java.io.*;

public class Map_Reader {
    static int[][] map;
    
    static void readmap(String path){
        
        try{
            FileInputStream fis = new FileInputStream(path);
            DataInputStream dis = new DataInputStream(fis);
            
            int height = dis.readInt();
            int width = dis.readInt();
            System.out.println(height + " " +width);
            
            map = new int[height][width];
            
            for (int i = 0; i < height; i++){
                for (int j = 0; j < width; j++){
                    map[i][j] = dis.readInt();
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            
            dis.close();
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
