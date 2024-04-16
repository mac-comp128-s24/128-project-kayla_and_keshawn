package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.*;

import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

public class Obstacle {
    private Map<GraphicsObject, Point> obstacles;
    private CanvasWindow canvas;
    
    public Obstacle(CanvasWindow canvas, boolean spikes, boolean walls, boolean predators){
        obstacles = new HashMap<>();
        this.canvas = canvas;
        if (spikes == true) {
            showSpike();
        }
        if (walls == true) {
            showWalls();
        }
    }
    public Map<GraphicsObject, Point> getObstacles(){
        return obstacles;
    }
    
    public void showSpike(){
        Path triangle = Path.makeTriangle(5, 10, 10, 50, 25, 0);
        obstacles.put(triangle, triangle.getPosition());
    }

    public void showWalls() {
        Rectangle wall = new Rectangle(canvas.getWidth() * 0.5, canvas.getHeight() * 0.5, canvas.getWidth() * 0.25, canvas.getHeight() * 0.4);
        wall.setFillColor(Color.BLACK);
        obstacles.put(wall, wall.getPosition());
    }
}