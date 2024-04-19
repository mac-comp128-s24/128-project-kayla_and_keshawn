package MultiDimensionalCourse;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

public class Maze {
    private Block[][] blocks;
    private PenguinDude penguin;
    private CanvasWindow canvas;
    
    public Maze(CanvasWindow canvas){
        this.canvas = canvas;
        blocks = new Block[10][5];
        for (int i=0; i < blocks.length; i++) {
            for (int j=0; j < blocks[i].length; j++) {
                if (j != 4) {
                    Block newBlock = new Block(i, j);
                    blocks[i][j] = newBlock;
                    canvas.add(newBlock, i * 60, j * 60);
                }
            }
        }
        penguin = new PenguinDude(canvas);
        canvas.add(penguin, 0, canvas.getHeight() * 0.8);
    }

    public PenguinDude getPenguin() {
        return penguin;
    }

    public void setPenguin(PenguinDude penguin) {
        this.penguin = penguin;
        canvas.add(penguin, 0, canvas.getHeight() * 0.8);
    }

    public boolean penguinIsInHere() {
        double penguinX = penguin.getPosition().getX();
        double penguinY = penguin.getPosition().getY();
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j] == null) {
                    continue;
                }
                if (penguinX >= blocks[i][j].getPosition().getX() && penguinX <= blocks[i][j].getPosition().getX() + 60) {
                    if (penguinY <= blocks[i][j].getPosition().getY() && penguinX >= blocks[i][j].getPosition().getY() + 60) {
                        blocks[i][j].setFillColor(Color.LIGHT_GRAY);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}