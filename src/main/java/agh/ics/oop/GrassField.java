package agh.ics.oop;

import java.util.HashMap;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    int n;
    Vector2d lowerLeftGrass, upperRightGrass;
    HashMap<Vector2d, Grass> grasses = new HashMap<>();
    public GrassField(int n) {
            this.n = n;
            this.lowerLeft = new Vector2d(0, 0);
            this.upperRight = new Vector2d((int) sqrt(n * 10), (int) sqrt(n * 10));
            for (int i = 0; i < n; i++) {
                plant();
            }
        }

        public void plant(){
            Random generator = new Random();
            Vector2d position;
            do {
                position = new Vector2d(generator.nextInt((int) sqrt(n * 10)), generator.nextInt((int) sqrt(n * 10)));
            } while (isOccupied(position));

            Grass grass = new Grass(position);
            grasses.put(position, grass);
        }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position))
            return true;

        return grasses.get(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(super.objectAt(position) != null) {
            return super.objectAt(position);
        }
        if(grasses.get(position)!=null) {
            return grasses.get(position);
        }
        else {
            return null;
        }
    }

    public Vector2d[] map_size(){
        Vector2d[] size = {new Vector2d(0,0), new Vector2d(0,0)};
        if (grasses.isEmpty() == false) {
            for(Grass grass: grasses.values()){
                size[0] = size[0].lowerLeft(grass.getPosition());
                size[1] = size[1].upperRight(grass.getPosition());
            }
        }
        if(animals.isEmpty() == false){
            for(Animal animal: animals.values()){
                size[0] = size[0].lowerLeft(animal.getPosition());
                size[1] = size[1].upperRight(animal.getPosition());
            }
        }
        return size;
    }
}
