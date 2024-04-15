package MultiDimensionalCourse;

import java.util.Deque;
import java.util.ArrayDeque;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.events.Key;
import java.util.Map;

public class DimensionalCourse {
    
    private CanvasWindow canvas;
    private ElephantDude elephant;
    private Deque<WalkType> walkStack;
    private Obstacle obstacles;


    public DimensionalCourse() {
        canvas = new CanvasWindow("Multi-Dimensional Course", 600, 400);
        elephant = new ElephantDude(canvas);
        obstacles = new Obstacle(canvas);
        for(GraphicsObject object : obstacles.getObstacles().keySet()){
            canvas.add(object);
        }
        canvas.add(elephant);
        walkStack = new ArrayDeque<WalkType>();
        WalkType walkType = new WalkType(canvas, elephant, 2);
        walkStack.push(walkType);

    }

    public void run() {
        elephant.move(walkStack.peek());
        canvas.onKeyDown((event) -> {
            if (event.getKey() == Key.SPACE) {
                if (walkStack.peek().getWalkDimension() == 2) {
                    WalkType walkType = new WalkType(canvas, elephant, 3);
                    walkStack.push(walkType);
                }
                else {
                    WalkType walkType = new WalkType(canvas, elephant, 2);
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
