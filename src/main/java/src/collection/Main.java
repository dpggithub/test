package src.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student[] students=new Student[]{
                new Student("Bob", 78),
                new Student("Alice", 85),
                new Student("Brush", 66),
                new Student("Newton", 99)};
        List<Student> list= Arrays.asList(students);
        Students holder = new Students(list);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
    }
}

class Students {
    List<Student> list;
    Map<String, Integer> cache;

    Students(List<Student> list) {
        this.list = list;
        cache = new HashMap<>();
    }

    /**
     * 根据name查找score，找到返回score，未找到返回-1
     */
    int getScore(String name) {
        // 先在Map中查找:
        this.cache.put(name,findInList(name));
        Integer score = this.cache.get(name);
        System.out.println(score);
        if (score == null) {
             return -1;
        }
        return score == null ? -1 : score;
    }

    Integer findInList(String name) {
        for (Student ss : this.list) {
            if (ss.name.equals(name)) {
                return ss.score;
            }
        }
        return null;
    }
}

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
