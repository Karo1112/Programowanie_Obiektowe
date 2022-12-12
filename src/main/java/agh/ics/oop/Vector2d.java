package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    final public int x;
    final public int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return ("(" + x + "," + y + ")");
    }

    boolean precedes(Vector2d other) {
        if(other instanceof Vector2d && this.x <= other.x && this.y <= other.y){
            return true;
        }
        return false;
    }

    boolean follows(Vector2d other) {
        if (other instanceof Vector2d && this.x >= other.x && this.y >= other.y) {
            return true;
        }
        return false;
    }
    Vector2d add(Vector2d other){
        return new Vector2d(x+other.x, y+other.y);
    }
    Vector2d subtract(Vector2d other){
        return new Vector2d(x-other.x, y-other.y);
    }
    Vector2d upperRight(Vector2d other){
        int upper1;
        int upper2;
        if(x >= other.x){
            upper1 = x;
        }
        else upper1 = other.x;
        if(y >= other.y){
            upper2 = y;
        }
        else upper2 = other.y;
        return new Vector2d(upper1, upper2);
    }
    Vector2d lowerLeft(Vector2d other){
        int lower1;
        int lower2;
        if(x <= other.x){
            lower1 = x;
        }
        else lower1 = other.x;
        if(y <= other.y){
            lower2 = y;
        }
        else lower2 = other.y;
        return new Vector2d(lower1, lower2);
    }

    Vector2d opposite(){
        return new Vector2d(-x, -y);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }
    public int hashCode() {
        return Objects.hash(this.x, this.y); //trzeba dodać hashCode
    }
}

