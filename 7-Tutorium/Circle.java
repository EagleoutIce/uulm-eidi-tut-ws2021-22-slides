public class Circle {
   private double radius;
   private double area;
   private double circumference;

   public Circle(double radius) {
       this.radius = radius;
       this.area = Circle.computeArea(radius);
       this.circumference = Circle.computeCircumference(radius);
   }

   public double getRadius() {
       return radius;
   }

   public double getArea() {
       return area;
   }

   public double getCircumference() {
       return circumference;
   }

   public void printProperties() {
       System.out.println("Radius: " + radius + "cm");
       System.out.println("Fläche: " + area + "cm^2");
       System.out.println("Umfang: " + circumference + "cm");
   }

   // Alternativ: this.area = Math.PI * Math.pow(radius, 2);
   public static double computeArea(double radius) {
       return Math.PI * radius * radius;
   }

   public static double computeCircumference(double radius) {
       return 2 * Math.PI * radius;
   }

   public static void main(String[] args) {
       Circle smallCircle = new Circle(1);
       Circle mediumCircle = new Circle(5);
       Circle largeCircle = new Circle(10);

       smallCircle.printProperties();
       mediumCircle.printProperties();
       largeCircle.printProperties();

   }
}
