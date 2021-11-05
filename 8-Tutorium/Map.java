/**
 * Represents a Map
 */
public class Map {
    private final int[][] fieldMap;

    public Map(int[][] fieldMap) {
        this.fieldMap = fieldMap;
    }

    public int getEmission(Point point) {
        if (pointOutOfBounds(point))
            return -1;
        else
            return fieldMap[point.getY()][point.getX()];
    }

    private boolean pointOutOfBounds(Point point) {
        return point.getY() < 0 || point.getX() < 0 || point.getY() >= fieldMap.length
                || point.getX() >= fieldMap[0].length;
    }

    /**
     * Draw the map
     *
     * @param target a point to draw a 'X' instead
     * @param mapper maps the emissions to a String to print
     */
    public void printForCar(Car car) {
        for (int y = 0; y < fieldMap.length; y++) {
            for (int x = 0; x < fieldMap[y].length; x++)
                System.out.print(fieldToChar(car, y, x));
            System.out.println();
        }
        System.out.println();
    }

    private char fieldToChar(Car car, int y, int x) {
        if (x == car.getX() && y == car.getY()) {
            return 'C';
        } else {
            int mapAt = fieldMap[y][x];
            boolean free = mapAt == 0 || mapAt > car.getEmissions();
            return free ? '_' : '#';
        }
    }
}