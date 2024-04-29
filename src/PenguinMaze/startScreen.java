package PenguinMaze;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.TextAlignment;
import edu.macalester.graphics.ui.Button;

public class StartScreen {
    private CanvasWindow canvas;
    private final Color CANVAS_COLOR = new Color(255, 255, 230);
    private GraphicsText instructions;

    public StartScreen(){
        canvas = new CanvasWindow("Penguin Path", 600, 660);
        canvas.setBackground(CANVAS_COLOR);
        instructions = new GraphicsText();
    }

    private void setupUI(){
        GraphicsGroup uiGroup = new GraphicsGroup();
        Image startPage = new Image("StartPage.png");
        startPage.setMaxWidth(600);
        startPage.setMaxHeight(650);
        uiGroup.add(startPage);
        canvas.add(uiGroup);

        instructions.setText("Help this penguin get through the mazes! \nHere are some blocks you'll need to know:");
        instructions.setFillColor(new Color(173, 216, 230));
        instructions.setAlignment(TextAlignment.CENTER);
        instructions.setFont("rockwell condensed", FontStyle.BOLD, 20);
        canvas.add(instructions, 300, 480);

        Rectangle startBlock = new Rectangle(125, 525, 20, 20);
        startBlock.setFillColor(Color.BLUE);
        canvas.add(startBlock);

        IglooHome igloo = new IglooHome();
        canvas.add(igloo, 250, 525);

        Rectangle wallBlock = new Rectangle(125, 555, 20, 20);
        wallBlock.setFillColor(Color.BLACK);
        canvas.add(wallBlock);
        
        Rectangle transportBlock = new Rectangle(125, 585, 20, 20);
        transportBlock.setFillColor(Color.RED);
        canvas.add(transportBlock);

        Rectangle movingBlock = new Rectangle(125, 615, 20, 20);
        movingBlock.setFillColor(Color.GRAY);
        canvas.add(movingBlock);

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