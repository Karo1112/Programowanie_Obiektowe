package agh.ics.oop;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Vector2dTest {
    @Test
    public void equals(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(1,1);
        assertEquals(v2, v1);
    }
    @Test
    public void to_String(){
        Vector2d v1 = new Vector2d(1,1);
        assertEquals("(1,1)", v1.toString());
    }
    @Test
    public void precedes_true(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        assertTrue(v1.precedes(v2));
    }
    @Test
    public void precedes_false(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        assertFalse(v2.precedes(v1));
    }
    @Test
    public void follows_true(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        assertTrue(v2.follows(v1));
    }
    @Test
    public void follows_false(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        assertFalse(v1.follows(v2));
    }
    @Test
    public void upperRight(){
        Vector2d v1 = new Vector2d(1,4);
        Vector2d v2 = new Vector2d(2,3);
        assertEquals("(2,4)", v1.upperRight(v2).toString());
    }
    @Test
    public void lowerLeft(){
        Vector2d v1 = new Vector2d(1,4);
        Vector2d v2 = new Vector2d(2,3);
        assertEquals("(1,3)", v1.lowerLeft(v2).toString());
    }
    @Test
    public void add(){
        Vector2d v1 = new Vector2d(1,4);
        Vector2d v2 = new Vector2d(2,3);
        assertEquals("(3,7)", v1.add(v2).toString());
    }
    @Test
    public void subtract(){
        Vector2d v1 = new Vector2d(1,4);
        Vector2d v2 = new Vector2d(2,3);
        assertEquals("(-1,1)", v1.subtract(v2).toString());
    }
    @Test
    public void opposite(){
        Vector2d v1 = new Vector2d(1,4);
        assertEquals("(-1,-4)", v1.opposite().toString());
    }

}
