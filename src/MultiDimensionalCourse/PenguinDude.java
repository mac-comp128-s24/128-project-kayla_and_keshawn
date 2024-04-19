package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.events.Key;

public class PenguinDude extends GraphicsGroup{
    private Image penguin;
    private CanvasWindow canvas;
    private Damage damage;

    public PenguinDude(CanvasWindow canvas) {
        this.canvas = canvas;
        damage = new Damage(this);
        penguin =  new Image(0, canvas.getHeight() * 0.8, "penguinDude.png");
        penguin.setMaxHeight(canvas.getHeight() * 0.15);
        penguin.setMaxWidth(canvas.getHeight() * 0.15);
        this.add(penguin);
    }

    public void move() {
        canvas.onKeyDown((event) -> {
            if (event.getKey() == Key.RIGHT_ARROW) {
                this.moveBy(5, 0);
            }
            else if (event.getKey() == Key.LEFT_ARROW) {
                this.moveBy(-5, 0);
            }
            else if (event.getKey() == Key.UP_ARROW) {
                this.moveBy(0, -5);
            }
            else if (event.getKey() == Key.DOWN_ARROW) {
                this.moveBy(0, 5);
            }
            if (takesDamage(canvas)) {
                canvas.remove(this);
            }
        });
    }
    
    public boolean takesDamage(CanvasWindow canvas) {
        GraphicsObject objectHit = canvas.getElementAt(this.getPosition());
        if (objectHit != null) {
            System.out.println("been hit!!!");
            return true;
        }
        return false;
    }
}
