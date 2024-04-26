package PenguinMaze;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class startScreen {
    private CanvasWindow canvas;
    private Maze maze;
    private PenguinDude penguin;

    private int lives;
    public startScreen(){
        canvas = new CanvasWindow("Penguin Maze", 600, 300);
        
    }
    private void setupUI(){
        // mazeDisplay = new GraphicsText();
        // mazeDisplay.setFont("monospaced, Courier New", FontStyle.PLAIN, 14);
        // canvas.add(mazeDisplay, 50, 50);

        GraphicsGroup uiGroup = new GraphicsGroup();

        TextField filenameField = new TextField();
        filenameField.setText("maze-2");

        Button loadButton = new Button("Load Maze");
        loadButton.onClick( () -> maze.loadMaze("MazePattern1.txt") );
    }
}