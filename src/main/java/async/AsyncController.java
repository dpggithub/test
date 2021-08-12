package async;

import async.threadpool.TestAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private TestAsyncService testAsyncService;

    @GetMapping("/test1")
    public String getTest1(){
        System.out.println(asyncService.getTest1());
        log.info("============>"+Thread.currentThread().getName());
        return "异步,正在解析......";
    }

    @GetMapping("/test2")
    public String getTest2(){
        ExecutorService service = Executors.newFixedThreadPool(5);
        RunnableTask1 task1 = new RunnableTask1();
        service.execute(task1);
        log.info("=========》当前线程名："+Thread.currentThread().getName());
        return "异步,正在解析......";
    }

    @GetMapping("/test3")
    public Object getTest3() throws ExecutionException, InterruptedException {
       log.info("当前线程名:{}",Thread.currentThread().getName());
        long before =System.currentTimeMillis();
        log.info("调用前时间:{}",before);
        Future<String> future = testAsyncService.serviceThread1("参数uuid is ttddgtw");
        // 获取future
        log.info("Future延迟4秒:{}",future.get());
        long after = System.currentTimeMillis();
        log.info("调用后时间:{}",after);
        log.info("after-before:{}秒",(after-before)/1000);
        return "调用完成";
    }

    @GetMapping("/test4")
    public Object getTest4() throws ExecutionException, InterruptedException {
        log.info("当前线程名:{}",Thread.currentThread().getName());
        long before =System.currentTimeMillis();
        log.info("调用前时间:{}",before);
        Future<String> future = testAsyncService.serviceThread1("参数uuid is xyzsshj");
        // 获取future
        log.info("Future延迟3秒:{}",future.get());
        long after = System.currentTimeMillis();
        log.info("调用后时间:{}",after);
        log.info("after-before:{}秒",(after-before)/1000);
        return "调用完成";
    }

    @GetMapping("/test5")
    public Object task() throws Exception{
        log.info("当前线程名:{}",Thread.currentThread().getName());
        long start=System.currentTimeMillis();

        Future<String> task1 = testAsyncService.serviceThread1("参数2233");
        Future<String> task2 = testAsyncService.serviceThread2("参数1569");

        while(true){
            if(task1.isDone()&&task2.isDone()){
                break;
            }
            Thread.sleep(1000);
        }
        long end=System.currentTimeMillis();
        System.out.println("总任务花费时间"+(end-start)/1000 +"毫秒");
        return "调用完成";
    }
}
