package agh.ics.oop;

import java.util.Objects;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        //Moje sprawdzenia czy wszystko działa
        Vector2d a = new Vector2d(2,3);
        Vector2d b = new Vector2d(3,4);
        out.println(a.add(b));
        out.println(a.subtract(b));
        out.println(a.upperRight(b));
        out.println(a.lowerLeft(b));
        out.println(a.opposite());
        out.println(MapDirection.NORTH.toString());
        out.println(MapDirection.EAST.toString());
        out.println(MapDirection.WEST.toString());
        out.println(MapDirection.SOUTH.toString());
        out.println(MapDirection.NORTH.next());
        out.println(MapDirection.EAST.next());
        out.println(MapDirection.SOUTH.next());
        out.println(MapDirection.WEST.next());
        out.println(MapDirection.NORTH.previous());
        out.println(MapDirection.EAST.previous());
        out.println(MapDirection.SOUTH.previous());
        out.println(MapDirection.WEST.previous());
        out.println(MapDirection.NORTH.toUnitVector());
        out.println(MapDirection.EAST.toUnitVector());
        out.println(MapDirection.SOUTH.toUnitVector());
        out.println(MapDirection.WEST.toUnitVector());


    }
}

    class Vector2d {
        final public int x;
        final public int y;

        Vector2d(int x, int y) {
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
            return Objects.hash(x, y); //trzeba dodać hashCode
        }
    }

