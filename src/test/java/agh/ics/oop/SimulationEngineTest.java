package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationEngineTest {

    List<Animal> animals = new ArrayList<>();
    IWorldMap map = new RectangularMap(10, 5);



    @Test
    public void animal_position1() {
        List<MoveDirection> directions = new OptionsParser().parse(new String[]{"l", "f"});
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        for (Vector2d position : positions) {
            Animal newAnimal = new Animal(map, position);
            if (map.place(newAnimal)) {
                animals.add(newAnimal);
            }
        }

        List<String> wynik = List.of(new String[]{"(2, 2) Orientacja: W", "(3, 5) Orientacja: N"});
        assertEquals(wynik, engine.run() );
        }

    @Test
    public void animal_position2() { //sprawdzenie tego z zadania
        List<MoveDirection> directions = new OptionsParser().parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        for (Vector2d position : positions) {
            Animal newAnimal = new Animal(map, position);
            if (map.place(newAnimal)) {
                animals.add(newAnimal);
            }
        }

        List<String> wynik = List.of(new String[]{"(2, 0) Orientacja: S", "(3, 5) Orientacja: N"});
        assertEquals(wynik, engine.run() );
    }

    @Test
    public void animal_position3() { //test, że nie da się dwóch zwierząt na początku na tym samym miejscu stworzyć
        List<MoveDirection> directions = new OptionsParser().parse(new String[]{"l", "r"});
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2,2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        for (Vector2d position : positions) {
            Animal newAnimal = new Animal(map, position);
            if (map.place(newAnimal)) {
                animals.add(newAnimal);
            }
        }

        List<String> wynik = List.of(new String[]{"(2, 2) Orientacja: N"});
        assertEquals(wynik, engine.run() );
    }


    @Test
    public void animal_position4() { //test, że nie mogą stać na tych samych polach
        List<MoveDirection> directions = new OptionsParser().parse(new String[]{"f"});
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2,3)}; //jak pierwszy idzie naprzód to trafia na pole (2,3) czyli w wyniku musi zostać na swoim polu (2,2)
        IEngine engine = new SimulationEngine(directions, map, positions);
        for (Vector2d position : positions) {
            Animal newAnimal = new Animal(map, position);
            if (map.place(newAnimal)) {
                animals.add(newAnimal);
            }
        }

        List<String> wynik = List.of(new String[]{"(2, 2) Orientacja: N", "(2, 3) Orientacja: N"});
        assertEquals(wynik, engine.run() );
    }
}





