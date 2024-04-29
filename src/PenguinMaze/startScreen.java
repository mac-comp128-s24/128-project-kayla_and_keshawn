package PenguinMaze;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.ui.Button;

public class StartScreen {
    private CanvasWindow canvas;

    public StartScreen(){
        canvas = new CanvasWindow("Penguin Path", 600, 660);
    }

    private void setupUI(){
        GraphicsGroup uiGroup = new GraphicsGroup();
        Image startPage = new Image("StartPage.png");
        startPage.setMaxWidth(600);
        startPage.setMaxHeight(650);
        uiGroup.add(startPage);
        canvas.add(uiGroup);

        Button loadButton = new Button("START!");
        canvas.add(loadButton, 350, 400);
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