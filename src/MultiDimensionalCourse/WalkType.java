package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.Key;

public class WalkType {
    
    private int walkDimension;
    private CanvasWindow canvas;
    private ElephantDude elephant;

    public WalkType(CanvasWindow canvas, ElephantDude elephant) {
        this.canvas = canvas;
        this.elephant = elephant;
        walkDimension = 2;
    }

    public void twoDimensions() {
        canvas.onKeyDown((event) -> {
            if (event.getKey() == Key.RIGHT_ARROW) {
                elephant.moveBy(10, 0);
            }
            else if (event.getKey() == Key.LEFT_ARROW) {
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
            else if (event.getKey() == Key.LEFT_ARROW) {
                elephant.moveBy(-10, 0);
                System.out.println("Key pressed!");
            }
            else if (event.getKey() == Key.UP_ARROW) {
                elephant.moveBy(0, -10);
            }
            else if (event.getKey() == Key.DOWN_ARROW) {
                elephant.moveBy(0, 10);
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
        canvas.onKeyDown((event) -> {
            if (event.getKey() == Key.NUM_2) {
                walkDimension = 2;
                twoDimensions();
                System.out.println("Dimension should be 2: walkDimension " + walkDimension);
            }
            else if (event.getKey() == Key.NUM_3) {
                walkDimension = 3;
                threeDimensions();
                System.out.println("Dimension should be 3: walkDimension " + walkDimension);
            }
        });
    }

    public void setWalkDimension(int dimension) {
        walkDimension = dimension;
    }

    public int getWalkDimension() {
        return walkDimension;
    }
}
