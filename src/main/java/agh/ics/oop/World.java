package agh.ics.oop;


import java.util.List;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {

        List<MoveDirection> directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        RectangularMap mapa = new RectangularMap(10, 5);
        out.println(mapa.toString(map));
    }
}