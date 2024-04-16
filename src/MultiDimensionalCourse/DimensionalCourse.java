package MultiDimensionalCourse;

import java.util.Deque;
import java.util.ArrayDeque;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.events.Key;

public class DimensionalCourse {
    
    private CanvasWindow canvas;
    private PenguinDude penguin;
    private Deque<WalkType> walkStack;
    private Obstacle obstacles;

    public DimensionalCourse() {
        canvas = new CanvasWindow("The Multi-Dimensional Penguin", 1200, 600);
        penguin = new PenguinDude(canvas);
        obstacles = new Obstacle(canvas, true, true, false);
        for (GraphicsObject object : obstacles.getObstacles().keySet()) {
            canvas.add(object);
        }
        canvas.add(penguin);
        walkStack = new ArrayDeque<WalkType>();
        WalkType walkType = new WalkType(canvas, penguin, 2);
        walkStack.push(walkType);

    }

    public void run() {
        penguin.move(walkStack.peek());
        canvas.onKeyDown((event) -> {
            if (event.getKey() == Key.SPACE) {
                if (walkStack.peek().getWalkDimension() == 2) {
                    WalkType walkType = new WalkType(canvas, penguin, 3);
                    walkStack.push(walkType);
                }
                else {
                    WalkType walkType = new WalkType(canvas, penguin, 2);
                    walkStack.push(walkType);
                }
            }
        });
    }

    public static void main(String[] args) {
        DimensionalCourse dimensionalCourse = new DimensionalCourse();
        dimensionalCourse.run();
    }
}
