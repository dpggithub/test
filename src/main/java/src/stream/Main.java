package src.stream;

import java.util.*;

public class Main {
//    public static void main(String[] args) {
//        // 按行读取配置文件:
//        String[] arr = new String[]{"profile=native", "debug=true", "logging=warn", "interval=500"};
//        List<String> props = Arrays.asList(arr);
//        Map<String, String> map = props.stream()
//                // 把k=v转换为Map[k]=v:
//                .map(kv -> {
//                    String[] ss = kv.split("\\=", 2);
//                    return new HashMap<>().put(ss[0], ss[1]);
//                })
//                // 把所有Map聚合到一个Map:
//                .reduce(new HashMap<String,String>(), (m, kv) ->{
//                    return m.putAll(kv);}
//                    );
//        // 打印结果:
//        map.forEach((k, v) -> {
//            System.out.println(k + " = " + v);
//        });
//    }

//    public static void main(String[] args) {
//        String[] arr={"a","b","c"};
//        String s=String.join("***",arr);
//        System.out.println(s);
//    }

//    public static void main(String[] args) {
//        int[] scores = new int[] { 88, 77, 51, 66 };
//        Score s = new Score(scores);
//        s.printScores();
//        scores[2] = 99;
//        s.printScores();
//    }
//}
//
//class Score {
//    private int[] scores;
//    public Score(int[] scores) {
//        this.scores = scores;
//    }
//
//    public void printScores() {
//        System.out.println(Arrays.toString(scores));
//    }

//    public static void main(String[] args) {
//        AddClass addClass=new AddClass();
//        addClass.add("你好");
//        addClass.print();
//
//    }
//
//    static class AddClass {
//        private String s0="";
//        public AddClass add(String s1) {
//            s0=s0+s1;
//            return this;
//        }
//        public String value(){
//            return s0;
//        }
//
//        public void print(){
//            System.out.println(s0);
//        }
//    }


        public static void main(String[] args) {
            String[] fields = { "name", "position", "salary" };
            String table = "employee";
            String select = buildSelectSql(table, fields);
            System.out.println(select);
            System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
        }

    static String buildSelectSql(String table, String[] fields) {
        StringJoiner sj= new StringJoiner(", ","\"SELECT "," FROM "+table+"\"");
        for (String name : fields) {
             sj.add(name);
        }
        return sj.toString();
    }
}
