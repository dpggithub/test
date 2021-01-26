package thread;

public class Thread02 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start:");
            Thread t = new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(10,999990);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("start new thread!");
                }
            });
            t.start(); // 启动新线程
        Thread.sleep(11,999999);
        System.out.println("main end:");
        }
}
