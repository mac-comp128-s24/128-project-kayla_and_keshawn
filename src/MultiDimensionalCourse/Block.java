package MultiDimensionalCourse;

import edu.macalester.graphics.Rectangle;

public class Block extends Rectangle{

    private double x;
    private double y;

    public Block(double x, double y) {
        super(x, y, 60, 60);
    }

    public boolean penguinIsInHere(PenguinDude penguin) {
        for (double i = x; i < x + 60; i++) {
            for (double j = y; j < y + 60; j++) {
                if (penguin.getPosition().getX() == i && penguin.getPosition().getY() == j) {
                    return true;
                }
            }
        }
        return false;
    }
}
