package src.stream;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PatternTest {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\s+");
        Stream<String> s = p.splitAsStream("The quick 000 brown fox jumps over the lazy dog");
        s.forEach(System.out::println);
        List<Long> st=new FibonacciSupplier().get();
        st.stream().limit(30).filter(n->n%2==0).map(n->n*n).forEach(System.out::println);
    }
}

/**
 * 生成斐波拉契数列
 */
class FibonacciSupplier  {
    public List<Long> get() {
        List<Long> list=new ArrayList<>();
        Long j=0L;
        for(int i=1;i<=30;i++){
            j=fibonacci(i);
            list.add(j);
        }
        return list;
    }

    private static Long fibonacci(int i){
        if(i==1){
            return 1L;
        }
        if(i==2){
            return 1L;
        }
        if(i>2){
            return fibonacci(i-1)+fibonacci(i-2);
        }
        return null;
    }
}
