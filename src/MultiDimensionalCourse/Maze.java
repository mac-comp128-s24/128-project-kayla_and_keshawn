package MultiDimensionalCourse;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.*;

import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

public class Maze {
    private Block[][] blocks;
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
    }
}