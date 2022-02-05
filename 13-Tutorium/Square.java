public class Square extends RegularPolygon {
    public Square(int sideLength) {
        super(4, sideLength);
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }
}
