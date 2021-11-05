import java.util.ArrayList;

public class PersonList {
    public static void main(String[] args) {
ArrayList<Person> persList = new ArrayList<>();
System.out.println(persList.size());
persList.add(new Person("Walter", 42)); 
persList.add(new Person("Ottmar", 13)); 
persList.add(new Person("Sabine", 27));
System.out.println(persList + " (" + persList.size() + ")");
persList.remove(1);
System.out.println(persList + " (" + persList.size() + ")");
System.out.println(persList.get(1));
    }
}

class Person {
    public String name;
    public int alter;

    public Person(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }
}