package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    static List<MoveDirection> parse(String[] gdzie_ma_isc) {
        List<MoveDirection> kierunek = new ArrayList<>();
        for (String directions : gdzie_ma_isc) {
            switch (directions) {
                case "f", "forward" -> kierunek.add(MoveDirection.FORWARD);
                case "b", "backward" -> kierunek.add(MoveDirection.BACKWARD);
                case "l", "left" -> kierunek.add(MoveDirection.LEFT);
                case "r", "right" -> kierunek.add(MoveDirection.RIGHT);
            }
        }
        return kierunek;
    }
}
