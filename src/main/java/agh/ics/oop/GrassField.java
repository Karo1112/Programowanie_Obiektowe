package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    int n;
    Vector2d lowerLeft, upperRight;
    List<Grass> grass = new ArrayList<>();

    GrassField(int n) {
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

        grass.add(new Grass(position));
    }

    public boolean planted(Vector2d position){
        for(Grass grasses: grass){
            if(grasses.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition())){
            if (objectAt(animal.getPosition()) instanceof Animal)
                return false;
            else if (objectAt(animal.getPosition()) instanceof Grass){
                grass.remove(new Grass(animal.getPosition()));
                plant();
            }
        }
        animals.add(animal);
        return true;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || planted(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            Vector2d actual = animal.getPosition();
            if (actual.x == position.x && actual.y == position.y) {
                return animal;
            }
        }
        for (Grass newGrass : grass) {
            Vector2d newPosition = newGrass.getPosition();
            if (newPosition.x == position.x && newPosition.y == position.y) {
                return newGrass;
            }
        }
        return null;
    }

    public Vector2d[] map_size(){
        Vector2d[] size = {new Vector2d(0,0), new Vector2d(0,0)};
        if (grass.isEmpty() == false) {
            for(Grass grasses: grass){
                size[0] = size[0].lowerLeft(grasses.getPosition());
                size[1] = size[1].upperRight(grasses.getPosition());
            }
        }
        if(animals.isEmpty() == false){
            for(Animal animal: animals){
                size[0] = size[0].lowerLeft(animal.getPosition());
                size[1] = size[1].upperRight(animal.getPosition());
            }
        }
        return size;
    }

}
