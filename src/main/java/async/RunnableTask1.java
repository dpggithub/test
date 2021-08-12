package async;

public class RunnableTask1 implements Runnable{
    @Override
    public void run(){
        Object building = new Object();
        synchronized (building){
            try {
                for (int i = 1;i <= 100;i++){
                    System.out.println(Thread.currentThread().getName()+"----------异步：>"+i);
                    building.wait(200);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
