package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    Vector2d lowerLeft, upperRight;
    List<Animal> animals = new ArrayList<>();

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
        if(canMoveTo(animal.getPosition()) == false)
        {
            return false;
        }
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

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            Vector2d actual = animal.getPosition();
            if (actual.x == position.x && actual.y == position.y) {
                return animal;
            }
        }
        return null;
    }

    public String toString(){
        Vector2d[] size = map_size();
        return new MapVisualizer(this).draw(size[0], size[1]);
    }

    protected abstract Vector2d[] map_size();
}
