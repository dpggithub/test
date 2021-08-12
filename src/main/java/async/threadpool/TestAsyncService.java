package async.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import java.util.concurrent.Future;

@Slf4j
@Service
public class TestAsyncService {

    @Async("threadPoolTaskExecutor1")
    public Future<String> serviceThread1(String str){
        log.info("当前线程名:{}",Thread.currentThread().getName());
        long before =System.currentTimeMillis();
        log.info("调用前时间:{}",before);
        Future<String> future;
        try{
            Thread.sleep(4000);
            future =new AsyncResult<>("success: "+str);
        } catch (InterruptedException e) {
            future =new AsyncResult<>("error");
        }
        long after = System.currentTimeMillis();
        log.info("调用后时间:{}",after);
        log.info("after-before:{}秒",(after-before)/1000);
        return future;
    }

    @Async("threadPoolTaskExecutor2")
    public Future<String> serviceThread2(String str){
        log.info("当前线程名:{}",Thread.currentThread().getName());
        long before =System.currentTimeMillis();
        log.info("调用前时间:{}",before);
        Future<String> future;
        try{
            Thread.sleep(3000);
            future =new AsyncResult<>("success: "+str);
        } catch (InterruptedException e) {
            future =new AsyncResult<>("error");
        }
        long after = System.currentTimeMillis();
        log.info("调用后时间:{}",after);
        log.info("after-before:{}秒",(after-before)/1000);
        return future;
    }
}
