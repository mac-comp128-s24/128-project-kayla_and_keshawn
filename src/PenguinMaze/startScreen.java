package PenguinMaze;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class StartScreen {
    private CanvasWindow canvas;
    private GraphicsText mazeDisplay;

    public StartScreen(){
        canvas = new CanvasWindow("Penguin Maze", 600, 600);
        
    }

    private void setupUI(){
        mazeDisplay = new GraphicsText("PENGUIN MAZE");
        mazeDisplay.setFont("monospaced, Courier New", FontStyle.PLAIN, 50);
        canvas.add(mazeDisplay, 300, 300);

        // GraphicsGroup uiGroup = new GraphicsGroup();

        TextField filenameField = new TextField();
        filenameField.setText("maze-2");

        Button loadButton = new Button("Load Maze");
        canvas.add(loadButton);
        loadButton.onClick(() -> {
            canvas.removeAll();
            PenguinMaze penguinMaze = new PenguinMaze(canvas);
            penguinMaze.run();
        });
    }

    public static void main(String[] args) {
        StartScreen startScreen = new StartScreen();
        startScreen.setupUI();
    }
}