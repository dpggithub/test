package delayedQueue;

import com.lyentech.bdc.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.LinkedBlockingDeque;

@Slf4j
public class WorkPictureQueue {

    private final Integer maxRequestCount;

    private final String queueName;

    private final LinkedBlockingDeque<RequestToQue> linkedBlockingDeque;

    public WorkPictureQueue(LinkedBlockingDeque<RequestToQue> linkedBlockingDeque, Integer maxRequestCount,String queueName){
        this.linkedBlockingDeque = linkedBlockingDeque;
        this.maxRequestCount = maxRequestCount;
        this.queueName = queueName;
    }

    public void offerRequestToQueue(RequestToQue request){
        if(linkedBlockingDeque.size() > maxRequestCount){
            throw new BusinessException("队列容量已超过限制");
        }

        try {
            linkedBlockingDeque.offer(request);
            log.info("添加队列成功:{}",linkedBlockingDeque.size());
            Thread.sleep(1000);
        }catch (Exception e){
            log.error("添加消息失败");
        }
    }

    public void takeRequestToQueue(){
        new Thread(() -> {
            while (true){
                try{
                    RequestToQue request = linkedBlockingDeque.take();
                    log.info("取队列成功");
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new BusinessException("取消息失败");
                }
            }
        }).start();
    }
}
