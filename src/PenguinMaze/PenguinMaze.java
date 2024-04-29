package PenguinMaze;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.Key;

import java.util.Iterator;
import java.util.List;

public class PenguinMaze {
    
    private CanvasWindow canvas;
    private Maze maze;
    private PenguinDude penguin;
    private List<String> levelFiles;
    private Iterator<String> iter;
    private int lives;

    public PenguinMaze(CanvasWindow canvas) {
        this.canvas = canvas;
        levelFiles = List.of("MazePattern1.txt", "MazePattern2.txt", "MovingWalls.txt", "Level4.txt", "Level5.txt", "Level6.txt");
        iter = levelFiles.iterator();
        maze = new Maze(canvas, iter.next());
        penguin = maze.getPenguin();
        lives = 3;
    }

    /**
     * Controls main movement of penguin; makes it move up, down, left and right.
     * It also iterates through the list of text files that make up the mazes
     */
    public void run() {
        canvas.onKeyDown((event) -> {
            if (event.getKey() == Key.RIGHT_ARROW) {
                penguin.moveBy(5, 0);
            }
            if (event.getKey() == Key.LEFT_ARROW) {
                penguin.moveBy(-5, 0);
            }
            if (event.getKey() == Key.UP_ARROW) {
                penguin.moveBy(0, -5);
            }
            if (event.getKey() == Key.DOWN_ARROW) {
                penguin.moveBy(0, 5);
            }
            if (penguin.getPosition().getX() <= 0) {
                penguin.setPosition(5, penguin.getPosition().getY());
            }
            if (penguin.getPosition().getY() <= 0) {
                penguin.setPosition(penguin.getPosition().getX(), 5);
            }
            if (penguin.getPosition().getX() + penguin.getWidth() >= canvas.getWidth()) {
                penguin.setPosition(canvas.getWidth() - penguin.getWidth() - 5, penguin.getPosition().getY());
            }
            if (penguin.getPosition().getY() + penguin.getHeight() >= canvas.getHeight()) {
                penguin.setPosition(penguin.getPosition().getX(), canvas.getHeight() - penguin.getHeight() - 5);
            }
            if (penguinTakesDamage()) { // what to do when penguin hits wall
                System.out.println("Been hit!!!");
                canvas.remove(penguin);
                PenguinDude revivedPenguin = new PenguinDude();
                maze.setPenguin(revivedPenguin);
                penguin = revivedPenguin;
                lives--;
                if (lives == 0) {
                    canvas.removeAll();
                    PenguinDude lossPenguin = new PenguinDude();
                    lossPenguin.setLossPenguin();
                    canvas.add(lossPenguin);
                    maze.isPaused = true;
                }
            }
            if (maze.isCompleted) {
                if (iter.hasNext()) {
                    System.out.println("Yay! You did it!!!");
                    canvas.removeAll();
                    maze = new Maze(canvas, iter.next());
                    penguin = maze.getPenguin();
                }
                else {
                    
                }
            }
        });
    }

    public boolean penguinTakesDamage() {
        return maze.hitsWall(penguin);
    }
}
