package src.generify;

public interface MapInterface<K,V> {
    V get(K k);

    void put(K k,V v);
}
