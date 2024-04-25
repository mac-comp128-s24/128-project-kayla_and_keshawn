package PenguinMaze;

import java.awt.Color;
import java.io.InputStream;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Point;

import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;


public class Maze {
    private final int BLOCK_SIDELENGTH = 60;
    private Block[][] blocks;
    private PenguinDude penguin;
    private CanvasWindow canvas;
    private double pengRow;
    private double pengCol;
    private Block endBlock;
    private Block startBlock;
    private Color walkingGroundColor = new Color(173, 216, 230);
    public boolean isCompleted;
    
    public Maze(CanvasWindow canvas, String mazeFile){
        isCompleted = false;
        this.canvas = canvas;
        penguin = new PenguinDude();
        loadMaze(mazeFile);
        pengCol = Math.floor(startBlock.getPosition().getX() / BLOCK_SIDELENGTH);
        pengRow = Math.floor(startBlock.getPosition().getY() / BLOCK_SIDELENGTH); // Calculates y-coordinate of penguin when game gets configured
        canvas.add(penguin, (pengCol * BLOCK_SIDELENGTH) + 15, (pengRow * BLOCK_SIDELENGTH) + 15);
    }

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
                if (next == 2) {
                    startBlock = newBlock;
                    newBlock.setFillColor(Color.BLUE);
                }
                else if (next == 3) {
                    endBlock = newBlock;
                    newBlock.setFillColor(Color.GREEN);
                }
                else if (next == 4) {
                    newBlock.setFillColor(Color.RED);
                }
                else if (next == 1) {
                    newBlock.setFillColor(Color.BLACK);
                }
                else if (next == 0) {
                    newBlock.setFillColor(walkingGroundColor);
                }
                else if(next == 5){
                    newBlock.setFillColor(Color.PINK);
                    movingBlock(newBlock);
                }
                newBlock.setStrokeColor(newBlock.getFillColor());
                canvas.add(newBlock, c * BLOCK_SIDELENGTH, r * BLOCK_SIDELENGTH);
            }
        }
        scanner.close();
    }

    public PenguinDude getPenguin() {
        return penguin;
    }

    public void setPenguin(PenguinDude penguin) {
        this.penguin = penguin;
        canvas.add(penguin, (pengCol * BLOCK_SIDELENGTH) + 15, (pengRow * BLOCK_SIDELENGTH) + 15);
    }

    public boolean penguinHitWall() {
        Point penguinPos = penguin.getPosition();
        double penguinXLeft = penguinPos.getX();
        double penguinYTop = penguinPos.getY();
        double penguinXRight = penguinPos.getX() + 30;
        double penguinYBottom = penguinPos.getY() + 30;
        GraphicsObject blockAbove = canvas.getElementAt(penguinXLeft - 1, penguinYTop - 1);
        GraphicsObject blockBelow = canvas.getElementAt(penguinXRight + 1, penguinYBottom + 1);
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blockAbove.equals(blocks[i][j]) || blockBelow.equals(blocks[i][j])) {
                    if (blocks[i][j].getFillColor() == Color.BLACK || blocks[i][j].getFillColor() == Color.PINK) {
                        return true;
                    }
                    else if (blockAbove.equals(getEnd()) || blockBelow.equals(getEnd())) {
                        isCompleted = true;
                        return false;
                    }
                    else if (blocks[i][j].getFillColor() == Color.RED) {
                        penguin.setPosition(penguinPos.getX() - (BLOCK_SIDELENGTH * 4) + 5, penguinPos.getY()); // red blocks help you transport across walls if there's no way out otherwise
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
    
    public void movingBlock(Block block){
        canvas.animate(dt -> {
            block.move(canvas);
        });
    }
}