package PenguinMaze;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Block extends Rectangle{

    public Block(double x, double y) {
        super(x, y, 60, 60);
    }
    
    public void move(CanvasWindow canvas){
        //double xBlock = this.getPosition().getX();
        //for(Object xBlock: Block){
            if (this.getPosition().getX() < 5) {
                this.moveBy(10, 0);
            }
            else {
                this.moveBy(-10, 0);
            }
        }
        // if (this.getPosition().getX() < 5) {
        //     this.moveBy(10, 0);
        // }
        // else {
        //     this.moveBy(-10, 0);
        // }
        this.moveBy(10, 0);
    }
}
