public class Main {
    public static void main(String[] args) {
        Map map = new Map(new int[][] { //
                { 20, 40, 0, 30, 0, 10 }, //
                { 20, 30, 10, 0, 20, 0 }, //
                { 10, 0, 50, 0, 0, 10 }, //
                { 60, 40, 50, 80, 20, 60 }, //
                { 10, 0, 10, 40, 30, 20 } //
        });
        Car car = new Car(new Point(0, 3), 25, 4);
        car.drive(map);
    }
}
