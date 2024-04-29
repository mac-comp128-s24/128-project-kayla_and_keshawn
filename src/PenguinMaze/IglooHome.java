package PenguinMaze;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class IglooHome extends GraphicsGroup{

    private Image igloo;
    
    public IglooHome() {
        igloo = new Image("penguinHome.png");
        igloo.setMaxHeight(30);
        igloo.setMaxWidth(30);
        this.add(igloo);
    }
}
