package PenguinMaze;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import java.util.Queue;
import java.util.LinkedList;

public class Maze {
    private final int BLOCK_SIDELENGTH = 60;
    private Block[][] blocks;
    private PenguinDude penguin;
    private CanvasWindow canvas;
    private double pengRow;
    private double pengCol;
    private GraphicsText exit;
    public boolean isCompleted;
    private Queue<Block> mazeQueue;
    
    public Maze(CanvasWindow canvas){
        isCompleted = false;
        this.canvas = canvas;
        penguin = new PenguinDude();
        exit = new GraphicsText("EXIT!");
        blocks = new Block[10][5];
        for (int i=0; i < blocks.length; i++) {
            for (int j=0; j < blocks[i].length; j++) {
                Block newBlock = new Block(i, j);
                blocks[i][j] = newBlock;
                newBlock.setFillColor(Color.LIGHT_GRAY);
                if (j != 2 && i > 2) { // determines where the walls go
                    newBlock.setFillColor(Color.BLACK);
                    
                }
                
                newBlock.setStrokeColor(newBlock.getFillColor());
                canvas.add(newBlock, i * BLOCK_SIDELENGTH, j * BLOCK_SIDELENGTH);
            }
        }
        pengCol = 1;
        pengRow = Math.floor(getStart().getPosition().getY() / BLOCK_SIDELENGTH); // Calculates y-coordinate of penguin when game gets configured
        canvas.add(exit, getEnd().getPosition().getX(), getEnd().getPosition().getY() + 30);
        canvas.add(penguin, pengCol + 15, (pengRow * BLOCK_SIDELENGTH) + 15);
    }

    public PenguinDude getPenguin() {
        return penguin;
    }

    public void setPenguin(PenguinDude penguin) {
        this.penguin = penguin;
        canvas.add(penguin, pengCol + 15, (pengRow * BLOCK_SIDELENGTH) + 15);
    }

    public boolean penguinHitWall() {
        double penguinXLeft = penguin.getPosition().getX();
        double penguinYTop = penguin.getPosition().getY();
        double penguinXRight = penguin.getPosition().getX() + 30;
        double penguinYBottom = penguin.getPosition().getY() + 30;
        GraphicsObject blockAbove = canvas.getElementAt(penguinXLeft - 1, penguinYTop - 1);
        GraphicsObject blockBelow = canvas.getElementAt(penguinXRight + 1, penguinYBottom + 1);
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blockAbove.equals(blocks[i][j]) || blockBelow.equals(blocks[i][j])) {
                    if (blocks[i][j].getFillColor() == Color.BLACK) {
                        return true;
                    }
                    else if (blockAbove.equals(getEnd()) || blockBelow.equals(getEnd())) {
                        isCompleted = true;
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public Block getStart() {
        for (int j = 0; j < blocks[0].length; j++) {
            if (blocks[0][j].getFillColor() != Color.BLACK) {
                return blocks[0][j];
            }
        }
        return null;
    }

    public Block getEnd() {
        for (int j = 0; j < blocks[9].length; j++) {
            if (blocks[9][j].getFillColor() != Color.BLACK) {
                blocks[9][j].setStrokeColor(Color.BLACK);
                return blocks[9][j];
            }
        }
        return null;
    }
    
    // public Queue<Block> solutionPath(){
    //     mazeQueue= new LinkedList<Block>();
    //     mazeQueue.offer(getStart());
    //     while(!mazeQueue.isEmpty()){
    //     }
    // public Block[][] getNeighbors(){

    // }
    
}