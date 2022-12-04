package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    Vector2d lowerLeft, upperRight;
    Map<Vector2d, Animal> animals = new HashMap<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
            return position.follows(lowerLeft) && position.precedes(upperRight);
    }
    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition()) == false)
        {
            return false;
        }
        if (isOccupied(animal.getPosition()) && (objectAt(animal.getPosition()) instanceof Animal)) {
            return false;
        }
        else {
            animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    public String toString(){
        Vector2d[] size = map_size();
        return new MapVisualizer(this).draw(size[0], size[1]);
    }

    protected abstract Vector2d[] map_size();

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
    {
        animals.put(newPosition, animals.remove(oldPosition));
    }
}
