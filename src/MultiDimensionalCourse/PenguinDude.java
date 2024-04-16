package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class PenguinDude extends GraphicsGroup{
    private Image penguin;
    private CanvasWindow canvas;

    public PenguinDude(CanvasWindow canvas) {
        this.canvas = canvas;
        penguin =  new Image(0, canvas.getHeight() * 0.75, "otherpenguin.jpg");
        penguin.setMaxHeight(canvas.getHeight() * 0.15);
        penguin.setMaxWidth(canvas.getHeight() * 0.15);
        this.add(penguin);
    }

    public void move(WalkType walkType) {
        walkType.walk();
    }
}
