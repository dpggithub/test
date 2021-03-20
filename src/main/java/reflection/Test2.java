package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person=new Person("李四",25);
        Class<Person> cls0 = (Class<Person>) Person.class;
        Class<Person> cls = (Class<Person>) person.getClass();
        Class<Person> cls1 = (Class<Person>) Class.forName("reflection.Test2$Person");
        System.out.println(cls0.toString());
        System.out.println(cls.toString());
        System.out.println(cls1.toString());


        Method method=person.getClass().getMethod("getName");
        System.out.println(method.invoke(person));
    }

    static class Person{
        private String name;

        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Person(){}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    static class Pilot extends Person{
        private Integer expTime;

        public Integer getExpTime() {
            return expTime;
        }

        public void setExpTime(Integer expTime) {
            this.expTime = expTime;
        }

        public Pilot(String name, Integer age) {
            super(name, age);
        }

        public Pilot() {
        }
    }
}
