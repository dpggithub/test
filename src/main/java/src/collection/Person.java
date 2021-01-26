package src.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Person {

    public static void main(String[] args) {
        Persons[] persons=new Persons[]{
                new Persons("Xiao", "Ming", 18),
                new Persons("Xiao", "Hong", 25),
                new Persons("Bob", "Smith", 20)};
        List<Persons> list = Arrays.asList(persons);
        boolean exist = list.contains(new Persons("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");
    }

}
class Persons {
    String firstName;
    String lastName;
    int age;

    public Persons(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Persons) {
            Persons p = (Persons) o;
            return Objects.equals(this.firstName, p.firstName) && Objects.equals(this.lastName,p.lastName)  && this.age == p.age;
        }
        return false;
    }
}