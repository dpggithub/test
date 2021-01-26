package src.stream;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.*;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {


        // 1. Individual values
        Stream<String> stream = Stream.of("a", "b", "c");
        // 2. Arrays
        String[] strArray = new String[]{"a", "b", "c", ""};
        Stream<String> stream1 = Stream.of(strArray);
        Stream<String> stream2 = Arrays.stream(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        Stream<String> stream3 = list.stream();


        /**
         * 数值流构造
         */
//    IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
//    IntStream.range(1, 3).forEach(System.out::println);
//    IntStream.rangeClosed(1, 3).forEach(System.out::println);

        /**
         * 流转换为其他数据结构
         */
        // 1. Array
     /* [] strArray1 = stream.toArray(String[]::new);
        // 2. Collection
        List<String> list1 = stream.collect(Collectors.toList());
        List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
        Set set1 = stream.collect(Collectors.toSet());
        Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
        // 3. String
        String str = stream.collect(Collectors.joining()).toString();


        Optional<String> s = Optional.ofNullable(strArray).isPresent(System.out::println);*/

//        String sum = (Integer) stream.reduce("0", (a, b) -> (String.valueOf(1 + 2)));

    }
}
