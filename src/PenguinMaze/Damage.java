package PenguinMaze;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;

/**
* This class checks to see if the penguin has been hit by one of the blocks.
*/

public class Damage {
    private PenguinDude penguin;

    public Damage(PenguinDude penguin) {
        this.penguin = penguin;
    }
    /**
     * This method makes a new GraphicsObject to check if the penguin has been 
     * hit or not by checking where the penguin's position is at. If it is not in
     * an empty block, it has been hit.  
     */
    public boolean takesDamage(CanvasWindow canvas) {
        GraphicsObject objectHit = canvas.getElementAt(penguin.getPosition().getX(), penguin.getPosition().getY());
        if (objectHit != null) {
            System.out.println("been hit!!!");
            return true;
        }
        return false;
    }
}
