package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    Animal animal = new Animal(MapDirection.NORTH, new Vector2d(2,2));
    @Test
    public void orientacja_pozycja() {
        String[] kierunek = new String[]{"right", "forward", "forward"};
        List<MoveDirection> gdzie_list = OptionsParser.parse(kierunek);
        for (MoveDirection moveDirection : gdzie_list) {
            animal.move(moveDirection);
        }
        assertEquals("Pozycja: (4,2) Orientacja: Wschód", animal.toString());
    }

    @Test
    public void wychodzenie_za_mape() {
        String[] kierunek = new String[]{"right", "forward", "forward", "forward", "forward", "forward"};
        List<MoveDirection> gdzie_list = OptionsParser.parse(kierunek);
        for (MoveDirection moveDirection : gdzie_list) {
            animal.move(moveDirection);
        }
        assertEquals("Pozycja: (4,2) Orientacja: Wschód", animal.toString());
    }

    @Test
    public void znaki() {
        String[] kierunek = new String[]{ "a", "d",  "c", "22"};
        List<MoveDirection> gdzie_list = OptionsParser.parse(kierunek);
        for (MoveDirection moveDirection : gdzie_list) {
            animal.move(moveDirection);
        }
        assertEquals("Pozycja: (2,2) Orientacja: Północ", animal.toString());
    }
}
