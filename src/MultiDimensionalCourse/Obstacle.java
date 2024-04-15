package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Path;

import java.util.Map;
import edu.macalester.graphics.Point;


public class Obstacle {
    private Map<GraphicsGroup, Point> obstacles;
    private CanvasWindow canvas;
    public Obstacle(CanvasWindow canvas){
        this.canvas = canvas;
    }
    public Map<GraphicsGroup, Point> getObstacles(){
        return obstacles;
    }
    
    public  void showObstacle(){
        GraphicsGroup triangle = makeTriangle(5, 10, 10, 10, 7, 0);
        obstacles.put(triangle , triangle.getPosition());
        
    }
    public GraphicsGroup makeTriangle(double x0,double y0,double x1,double y1,double x2, double y2){
        
        return (makeTriangle(x0, y0, x1, y1, x2, y2));
    }
}