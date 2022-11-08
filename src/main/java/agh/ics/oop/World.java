package agh.ics.oop;


import java.util.*;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        Animal animal = new Animal(MapDirection.NORTH, new Vector2d(2,2));
        out.println(animal);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        out.println(animal);

        Scanner scanner = new Scanner(System.in);
        out.println("Gdzie zwierzak ma iść? ");
        String gdzie = scanner.nextLine();
        String[] gdzie_ma_isc = gdzie.split(" ");
        List<MoveDirection> gdzie_list = OptionsParser.parse(gdzie_ma_isc);
        for (MoveDirection moveDirection : gdzie_list) {
            animal.move(moveDirection);
        }
        out.println(animal);
    }
}
