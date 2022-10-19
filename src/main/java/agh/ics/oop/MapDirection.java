package agh.ics.oop;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;
    public String toString(){
        String map;
        map = switch(this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case EAST -> "Wschód";
            case WEST -> "Zachód";
        };
        return map;
    }
     MapDirection next(){
        MapDirection next = null;
        switch (this) {
            case NORTH -> next = MapDirection.EAST;
            case EAST -> next = MapDirection.SOUTH;
            case SOUTH -> next = MapDirection.WEST;
            case WEST -> next = MapDirection.NORTH;
        }
        return next;
    }
    MapDirection previous(){
        MapDirection previous = null;
        switch (this){
            case NORTH -> previous = MapDirection.WEST;
            case EAST -> previous = MapDirection.NORTH;
            case SOUTH -> previous = MapDirection.EAST;
            case WEST -> previous = MapDirection.SOUTH;
        }
        return previous;
        }

    Vector2d toUnitVector(){
         switch(this){
             case NORTH -> {
                 return new Vector2d(0,1);
             }
             case SOUTH -> {
                 return new Vector2d(0,-1);
             }
             case EAST -> {
                 return new Vector2d(1,0);
             }
             case WEST -> {
                 return new Vector2d(-1,0);
             }
         }
         return null;
    }
}

