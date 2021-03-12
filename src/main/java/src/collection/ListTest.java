package src.collection;

import java.util.*;

public class ListTest {

    // 有序集合list
    private static final List<String> stringList=new ArrayList<String>(){{
        add("a");
        add("B");
        add("c");
        add(2,"a");
    }};

    // 无重复集合set
    private static final Set<Integer> setI =new HashSet<Integer>(){{
        add(1);
        add(2);
        add(3);
        add(3);
    }};

    // 非线程安全map
    private static final Map<String,Collection> map=new HashMap<String,Collection>(){{
        put("list",stringList);
        put("set",setI);
    }};


    // 遍历list、set
    private static void iterator(Collection collection){
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
    }

    // 遍历map
    private static void iteratorMap(Map map) {
//        Set<String> set = map.keySet();
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            String key = (String) iterator.next();
//            Collection value = (Collection) map.get(key);
//            System.out.println("key is\n" + key +"\n" +"value is\n" + value);
//        }
        for(Object key: map.keySet()){
            Collection value=(Collection) map.get(key);
            System.out.println("key is\n" + key +"\n" +"value is\n" + value);
        }
    }

    // 查找指定list缺失的元素
    private static int findMissingNumber(int start, int end, List<Integer> list){
//        List<Integer> lists = new ArrayList<>();
//        for (int i = start; i <= end; i++) {
//            lists.add(i);
//        }
//        // 洗牌算法shuffle可以随机交换List中的元素位置:
//        Collections.shuffle(lists);
//        System.out.println(lists.toString());
//        ListIterator  its= lists.listIterator();
//        ListIterator it=list.listIterator();
//        while (its.hasNext() && it.hasNext()) {
//            if (its.next().equals(it.next())) {
//                // do nothing
//            } else {
//                return (int) its.previous();
//            }
//        }
        for(int i=start;i<=end;i++){
            if(list.contains(i)){
                // do nothing
            }else {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        iterator(setI);
//        iterator(stringList);
//        iteratorMap(map);

        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 洗牌算法shuffle可以随机交换List中的元素位置:
        //Collections.shuffle(list);
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");

    }
}
