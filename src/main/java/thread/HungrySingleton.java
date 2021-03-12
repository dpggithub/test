package thread;

/**
 * 饿汉式单例
 */
public class HungrySingleton {
    private volatile static HungrySingleton INSTANCE =new HungrySingleton();

    public HungrySingleton(){}

    public static HungrySingleton getInstance(){
            return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(HungrySingleton.getInstance().hashCode());
            }).start();
        }
    }
}
