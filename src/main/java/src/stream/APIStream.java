package src.stream;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class APIStream {

    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "", "c2", "c1");
        myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);
        Map<String, String> map = new HashMap<>();
        myList.forEach(item -> map.put(item, item));
        List<String> stringList = myList.stream().filter(item -> {
            String str = map.get(item);
            if (map.get(str).equals("")) {
                return false;
            }
            return true;
        }).map(item -> {
            System.out.println("map:" + item.toUpperCase());
            return item.toUpperCase();
        })/*.peek(item->{
            System.out.println(item.startsWith("A"));;
        })*/.collect(Collectors.toList());
        System.out.println(stringList);


        /**
         * 流的复用
         */
        Supplier<Stream<String>> streamSupplier = myList::stream;
        streamSupplier.get();
    }
}
