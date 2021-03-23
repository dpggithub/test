package kafka.service.impl;

import kafka.KafkaSender;
import kafka.service.ProduceMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProduceMessageServiceImpl implements ProduceMessageService {
    @Override
    public void produceMessage(){
        for(int i=0;i<=8;i++){
            String msg ="produceMessage"+i;
            System.out.println((String.format("生成消息%s: ",msg)));
            KafkaSender.sendMsg("kafka_produce_message_T1",msg);
        }
    }
}
