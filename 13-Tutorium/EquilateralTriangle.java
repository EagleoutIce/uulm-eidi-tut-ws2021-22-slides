public class EquilateralTriangle extends RegularPolygon {
    public EquilateralTriangle(int sideLength) {
        super(3, sideLength);
    }

    @Override
    public double getArea() {
        return 0.25 * Math.sqrt(3) * sideLength * sideLength;
    }
}
