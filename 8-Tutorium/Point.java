/**
 * Represents a 2D point
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point coordinates, int x, int y) {
        this(coordinates.x + x, coordinates.y + y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
