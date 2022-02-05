public class PolygonTest {
   public static void main(String[] args) {
      RegularPolygon triangle = new EquilateralTriangle(3); // Aufruf 1

      EquilateralTriangle newTriangle = triangle; // Aufruf 2

      Square square = new RegularPolygon(4, 4); // Aufruf 3
   }

}