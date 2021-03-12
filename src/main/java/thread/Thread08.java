package thread;

/**
 * this溢出
 * 指令重排序
 */
public class Thread08 {

    private int num=8;
    Thread t;

    public Thread08(){
        t=new Thread(()->{
            System.out.println(this.num);
        });
    }

    public void startT(){
        t.start();
    }

    public static void main(String[] args) {
        Thread08 tt =new Thread08();
        tt.startT();
    }
}
