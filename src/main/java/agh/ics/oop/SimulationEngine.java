package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{

      private final List<Animal> animals = new ArrayList<>();
      public  MoveDirection[] direction;
      public IWorldMap map;
      public Vector2d[] initialPositions;

    SimulationEngine(MoveDirection[] direction, IWorldMap map, Vector2d[] initialPositions){
        this.direction = direction;
        this.map = map;

        for(Vector2d position: initialPositions) {
            Animal newAnimal = new Animal(map, position);
            if(!map.isOccupied(position)){
                if(map.place(newAnimal)){
                    animals.add(newAnimal);
                }
            }
        }
    }
    @Override
    public void run() {
        int i = 0;

        for (MoveDirection directions : this.direction) {

            if(i != animals.size()) {
                Animal animal = null;
                animal = animals.get(i);
                animal.move(directions, this.map);
                //out.println("Zwierze nr: "+ (i+1) + " pozycja: " + animal);
            }
            i++;
            if(i == animals.size()){
                i = 0;
            }
        }
    }

}
