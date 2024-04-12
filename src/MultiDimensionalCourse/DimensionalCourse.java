package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.Key;

public class DimensionalCourse {
    
    private CanvasWindow canvas;
    private ElephantDude elephant;
    private WalkType walkType;

    public DimensionalCourse() {
        canvas = new CanvasWindow("Multi-Dimensional Course", 600, 400);
        elephant = new ElephantDude(canvas);
        canvas.add(elephant);
        walkType = new WalkType(canvas, elephant);
    }

    public void run() {
        elephant.move();
    }

    public static void main(String[] args) {
        DimensionalCourse dimensionalCourse = new DimensionalCourse();
        dimensionalCourse.run();
    }
}
