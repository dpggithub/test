package kafka.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kafka.model.PushMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumeMessageService extends IService<PushMessage> {
    /**
     * 消费消息
     */
    void consumeMessage(ConsumerRecord<?, String> record);
}
