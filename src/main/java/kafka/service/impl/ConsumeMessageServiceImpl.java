package kafka.service.impl;

import com.sun.javafx.binding.StringFormatter;
import kafka.service.ConsumeMessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumeMessageServiceImpl  implements ConsumeMessageService {
    @Override
    @KafkaListener(topics = "kafka_produce_message_T1")
    public void consumeMessage(ConsumerRecord<?, String> record){
        String msg =record.value();
        log.info(StringFormatter.format("消费消息%s: ",msg).toString());
    }
}
