package kafka.service.impl;

import com.sun.javafx.binding.StringFormatter;
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
            log.info(StringFormatter.format("生成消息%s: ",msg).toString());
            KafkaSender.sendMsg("kafka_produce_message_test",msg);
        }
    }
}
