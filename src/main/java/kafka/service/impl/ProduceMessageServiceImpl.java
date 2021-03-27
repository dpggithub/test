package kafka.service.impl;

import kafka.KafkaSender;
import kafka.service.ProduceMessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
@Slf4j
public class ProduceMessageServiceImpl implements ProduceMessageService {
    @Autowired
    private AdminClient adminClient;

    @Override
    public void createTopic() throws InterruptedException {
        NewTopic topic = new NewTopic("kafka_produce_message_T2", 8, (short) 1);
        adminClient.createTopics(Collections.singletonList(topic));
        log.info("创建成功!");
        Thread.sleep(1000);
    }

    @Override
    public void produceMessage(){
        for(int i=0;i<=8;i++){
            String msg ="produceMessage"+i;
            System.out.println((String.format("生成消息%s: ",msg)));
            KafkaSender.sendMsg("kafka_produce_message_T1",msg);
        }
    }
}
