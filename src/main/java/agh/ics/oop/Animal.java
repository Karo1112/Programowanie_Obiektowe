package agh.ics.oop;

import java.util.ArrayList;
import java.util.Objects;

public class Animal {
    private MapDirection orientation;
    private IWorldMap map;
    private Vector2d position;

    private final ArrayList<IPositionChangeObserver> observers = new ArrayList<>();
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

    void move(MoveDirection direction, IWorldMap map) {
        {
            switch (direction) {
                case RIGHT -> {
                    this.orientation = this.orientation.next();
                }
                case LEFT -> {
                    this.orientation = this.orientation.previous();
                }
                case FORWARD -> {
                    Vector2d next = this.position.add(Objects.requireNonNull(this.orientation.toUnitVector()));
                    if (this.map.canMoveTo(next)) {
                        if (this.map.isOccupied(next) == false || !(this.map.objectAt(next) instanceof Animal)) {
                            positionChanged(this.position, next);
                            this.position = next;
                        }

                    }
                }
                case BACKWARD -> {
                    Vector2d next = this.position.subtract(Objects.requireNonNull(this.orientation.toUnitVector()));
                    if (this.map.canMoveTo(next)) {
                        if (this.map.isOccupied(next) == false || !(this.map.objectAt(next) instanceof Animal)) {
                            positionChanged(this.position, next);
                            this.position = next;
                        }

                    }
                }
            }
          //  new Animal(this.orientation, this.position);
        }
    }

    public Vector2d getPosition() {
        return this.position;
    }

    void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }
    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer: this.observers)
        {
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}




