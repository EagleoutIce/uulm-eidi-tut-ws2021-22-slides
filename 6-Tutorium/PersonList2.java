import java.util.ArrayList;

public class PersonList2 {
    public static void main(String[] args) {
ArrayList<Person2> persList = new ArrayList<>();
System.out.println(persList.size());
persList.add(new Person2("Walter", 42)); 
persList.add(new Person2("Ottmar", 13)); 
persList.add(new Person2("Sabine", 27));
System.out.println(persList + " (" + persList.size() + ")");
persList.remove(1);
System.out.println(persList + " (" + persList.size() + ")");
System.out.println(persList.get(1));
    }
}

class Person2 {
    public String name;
    public int alter;

    public Person2(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public String toString() {
        return name + " (" + alter + " Jahre alt)";
    }
}