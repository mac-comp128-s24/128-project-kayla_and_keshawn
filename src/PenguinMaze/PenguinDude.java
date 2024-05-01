package PenguinMaze;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

/**
 * This class takes multiple images as a GraphicsGroup so 
 * that we can use them throughout the game.
*/
public class PenguinDude extends GraphicsGroup{
    private Image penguin;

    public PenguinDude() {
        penguin = new Image("penguinDude.png");
        penguin.setMaxHeight(30);
        penguin.setMaxWidth(30);
        this.add(penguin);
    }

    public void setLossPenguin() {
        penguin.setImagePath("penguinLoss.jpg");
        penguin.setMaxWidth(600);
        penguin.setMaxHeight(650);
    }

    public void setWinPenguin() {
        penguin.setImagePath("endScreen-4.jpg");
        penguin.setMaxWidth(600);
        penguin.setMaxHeight(650);
    }
}
