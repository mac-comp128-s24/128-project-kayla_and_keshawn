package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class ElephantDude extends GraphicsGroup{
    private Image elephant;
    private WalkType walkType;

    public ElephantDude(CanvasWindow canvas) {
        walkType = new WalkType(canvas, this);
        elephant =  new Image(0,canvas.getHeight() * 0.75, "elephant.jpg");
        elephant.setMaxHeight(canvas.getHeight() * 0.15);
        elephant.setMaxWidth(canvas.getHeight() * 0.15);
        this.add(elephant);
    }

    public void move() {
        walkType.walk();
    }
}
