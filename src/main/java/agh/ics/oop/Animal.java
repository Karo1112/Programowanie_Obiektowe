package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection orientation;
    private IWorldMap map;
    private Vector2d position;

    // PYTANIE O KONSTRUKTOR:
    //Można stworzyc jeden konstruktor, który będzie zawierał orientacje, pozycje, i map

    Animal(MapDirection orientation, Vector2d position) {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    public String toString() {
        String orientation = null;
        if (this.orientation == MapDirection.NORTH){
            orientation = "N";
        }
        if (this.orientation == MapDirection.SOUTH){
            orientation = "S";
        }
        if (this.orientation == MapDirection.EAST){
            orientation = "E";
        }
        if (this.orientation == MapDirection.WEST){
            orientation = "W";
        }
        return orientation;
    }

    public MapDirection getOrientation(){
        return this.orientation;
    }
    boolean isAt(Vector2d position) {
        return position != null && this.position.x == position.x && this.position.y == position.y;
    }

    public Animal move(MoveDirection direction) {
        Vector2d pos = null;
            switch (direction) {
                case RIGHT -> {
                    this.orientation = this.orientation.next();
                    pos = this.position;
                }
                case LEFT -> {
                    this.orientation = this.orientation.previous();
                    pos = this.position;
                }
                case FORWARD -> {
                       this.position =  this.position.add(Objects.requireNonNull(this.orientation.toUnitVector()));
                        pos = this.position;
                }
                case BACKWARD -> {
                      this.position = this.position.subtract(Objects.requireNonNull(this.orientation.toUnitVector()));
                      pos = this.position;
                }
            }
            if (this.map.canMoveTo(pos)){
                this.position = pos;
        }
        return this;
    }

    public Vector2d getPosition() {
        return this.position;
    }

}




