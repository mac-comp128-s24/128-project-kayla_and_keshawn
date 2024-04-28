package PenguinMaze;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class StartScreen {
    private CanvasWindow canvas;

    public StartScreen(){
        canvas = new CanvasWindow("Penguin Path", 600, 600);
        
    }

    private void setupUI(){
        GraphicsGroup uiGroup = new GraphicsGroup();
        Image startPage = new Image("StartPage.png");
        startPage.setMaxWidth(600);
        startPage.setMaxHeight(600);
        uiGroup.add(startPage);
        canvas.add(uiGroup);

        TextField filenameField = new TextField();
        filenameField.setText("maze-2");

        Button loadButton = new Button("Load Maze");
        canvas.add(loadButton, 250, 350);
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