package PenguinMaze;

import java.awt.Color;
import java.io.InputStream;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;

import java.util.Scanner;


public class Maze {
    private final int BLOCK_SIDELENGTH = 60;
    private Block[][] blocks;
    private PenguinDude penguin;
    private IglooHome igloo;
    private CanvasWindow canvas;
    private double pengRow;
    private double pengCol;
    private double igRow;
    private double igCol;
    private Block endBlock;
    private Block startBlock;
    private Color walkingGroundColor = new Color(173, 216, 230);
    public boolean isPaused;
    public boolean isCompleted;
    
    public Maze(CanvasWindow canvas, String mazeFile){
        isCompleted = false;
        isPaused = false;
        this.canvas = canvas;
        penguin = new PenguinDude();
        igloo = new IglooHome();
        loadMaze(mazeFile);
        pengCol = Math.floor(startBlock.getPosition().getX() / BLOCK_SIDELENGTH);
        pengRow = Math.floor(startBlock.getPosition().getY() / BLOCK_SIDELENGTH); // Calculates y-coordinate of penguin when game gets configured
        igCol = Math.floor(endBlock.getPosition().getX() / BLOCK_SIDELENGTH);
        igRow = Math.floor(endBlock.getPosition().getY() / BLOCK_SIDELENGTH); // Calculates y-coordinate of igloo when game gets configured
        canvas.add(penguin, (pengCol * BLOCK_SIDELENGTH) + 15, (pengRow * BLOCK_SIDELENGTH) + 15);
        canvas.add(igloo, (igCol * BLOCK_SIDELENGTH) + 15, (igRow * BLOCK_SIDELENGTH) + 15);
    }

    /**
     * Configures the maze from the mazeText.
     * Iterates through each block to determine whether the penguin can walk on it.
     * @param mazeText
     * @throws RuntimeException
     */
    public void loadMaze(String mazeText) throws RuntimeException {
        InputStream resourceStream = Maze.class.getResourceAsStream("/" + mazeText);
        if (resourceStream == null) {
            throw new RuntimeException("Can't find maze!");
        }
        Scanner scanner = new Scanner(resourceStream);
        int row = scanner.nextInt();
        int column = scanner.nextInt();

        blocks = new Block[row][column];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                int next = scanner.nextInt();
                Block newBlock = new Block(c, r);
                blocks[r][c] = newBlock;
                if (next == 2) { // Indicates the start block
                    startBlock = newBlock;
                    newBlock.setFillColor(Color.BLUE);
                }
                else if (next == 3) { // Indicates the end block
                    endBlock = newBlock;
                    endBlock.setFillColor(walkingGroundColor);
                }
                else if (next == 4) { // Indicates the block that transports penguin exactly 115 units to the left
                    newBlock.setFillColor(Color.RED);
                }
                else if (next == 1) { // Indicates wall
                    newBlock.setFillColor(Color.BLACK);
                }
                else if (next == 0) { // Indicates walking space
                    newBlock.setFillColor(walkingGroundColor);
                }
                else if(next == 5){ // Indicates block(s) that alternate between being a wall and a walking space
                    newBlock.setFillColor(walkingGroundColor);
                    changingColorBlock(newBlock);
                }
                newBlock.setStrokeColor(newBlock.getFillColor());
                canvas.add(newBlock, c * BLOCK_SIDELENGTH, r * BLOCK_SIDELENGTH);
            }
        }
        if (scanner.nextInt() == 6) { // says whether or not a moving block would be added to maze level
            Block moveBlock = new Block(BLOCK_SIDELENGTH, BLOCK_SIDELENGTH);
            moveBlock.setFillColor(Color.GRAY);
            moveTheBlock(moveBlock);
            canvas.add(moveBlock, 180, 120);
        }
        scanner.close();
    }

    /**
     * 
     * @return penguin initiated by the maze
     */
    public PenguinDude getPenguin() {
        return penguin;
    }

    /**
     * Setter method for a penguin to update the maze on what penguin is being used.
     * @param penguin
     */
    public void setPenguin(PenguinDude penguin) {
        this.penguin = penguin;
        canvas.add(penguin, (pengCol * BLOCK_SIDELENGTH) + 15, (pengRow * BLOCK_SIDELENGTH) + 15);
    }

    /**
     * Iterates through each block to see which block the penguin is on.
     * @param obj
     * @return true if penguin hits block that acts as wall and false otherwise
     */
    public boolean hitsWall(GraphicsObject obj) {
        Point objPos = obj.getPosition();
        double objXLeft = objPos.getX();
        double objYTop = objPos.getY();
        double objXRight = objPos.getX() + obj.getWidth();
        double objYBottom = objPos.getY() + obj.getHeight();
        GraphicsObject blockAbove = canvas.getElementAt(objXLeft - 1, objYTop - 1);
        GraphicsObject blockBelow = canvas.getElementAt(objXRight + 1, objYBottom + 1);
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blockAbove == null || blockBelow == null) {
                    return true;
                }
                else if (blockAbove.equals(blocks[i][j]) || blockBelow.equals(blocks[i][j])) {
                    if (blocks[i][j].getFillColor() == Color.BLACK) {
                        return true;
                    }
                    else if (blockAbove.equals(getEnd()) || blockBelow.equals(getEnd())) {
                        isCompleted = true;
                        return false;
                    }
                    else if (blocks[i][j].getFillColor() == Color.RED) {
                        penguin.setPosition(objPos.getX() - (BLOCK_SIDELENGTH * 4) + 5, objPos.getY()); // red blocks help you transport across walls if there's no way out otherwise
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public Block getStart() {
        return startBlock;
    }

    public Block getEnd() {
        return endBlock;
    }
    
    /**
     * Deals with the timing of when the alternating block changes color
     */
    double time = 0;
    public void changingColorBlock(Block block){
        canvas.animate(dt -> {
            if (!isPaused) {
                time += dt;
                if ((int) time % 7 == 0) {
                    block.setFillColor(Color.BLACK);
                }
                else {
                    block.setFillColor(walkingGroundColor);
                }
            }
        });
    }

    /**
     * Initiates the movement of the block. Mainly used for moving blocks.
     * @param block
     */
    public void moveTheBlock(Block block) {
        canvas.animate((dt) -> {
            if (!isPaused) {
                block.move(canvas, this);
            }
        });
    }
}