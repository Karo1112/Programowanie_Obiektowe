package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] gdzie_ma_isc) {
        MoveDirection[] kierunek = new MoveDirection[gdzie_ma_isc.length];
        int i = 0;
        for (String directions : gdzie_ma_isc) {
            switch (directions) {
                case "f", "forward" -> kierunek[i] = MoveDirection.FORWARD;
                case "b", "backward" -> kierunek[i] = MoveDirection.BACKWARD;
                case "l", "left" -> kierunek[i] = MoveDirection.LEFT;
                case "r", "right" -> kierunek[i] = MoveDirection.RIGHT;
                default -> throw new IllegalArgumentException(directions + " is not legal move specification");
            }
        i++;
    }
        return kierunek;
    }
}
