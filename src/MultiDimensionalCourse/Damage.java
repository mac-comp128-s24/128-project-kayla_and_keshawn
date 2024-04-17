package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;

public class Damage {
    private PenguinDude penguin;

    public Damage(PenguinDude penguin) {
        this.penguin = penguin;
    }
    
    public boolean takesDamage(CanvasWindow canvas) {
        GraphicsObject objectHit = canvas.getElementAt(penguin.getPosition().getX() + penguin.getWidth(), penguin.getPosition().getY() + penguin.getHeight());
        if (objectHit != null) {
            System.out.println("been hit!!!");
            return true;
        }
        return false;
    }
}
