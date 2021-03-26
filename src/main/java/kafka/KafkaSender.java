package kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.TimeUnit;

@Slf4j
public class KafkaSender {
    public static void sendMsg(String topic, String msg){
        try {
            ProducerRecord<String,String> record = new ProducerRecord<>(topic, msg);
            // 从实例池获取连接,没有空闲连接则阻塞等待
            KafkaProducer<String, String> kafkaProducer = KafkaProducerQueue.queue.take();
            // 这里可以添加回调
            kafkaProducer.send(record, (recordMetadata, e) -> {
                if(e ==null){
                    log.info("发送消息成功");
                }else {
                    kafkaProducer.close(0, TimeUnit.SECONDS);
                }
            });
            // 归还kafka连接到连接池队列
            KafkaProducerQueue.queue.put(kafkaProducer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
