package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    List<Animal> animals = new ArrayList<>();
    private int width;
    private int height;
    private final Vector2d upperRight;
    private final Vector2d lowerLeft;

    RectangularMap(int width, int height) {
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width, height);

    }

    public boolean canMoveTo(Vector2d position) {
        if(!isOccupied(position)) {
            return position.follows(lowerLeft) && position.precedes(upperRight);
        }
        return false;
    }
    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: animals){
            Vector2d actual = animal.getPosition();
            if(actual.x == position.x && actual.y == position.y){
                return animal;
            }
        }
        return null;
    }

    public Vector2d[] map_size(){
        Vector2d[] size = new Vector2d[]{this.lowerLeft, this.upperRight};
        return size;
    }
}

