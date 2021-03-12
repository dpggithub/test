package src.generify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IMap<K,V> implements MapInterface<K,V>{
    private K k;
    private V v;

    public IMap(){}

    public IMap(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public V get(K k){
        return this.getV();
    }

    public void put(K k, V v){
        this.setK(k);
        this.setV(v);
    }

    public static void main(String[] args) {
        MapInterface<String, List<String>> imap =new IMap<>();
        List<String> list=new ArrayList<String>(){{
            add("haha");
            add("哈哈");
        }};
        imap.put("你好",list);
        System.out.println(Arrays.toString(imap.get("你好").toArray()));
    }
}
