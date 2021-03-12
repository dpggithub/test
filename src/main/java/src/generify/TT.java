package src.generify;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TT<S> {
    private  int i;
    private  String str;
    private  S s;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static Set<String> getList() {
        return list;
    }



    public static final Set<String> list=new HashSet<String>(){{
        add("1");
        add("2");
        add("3");
    }};


    public static void main(String[] args) {
        Iterator<String> iterator= list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
