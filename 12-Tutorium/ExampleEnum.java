public enum ExampleEnum {
   ADD("Adds two ints") {
      int calculate(int a, int b) { return a + b; }
   },
   MUL("Multiplies two ints") {
      int calculate(int a, int b) { return a * b; }
   },
   DIV("Divides two numbers (rounds down)") {
      int calculate(int a, int b) { return a / b; }
   };

   abstract int calculate(int a, int b);
   private final String description;

   ExampleEnum(String desc) {
      this.description = desc;
   }

   public String getDescription() {
      return description;
   }
}
