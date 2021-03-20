package kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumeMessageService  {
    /**
     * 消费消息
     */
    void consumeMessage(ConsumerRecord<?, String> record);
}
