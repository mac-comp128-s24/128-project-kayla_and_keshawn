package PenguinMaze;


import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.events.Key;

public class PenguinDude extends GraphicsGroup{
    private Image penguin;

    public PenguinDude() {
        penguin =  new Image("penguinDude.png");
        penguin.setMaxHeight(25);
        penguin.setMaxWidth(25);
        this.add(penguin);
    }
}
