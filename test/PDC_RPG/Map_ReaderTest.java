/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDC_RPG;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lenovo
 */
public class Map_ReaderTest {
    
    public Map_ReaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readmap method, of class Map_Reader.
     */
    @Test
    public void testReadmap1() {
        System.out.println("Map Reader Test1:");
        String path = "image\\map.map";
        Map_Reader.readmap(path);
        int result = Map_Reader.map[0][0];
        int expect = 9;
        assertEquals(expect, result, 0);
        System.out.println("Map Reader test1 passed");
    }
    
    @Test
    public void testReadmap2() {
        System.out.println("Map Reader Test2:");
        String path = "image\\map.map";
        Map_Reader.readmap(path);
        int result = Map_Reader.map[21][2];
        int expect = 0;
        assertEquals(expect, result, 0);
        System.out.println("Map Reader test2 passed");
    }
}
