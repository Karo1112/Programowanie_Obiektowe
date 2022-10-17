package agh.ics.oop;
import java.util.Scanner;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("System wystartował.");
        Scanner scanner = new Scanner(System.in);
        out.println("Gdzie zwierzak ma iść? ");
        String gdzie = scanner.nextLine();
        String[] gdzie_ma_isc = gdzie.split(" ");
        out.println("Start");
        for (String kierunek : gdzie_ma_isc) {
            Direction direction = null;
            switch (kierunek) {
                case "f" -> direction = Direction.FORWARD;
                case "b" -> direction = Direction.BACKWARD;
                case "l" -> direction = Direction.LEFT;
                case "r" -> direction = Direction.RIGHT;
            }
            if (direction!=null){
                run(direction);
            }
        }
        out.println("Stop");
        out.println("System zakończył działanie.");
    }

    public static void run(Direction kierunki) {

        String directions = switch (kierunki) {
            case FORWARD -> "Zwierzak idzie do przodu.";
            case BACKWARD -> "Zwierzak idzie do tyłu.";
            case LEFT -> "Zwierzak idzie w lewo.";
            case RIGHT -> "Zwierzak idzie w prawo.";
        };
        out.println(directions);
    }
}


// ---------- Zadanie 14 i 15 --------------
   /* public static void run() {
       Scanner scanner = new Scanner(System.in);
       out.println("Gdzie zwierzak ma iść? ");
       String gdzie = scanner.nextLine();
       String[] gdzie_ma_isc = gdzie.split(" ");
       out.println("Start");
       for (String kierunki : gdzie_ma_isc) {
           switch (kierunki) {
               case "f" -> out.println("Zwierzak idzie do przodu.");
               case "b" -> out.println("Zwierzak idzie do tyłu.");
               case "r" -> out.println("Zwierzak skręca w prawo.");
               case "l" -> out.println("Zwierzak skręca w lewo.");
           }
       }
       out.println("Stop");
   }*/

// ------ Zadanie 10,11,12 --------
   /* public static void run(String[] kierunek){
        out.println("Zwierzak idzie do przodu");
        int i = 0;
        while (i < kierunek.length) {
            if (i + 1 != kierunek.length) {
                out.print(kierunek[i] + ", ");
            } else {
                out.print(kierunek[i]);
            }
            i++;
        }
    }*/

