package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Path;

import java.util.HashMap;
import java.util.Map;
import edu.macalester.graphics.Point;


public class Obstacle {
    private Map<GraphicsObject, Point> obstacles;
    
    public Obstacle(CanvasWindow canvas, boolean Spikes, boolean Walls, boolean Predators){
        obstacles = new HashMap<>();
        if (Spikes == true) {
            showSpike();
        }
    }
    public Map<GraphicsObject, Point> getObstacles(){
        return obstacles;
    }
    
    public void showSpike(){
        Path triangle = Path.makeTriangle(5, 10, 10, 50, 25, 0);
        obstacles.put(triangle, triangle.getPosition());
    }
}