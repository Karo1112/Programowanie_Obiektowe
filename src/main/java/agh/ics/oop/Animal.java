package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    Animal(MapDirection orientation, Vector2d position) {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public String toString() {
        return ("Pozycja: (" + position.x + "," + position.y + ")" + " Orientacja: " + orientation);
    }

    boolean isAt(Vector2d position) {
        return position != null && this.position.x == position.x && this.position.y == position.y;
    }

    Object move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> {
                this.orientation = this.orientation.next();
            }
            case LEFT -> {
                this.orientation = this.orientation.previous();
            }
            case FORWARD -> {
                if (this.position.x < 4 && this.position.y < 4) {
                    this.position = this.position.add(Objects.requireNonNull(this.orientation.toUnitVector()));
                }
            }
            case BACKWARD -> {
                if (this.position.x > 0 && this.position.y > 0) {
                    this.position = this.position.subtract(Objects.requireNonNull(this.orientation.toUnitVector()));
                }
            }
        }
        return new Animal(this.orientation, this.position);
    }
}

/* Odpowiedź na 10 pytanie
Można zastosować if i sprawdzić czy pozycja dwóch zwierząt jest taka sama.
Jeśli jest to zwracamy pozycję jednego zwierzęcia a drugie np. idzie do przodu/do tyłu albo wraca
na swoją pozycję początkową.
 */
