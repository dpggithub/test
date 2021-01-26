package src;

import exception.BusinessException;

public class ExtendsTest {

    public static void main(String[] args) {

        Person[] p = {new Student("李刚", 25, 173, "男", 85, 4), new Person("小明", 31, 175, "男")};
        for (Person o : p) {
            try {
                //if (o instanceof Student) {

                    Student s = (Student) o;
                    System.out.println(s.getSex());
                    System.out.println(s.getHeight());
                //}
            } catch (ClassCastException e) {
                e.getStackTrace();
                throw new BusinessException("转型失败！",e);
            }
        }
    }


        static class Person {

            protected String name;
            protected int age;
            protected int height;
            protected String sex;

            public Person() {
            }

            public Person(String name, int age, int height, String sex) {
                this.name = name;
                this.age = age;
                this.height = height;
                this.sex = sex;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }
        }

        static class Student extends Person {
            protected int scores;
            protected int grade;

            public Student() {
                super();
            }

            public Student(String name, int age, int height, String sex, int scores, int grade) {
                super(name, age, height, sex);
                this.scores = scores;
                this.grade = grade;
            }

            public int getScores() {
                return scores;
            }

            public void setScores(int scores) {
                this.scores = scores;
            }

            public int getGrade() {
                return grade;
            }

            public void setGrade(int grade) {
                this.grade = grade;
            }
        }
}
