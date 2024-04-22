package PenguinMaze;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class PenguinDude extends GraphicsGroup{
    private Image penguin;

    public PenguinDude() {
        penguin =  new Image("penguinDude.png");
        penguin.setMaxHeight(30);
        penguin.setMaxWidth(30);
        this.add(penguin);
    }
}
