package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.Key;

public class WalkType {
    
    private int walkDimension;
    private CanvasWindow canvas;
    private PenguinDude penguin;
    private Damage damage;

    public WalkType(CanvasWindow canvas, PenguinDude penguin, int walkDimension) {
        this.canvas = canvas;
        this.penguin = penguin;
        this.walkDimension = walkDimension;
        damage = new Damage(penguin);
    }

    public void twoDimensions() {
        canvas.onKeyDown((event) -> {
            if (event.getKey() == Key.RIGHT_ARROW) {
                penguin.moveBy(5, 0);
            }
            if (event.getKey() == Key.LEFT_ARROW) {
                penguin.moveBy(-5, 0);
            }
            if (penguin.getPosition().getX() < 0) {
                penguin.setPosition(0, penguin.getPosition().getY());
            }
            if (penguin.getPosition().getX() + penguin.getWidth() > canvas.getWidth()) {
                penguin.setPosition(canvas.getWidth() - penguin.getWidth(), penguin.getPosition().getY());
            }
        });
    }

    public void threeDimensions() {
        canvas.onKeyDown((event) -> {
            if (event.getKey() == Key.RIGHT_ARROW) {
                penguin.moveBy(5, 0);
            }
            if (event.getKey() == Key.LEFT_ARROW) {
                penguin.moveBy(-5, 0);
            }
            if (event.getKey() == Key.UP_ARROW) {
                penguin.moveBy(0, -5);
            }
            if (event.getKey() == Key.DOWN_ARROW) {
                penguin.moveBy(0, 5);
            }
        });
    }

    public void walk() {
        if (walkDimension == 2) {
            twoDimensions();
        }
        else if (walkDimension == 3) {
            threeDimensions();
        }
    }

    public int getWalkDimension() {
        return walkDimension;
    }
}
