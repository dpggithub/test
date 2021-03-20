package designPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 */
public class FlyWeight {
    private static final Map<String,Student> cacheMap =new HashMap<>();

    static class Student{
        private String id;

        private String name;

        private int age;

        public Student(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    public static Student create(String id,String name,int age){
        String key = id + "\n" + name;
        // 先查找缓存:
        Student std = cacheMap.get(key);
        if (std == null) {
            // 未找到,创建新对象:
            System.out.printf("create new Student(%s, %s, %d)%n", id, name, age);
            std = new Student(id,name,age);
            // 放入缓存:
            cacheMap.put(key, std);
        } else {
            // 缓存中存在:
            System.out.printf("return cached Student(%s, %s, %d)%n", std.id, std.name, std.age);
        }
        return std;
    }

    public static void main(String[] args) {
        for(int i=0;i<=1;i++) {
            Student student = FlyWeight.create("0001", "Jack Ma", 55);
        }
    }

}
