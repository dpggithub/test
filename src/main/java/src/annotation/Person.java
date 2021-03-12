package src.annotation;

import java.lang.reflect.Field;

public class Person {
    @max(name = "身高")
    public int height;
    @min(name = "体重")
    public int weight;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        person.setHeight(180);
        person.setWeight(49);
        person.check(person);
        System.out.println(person.toString());
    }

    void check(Person person) throws IllegalArgumentException, IllegalAccessException {
        // 遍历所有Field:
        for (Field field : person.getClass().getFields()) {
            // 获取Field定义的@max:
            max ma = field.getAnnotation(max.class);
            // 如果@max存在:
            if (ma != null) {
                // 获取Field的值:
                int value = (Integer) field.get(person);
                // 判断值是否满足@Range的min/max:
                if (value > ma.Maxvalue() || value < ma.Minvalue()) {
                    throw new IllegalArgumentException("Invalid field: " + field.getName());
                }

                    String name =ma.name();
                    System.out.println(name);

            }

                min m = field.getAnnotation(min.class);
                if (m != null) {
                    int mi = (Integer) field.get(person);
                    if (mi > m.Maxvalue() || mi < m.Minvalue()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
        }
    }
}