package delayedQueue;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class RequestQueueController {

    private static final int CORE_SIZE =Runtime.getRuntime().availableProcessors();

    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_SIZE,CORE_SIZE,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>());

    public void asyncListTask(WorkPictureQueue workPictureQueue){
        threadPoolExecutor.execute(() ->{
            if(workPictureQueue != null){
                workPictureQueue.takeRequestToQueue();
            }
        });
    }

    @PostMapping("/test1")
    public String test1(@RequestBody RequestToQue request){
        LinkedBlockingDeque<RequestToQue> linkedBlockingDeque = new LinkedBlockingDeque<>();
        WorkPictureQueue workPictureQueue =new WorkPictureQueue(linkedBlockingDeque,20,null);
        workPictureQueue.offerRequestToQueue(request);
        asyncListTask(workPictureQueue);
        return "success";
    }
}
