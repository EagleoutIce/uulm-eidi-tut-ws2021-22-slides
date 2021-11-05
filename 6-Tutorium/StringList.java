import java.util.ArrayList;

public class StringList {
    public static void main(String[] args) {
ArrayList<String> strList = new ArrayList<>();
System.out.println(strList.size());
strList.add("hi"); strList.add("du!"); strList.add("na du");
System.out.println(strList + " (" + strList.size() + ")");
strList.remove(1);
System.out.println(strList + " (" + strList.size() + ")");
System.out.println(strList.get(1) + 13);
    }
}