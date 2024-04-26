package PenguinMaze;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.Key;

public class startScreen {
    private CanvasWindow canvas;
    private Maze maze;
    private PenguinDude penguin;

    private int lives;
    public startScreen(){
        canvas = new CanvasWindow("Penguin Maze", 600, 300);
    }
}
