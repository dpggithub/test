package designPattern;

/**
 * 懒汉式单例
 */
public class LazySingleton {
    private static volatile LazySingleton INSTANCE;

        public LazySingleton(){}

        public static LazySingleton getInstance(){
            if(INSTANCE ==null){
                synchronized (LazySingleton.class) {
                    // double check lock
                    if (INSTANCE == null) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        INSTANCE = new LazySingleton();
                    }
                }
            }
            return INSTANCE;
        }

    public void m(int n){
        System.out.println(n);
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(LazySingleton.getInstance().hashCode());
                LazySingleton.getInstance().m(4);
            }).start();
        }
    }
}
