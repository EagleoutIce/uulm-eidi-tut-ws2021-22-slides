import java.util.ArrayList;

public class IntegerList {
    public static void main(String[] args) {
ArrayList<Integer> intList = new ArrayList<>();
System.out.println(intList.size());
intList.add(42); intList.add(-13); intList.add(3);
System.out.println(intList + " (" + intList.size() + ")");
intList.remove(1);
System.out.println(intList + " (" + intList.size() + ")");
System.out.println(intList.get(1) + 13);
    }
}