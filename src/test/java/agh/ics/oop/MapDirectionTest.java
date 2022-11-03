package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    @Test
    public void next_NORTH(){
        MapDirection next = MapDirection.NORTH;
        assertEquals(MapDirection.EAST, next.next());
    }
    @Test
    public void next_EAST(){
        MapDirection next = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH, next.next());
    }
    @Test
    public void next_SOUTH(){
        MapDirection next = MapDirection.SOUTH;
        assertEquals(MapDirection.WEST, next.next());
    }
    @Test
    public void next_WEST(){
        MapDirection next = MapDirection.WEST;
        assertEquals(MapDirection.NORTH, next.next());
    }
    @Test
    public void previous_NORTH(){
        MapDirection previous = MapDirection.NORTH;
        assertEquals(MapDirection.WEST, previous.previous());
    }
    @Test
    public void previous_EAST(){
        MapDirection previous = MapDirection.EAST;
        assertEquals(MapDirection.NORTH, previous.previous());
    }
    @Test
    public void previous_SOUTH(){
        MapDirection previous = MapDirection.SOUTH;
        assertEquals(MapDirection.EAST, previous.previous());
    }
    @Test
    public void previous_WEST(){
        MapDirection previous = MapDirection.WEST;
        assertEquals(MapDirection.SOUTH, previous.previous());
    }
}
