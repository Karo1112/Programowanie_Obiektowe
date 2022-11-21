package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class SimulationEngine implements IEngine{

      private final List<Animal> animals = new ArrayList<>();
      public  List<MoveDirection> direction;
      public IWorldMap map;
      public Vector2d[] initialPositions;

    SimulationEngine(List<MoveDirection> direction, IWorldMap map, Vector2d[] initialPositions){
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
    public List<String> run() {
        int i = 0;

        for (MoveDirection directions : direction) {

            if(i != animals.size()) {
                Animal animal = null;
                animal = animals.get(i);
                animal.move(directions);
                out.println("Zwierze nr: "+ (i+1) + " pozycja: " + animal);
            }
            i++;
            if(i == animals.size()){
                i = 0;
            }
        }
        for(Animal animal: animals){ //Pokazuje końcowe pozycje zwierzaków
            out.println(animal);
        }
        List<String> wynik = new ArrayList<>();
        for(Animal animal: animals){ //Pokazuje końcowe pozycje zwierzaków
            wynik.add(animal.toString());
        }
        out.println(wynik);
        return wynik;

    }

}
