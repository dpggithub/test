package thread;

public class ThreadLocalTest01 {
    private static final ThreadLocal<String> threadLocal =new ThreadLocal();

    public static void set(String value){
        threadLocal.set(value);
    }

    public static String get(){
        return threadLocal.get();
    }

    public static void remove(){
        threadLocal.remove();
    }

    public static void main(String[] args) {
        try {
            threadLocal.set("is ok");
            System.out.println(threadLocal.get());
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {
            threadLocal.remove();
        }
    }
}
