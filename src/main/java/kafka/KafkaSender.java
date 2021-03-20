package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class KafkaSender {
    public static void sendMsg(String topic, String msg){
        try {
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, msg);
            // 从实例池获取连接,没有空闲连接则阻塞等待
            BlockingQueue<KafkaProducer<String, String>> queue = new LinkedBlockingQueue<>(6);
            KafkaProducer<String, String> kafkaProducer = queue.take();
            // 这里可以添加回调
            kafkaProducer.send(record);
            queue.put(kafkaProducer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
