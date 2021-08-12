package async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService{

    @Async
    @Override
    public String getTest1(){
        Object building = new Object();
        synchronized (building){
            try {
                for (int i = 1;i <= 100;i++){
                    log.info(Thread.currentThread().getName()+"----------异步：>"+i);
                    building.wait(200);
                }
                return "执行异步任务完毕";
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return Thread.currentThread().getName()+"执行完毕";
    }
}
