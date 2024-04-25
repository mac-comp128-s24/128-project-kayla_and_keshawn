package PenguinMaze;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Block extends Rectangle{

    private double currentAngle;

    public Block(double x, double y) {
        super(x, y, 60, 60);
        currentAngle = 0;
    }
    
    public void move(CanvasWindow canvas, Maze maze){
        double currentX = this.getPosition().getX();
        double currentY = this.getPosition().getY();
        double currentAngleInRadians = Math.toRadians(currentAngle);
        currentX += -2 * Math.cos(currentAngleInRadians);

        if (currentX <= 5) {
            currentAngle = 180 - currentAngle;
            this.setPosition(currentX, currentY);
        }
        else if (currentX + 60 >= canvas.getWidth() - 5) {
            currentAngle = 180 - currentAngle;
            this.setPosition(currentX, currentY);
        }
        else {
            this.setPosition(currentX, currentY);
        }

    }
}
