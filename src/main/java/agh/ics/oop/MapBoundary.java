package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    private final SortedSet<Vector2d> sortedByX = new TreeSet<>(Comparator.comparingInt(Vector2d -> Vector2d.x));
    private final SortedSet<Vector2d> sortedByY = new TreeSet<>(Comparator.comparingInt(Vector2d -> Vector2d.y));

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        sortedByX.remove(oldPosition);
        sortedByX.add(newPosition);

        sortedByY.remove(oldPosition);
        sortedByY.add(newPosition);
    }

    private void add(Vector2d position) {
        sortedByX.add(position);
        sortedByY.add(position);
    }

    public void remove(Vector2d position) {
        sortedByX.remove(position);
        sortedByY.remove(position);
    }

    public Vector2d lowerLeft(){
        return new Vector2d(sortedByX.first().x, sortedByY.first().y);
    }

    public Vector2d upperRight(){
        return new Vector2d(sortedByX.last().x, sortedByY.last().y);
    }
}
