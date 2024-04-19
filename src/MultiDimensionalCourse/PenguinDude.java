package MultiDimensionalCourse;


import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.events.Key;

public class PenguinDude extends GraphicsGroup{
    private Image penguin;
    private CanvasWindow canvas;

    public PenguinDude(CanvasWindow canvas) {
        this.canvas = canvas;
        penguin =  new Image("penguinDude.png");
        penguin.setMaxHeight(canvas.getHeight() * 0.15);
        penguin.setMaxWidth(canvas.getHeight() * 0.15);
        this.add(penguin);
    }
}
