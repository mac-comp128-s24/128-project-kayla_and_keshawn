package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;

public class Damage {
    private Obstacle obstacles;
    private CanvasWindow canvas;
    private PenguinDude penguin;
    public Damage(){
        obstacles = new Obstacle(canvas, true, false, false);
    }
    public boolean takesDamage(PenguinDude penguin){
        if(penguin.testHit(10, 0)){
            penguin.removeAll();
        }
        return false;
    }
}
