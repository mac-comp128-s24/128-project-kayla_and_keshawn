package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.Key;

public class WalkType {
    
    private int walkDimension = 2;
    private CanvasWindow canvas;
    private ElephantDude elephant;

    public WalkType(CanvasWindow canvas, ElephantDude elephant) {
        this.canvas = canvas;
        this.elephant = elephant;
    }

    public void twoDimensions() {
        canvas.onKeyDown((event) -> {
            if (event.getKey() == Key.RIGHT_ARROW) {
                elephant.moveBy(10, 0);
            }
            if (event.getKey() == Key.LEFT_ARROW) {
                elephant.moveBy(-10, 0);
            }
        });
    }

    public void threeDimensions() {
        canvas.onKeyDown((event) -> {
            if (event.getKey() == Key.RIGHT_ARROW) {
                elephant.moveBy(10, 0);
                System.out.println("Key pressed!");
            }
            if (event.getKey() == Key.LEFT_ARROW) {
                elephant.moveBy(-10, 0);
                System.out.println("Key pressed!");
            }
            if (event.getKey() == Key.UP_ARROW) {
                elephant.moveBy(0, -10);
            }
            if (event.getKey() == Key.DOWN_ARROW) {
                elephant.moveBy(0, 10);
            }
        });
    }

    public void walk() {
        if (walkDimension == 2) {
            twoDimensions();
            canvas.onKeyDown((event) -> {
                if (event.getKey() == Key.NUM_3) {
                    walkDimension = 3;
                }
            });
        }
        if (walkDimension == 3) {
            threeDimensions();
            canvas.onKeyDown((event) -> {
                if (event.getKey() == Key.NUM_2) {
                    walkDimension = 2;
                }
            });
        }
    }
}
