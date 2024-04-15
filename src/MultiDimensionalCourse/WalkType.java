package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.Key;

public class WalkType {
    
    private int walkDimension;
    private CanvasWindow canvas;
    private PenguinDude elephant;

    public WalkType(CanvasWindow canvas, PenguinDude elephant, int walkDimension) {
        this.canvas = canvas;
        this.elephant = elephant;
        this.walkDimension = walkDimension;
    }

    public void twoDimensions() {
        canvas.onKeyDown((event) -> {
            if (event.getKey() == Key.RIGHT_ARROW) {
                elephant.moveBy(5, 0);
            }
            if (event.getKey() == Key.LEFT_ARROW) {
                elephant.moveBy(-5, 0);
            }
            if (elephant.getPosition().getX() < 0) {
                elephant.setPosition(0, elephant.getPosition().getY());
            }
            if (elephant.getPosition().getX() + elephant.getWidth() > canvas.getWidth()) {
                elephant.setPosition(canvas.getWidth() - elephant.getWidth(), elephant.getPosition().getY());
            }
        });
    }

    public void threeDimensions() {
        canvas.onKeyDown((event) -> {
            if (event.getKey() == Key.RIGHT_ARROW) {
                elephant.moveBy(5, 0);
            }
            if (event.getKey() == Key.LEFT_ARROW) {
                elephant.moveBy(-5, 0);
            }
            if (event.getKey() == Key.UP_ARROW) {
                elephant.moveBy(0, -5);
            }
            if (event.getKey() == Key.DOWN_ARROW) {
                elephant.moveBy(0, 5);
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
