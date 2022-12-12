package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import static java.lang.String.format;


public class App extends javafx.application.Application{

    @Override
    public void start(Stage primaryStage) throws IllegalArgumentException {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = OptionsParser.parse(args);
        AbstractWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(30, 30, 30, 30));
        drawMap(map, grid);
        drawAnimalsAndGrass(map, grid);

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void drawMap(AbstractWorldMap map, GridPane grid){
        Label labels = new Label("y\\x");
        grid.add(labels, 0, 0);
        grid.getColumnConstraints().add(new ColumnConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(30));
        GridPane.setHalignment(labels, HPos.CENTER);
        for (int i = map.map_size()[0].x; i <= map.map_size()[1].x; i++) {
            labels = new Label(format("%d", i));
            grid.add(labels, i - map.map_size()[0].x + 1, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(30));
            GridPane.setHalignment(labels, HPos.CENTER);

        }
        for (int j = map.map_size()[0].y; j <= map.map_size()[1].y; j++) {
            labels = new Label(format("%d", j));
            grid.add(labels, 0, map.map_size()[1].y - j + 1);
            grid.getRowConstraints().add(new RowConstraints(30));
            GridPane.setHalignment(labels, HPos.CENTER);
        }
    }
    void drawAnimalsAndGrass(AbstractWorldMap map, GridPane grid){
        for (int i = map.map_size()[0].x; i <= map.map_size()[1].x; i++) {
            for (int j = map.map_size()[0].y; j <= map.map_size()[1].y; j++) {
                Object toAdd = map.objectAt(new Vector2d(i, j));
                if (toAdd == null) {
                    continue;
                }
                Label labels = new Label(toAdd.toString());
                grid.add(labels, i - map.map_size()[0].x + 1, map.map_size()[1].y - j + 1);
                GridPane.setHalignment(labels, HPos.CENTER);
            }
        }

    }
}