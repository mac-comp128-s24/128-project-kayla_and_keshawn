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

    public void setupUI(){
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

        Rectangle startBlock = new Rectangle(80, 525, 20, 20);
        startBlock.setFillColor(Color.BLUE);
        canvas.add(startBlock);
        GraphicsText startBlockText = new GraphicsText("Where you'll start!");
        startBlockText.setFillColor(new Color(173, 216, 230));
        startBlockText.setAlignment(TextAlignment.LEFT);
        startBlockText.setFont("rockwell condensed", FontStyle.BOLD, 20);
        canvas.add(startBlockText, 105, 540);

        IglooHome igloo = new IglooHome();
        canvas.add(igloo, 380, 525);
        GraphicsText endBlockText = new GraphicsText("Your end goal!");
        endBlockText.setFillColor(new Color(173, 216, 230));
        endBlockText.setAlignment(TextAlignment.LEFT);
        endBlockText.setFont("rockwell condensed", FontStyle.BOLD, 20);
        canvas.add(endBlockText, 430, 550);

        Rectangle wallBlock = new Rectangle(80, 555, 20, 20);
        wallBlock.setFillColor(Color.BLACK);
        canvas.add(wallBlock);
        GraphicsText wallBlockText = new GraphicsText("What to avoid! (you'll die)");
        wallBlockText.setFillColor(new Color(173, 216, 230));
        wallBlockText.setAlignment(TextAlignment.LEFT);
        wallBlockText.setFont("rockwell condensed", FontStyle.BOLD, 20);
        canvas.add(wallBlockText, 105, 570);
        
        Rectangle transportBlock = new Rectangle(80, 585, 20, 20);
        transportBlock.setFillColor(Color.RED);
        canvas.add(transportBlock);
        GraphicsText transportBlockText = new GraphicsText("Moves you 2 blocks to the left!");
        transportBlockText.setFillColor(new Color(173, 216, 230));
        transportBlockText.setAlignment(TextAlignment.LEFT);
        transportBlockText.setFont("rockwell condensed", FontStyle.BOLD, 20);
        canvas.add(transportBlockText, 105, 600);

        Rectangle movingBlock = new Rectangle(80, 615, 20, 20);
        movingBlock.setFillColor(Color.GRAY);
        canvas.add(movingBlock);
        GraphicsText movingBlockText = new GraphicsText("Can help you complete levels quicker!");
        movingBlockText.setFillColor(new Color(173, 216, 230));
        movingBlockText.setAlignment(TextAlignment.LEFT);
        movingBlockText.setFont("rockwell condensed", FontStyle.BOLD, 20);
        canvas.add(movingBlockText, 105, 630);

        Button startButton = new Button("START!");
        canvas.add(startButton, 350, 400);
        startButton.onClick(() -> {
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