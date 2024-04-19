package PenguinMaze;

import java.util.Deque;
import java.util.ArrayDeque;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.events.Key;

public class PenguinMaze {
    
    private CanvasWindow canvas;
    private Maze maze;
    PenguinDude penguin;

    public PenguinMaze() {
        canvas = new CanvasWindow("The Multi-Dimensional Penguin", 600, 300);
        maze = new Maze(canvas);
        penguin = maze.getPenguin();
    }

    public void run() {
        canvas.onKeyDown((event) -> {
            if (event.getKey() == Key.RIGHT_ARROW) {
                penguin.moveBy(5, 0);
            }
            if (event.getKey() == Key.LEFT_ARROW) {
                penguin.moveBy(-5, 0);
            }
            if (event.getKey() == Key.UP_ARROW) {
                penguin.moveBy(0, -5);
            }
            if (event.getKey() == Key.DOWN_ARROW) {
                penguin.moveBy(0, 5);
            }
            if (takesDamage()) {
                System.out.println("Been hit!!!");
                canvas.remove(penguin);
                PenguinDude revivedPenguin = new PenguinDude();
                maze.setPenguin(revivedPenguin);
                penguin = revivedPenguin;
            }
        });
    }

    public boolean takesDamage() {
        return maze.penguinIsInHere();
    }

    public static void main(String[] args) {
        PenguinMaze dimensionalCourse = new PenguinMaze();
        dimensionalCourse.run();
    }
}
