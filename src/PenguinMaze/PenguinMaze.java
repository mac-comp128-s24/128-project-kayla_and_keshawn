package PenguinMaze;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.Key;

public class PenguinMaze {
    
    private CanvasWindow canvas;
    private Maze maze;
    PenguinDude penguin;
    int lives;

    public PenguinMaze() {
        canvas = new CanvasWindow("Penguin Maze", 600, 300);
        maze = new Maze(canvas);
        penguin = maze.getPenguin();
        lives = 3;
    }

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
            // if (penguinTakesDamage()) {
            //     System.out.println("Been hit!!!");
            //     canvas.remove(penguin);
            //     PenguinDude revivedPenguin = new PenguinDude();
            //     maze.setPenguin(revivedPenguin);
            //     penguin = revivedPenguin;
            // }
            if (maze.isCompleted) {
                System.out.println("Yay! We did it!!!");
            }
        });
    }

    // public boolean penguinTakesDamage() {
    //     // return maze.penguinHitWall();
    // }

    public static void main(String[] args) {
        PenguinMaze dimensionalCourse = new PenguinMaze();
        dimensionalCourse.run();
    }
}
