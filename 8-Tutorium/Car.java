/**
 * Represents a Car
 */
public class Car {
    private final int emissions;
    private Point coordinates;
    private int fuel;

    public Car(Point coordinates, int emissions, int fuel) {
        this.coordinates = coordinates;
        this.emissions = emissions;
        this.fuel = fuel;
    }

    /**
     * Drive until you are out of fuel or stuck
     * @param map the map to drive on
     */
    public void drive(Map map) {
        for(;fuel > 0; fuel--) {
            if(!moveToNextField(map)) {
                return;
            }
            // bonus
            map.printForCar(this);
        }
    }

    /**
     * Move to the next (random) field
     * @param map the map to drive on
     * @return true if the move was successful
     */
    private boolean moveToNextField(Map map){
        Point[] possibleTargets = possibleTargets();
        for(Point target : possibleTargets) {
            int emissionLimit = map.getEmission(target);
            // Only move if possible
            if(emissionLimit == 0 || this.emissions < emissionLimit) {
                coordinates = target;
                return true;
            }
        }
        // No move was possible
        return false;
    }

    /**
     * @return {0,1,2,3} in a random order
     */
    private Point[] possibleTargets() {
        Point[] pos = {new Point(coordinates, 0, 1), // up
                       new Point(coordinates, 1, 0), // right
                       new Point(coordinates,-1, 0), // left
                       new Point(coordinates, 0,-1), // down
                      };
        shuffleArray(pos);
        return pos;
    }

    private void shuffleArray(Point[] pos) {
        for(int i = pos.length-1; i > 0; i--) {
            int randomIndex = (int)(Math.random()*(i+1)); // Number in [0, i)
            swap(pos, i, randomIndex);
        }
    }

    private void swap(Point[] pos, int i, int randomIndex) {
        Point j = pos[i];
        pos[i] = pos[randomIndex];
        pos[randomIndex] = j;
    }

    public int getX() {
        return coordinates.getX();
    }


    public int getY() {
        return coordinates.getY();
    }

    public int getEmissions() {
        return emissions;
    }
}
