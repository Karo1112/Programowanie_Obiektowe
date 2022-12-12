package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsParserTest {

    @Test
    void wrongDirectionsTest(){
        String[] test = new String[] {"l","l","left","a","g","f","backward","b"};
        Assertions.assertThrows(IllegalArgumentException.class, ()->OptionsParser.parse(test));

    }

    @Test
    void goodDirectionsTest() {
        String[] test = new String[] {"left", "f", "right", "backward", "forward"};
        MoveDirection[] direction = new MoveDirection[] {MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.FORWARD};
        Assertions.assertAll(() -> Assertions.assertArrayEquals(direction, OptionsParser.parse(test)));
    }
}
