package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    List<Animal> animals = new ArrayList<>();
    private int width;
    private int height;
    private final Vector2d upperRight;
    private final Vector2d lowerLeft;

    RectangularMap(int width, int height) {
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width, height);

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!isOccupied(position)) {
            return position.follows(lowerLeft) && position.precedes(upperRight);
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (isOccupied(position) == true) {
            return false;
        }
        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (objectAt(position) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: animals){
            Vector2d actual = animal.getPosition();
            if(actual.x == position.x && actual.y == position.y){
                return position;
            }
        }
        return null;
    }
   public String toString (IWorldMap map) {
       return new MapVisualizer(map).draw(this.lowerLeft, this.upperRight);
      }

}

