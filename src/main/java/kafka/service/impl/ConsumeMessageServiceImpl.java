package kafka.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kafka.dao.PushMessageMapper;
import kafka.model.PushMessage;
import kafka.service.ConsumeMessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumeMessageServiceImpl extends ServiceImpl<PushMessageMapper,PushMessage> implements ConsumeMessageService {
    @Autowired
    private PushMessageMapper pushMessageMapper;

    @Override
    @KafkaListener(topics = "kafka_produce_message_T1")
    public void consumeMessage(ConsumerRecord<?, String> record){
        String msg =record.value();
        PushMessage pushMessage =new PushMessage();
        pushMessage.setMsg(msg);
        save(pushMessage);
        System.out.println((String.format("消费消息%s: ",msg)));
    }
}
