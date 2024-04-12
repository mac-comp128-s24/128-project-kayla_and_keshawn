package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class ElephantDude extends GraphicsGroup{
    private Image elephant;

    public ElephantDude(CanvasWindow canvas) {
        elephant =  new Image(0,canvas.getHeight() * 0.75, "elephant-303652_1280.webp");
        elephant.setMaxHeight(canvas.getHeight() * 0.15);
        elephant.setMaxWidth(canvas.getHeight() * 0.15);
        this.add(elephant);
    }


}
