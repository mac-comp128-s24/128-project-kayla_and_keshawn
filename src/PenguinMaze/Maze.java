package PenguinMaze;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;

public class Maze {
    private Block[][] blocks;
    private PenguinDude penguin;
    private CanvasWindow canvas;
    private double pengRow;
    private double pengCol;
    
    public Maze(CanvasWindow canvas){
        this.canvas = canvas;
        blocks = new Block[10][5];
        for (int i=0; i < blocks.length; i++) {
            for (int j=0; j < blocks[i].length; j++) {
                Block newBlock = new Block(i, j);
                blocks[i][j] = newBlock;
                newBlock.setFillColor(Color.LIGHT_GRAY);
                if (j != 4) {
                    newBlock.setFillColor(Color.BLACK);
                }
                canvas.add(newBlock, i * 60, j * 60);
            }
        }
        penguin = new PenguinDude();
        pengCol = 1;
        pengRow = Math.floor(getStart().getPosition().getY() / 60);
        canvas.add(penguin, pengCol + 15, (pengRow * 60) + 15);
    }

    public PenguinDude getPenguin() {
        return penguin;
    }

    public void setPenguin(PenguinDude penguin) {
        this.penguin = penguin;
        canvas.add(penguin, pengCol + 15, (pengRow * 60) + 15);
    }

    public boolean penguinIsInHere() {
        double penguinX = penguin.getPosition().getX();
        double penguinY = penguin.getPosition().getY();
        GraphicsObject block = canvas.getElementAt(penguinX - 1, penguinY - 1);
        // System.out.println(block);
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (block.equals(blocks[i][j])) {
                    if (blocks[i][j].getFillColor() == Color.BLACK) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public Block getStart() {
        for (int i = 0; i < blocks[i].length; i++) {
            if (blocks[0][i].getFillColor() != Color.BLACK) {
                return blocks[0][i];
            }
        }
        return null;
    }
}