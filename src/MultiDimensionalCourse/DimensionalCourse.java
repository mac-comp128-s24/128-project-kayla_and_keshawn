package MultiDimensionalCourse;

import java.util.Deque;
import java.util.ArrayDeque;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.events.Key;

public class DimensionalCourse {
    
    private CanvasWindow canvas;
    private PenguinDude penguin;
    private Maze maze;

    public DimensionalCourse() {
        canvas = new CanvasWindow("The Multi-Dimensional Penguin", 600, 300);
        penguin = new PenguinDude(canvas);
        maze = new Maze(canvas);
        canvas.add(penguin);
    }

    public void run() {
        penguin.move();

    }

    public static void main(String[] args) {
        DimensionalCourse dimensionalCourse = new DimensionalCourse();
        dimensionalCourse.run();
    }
}
