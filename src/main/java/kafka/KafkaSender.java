package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaSender {
    public static void sendMsg(String topic, String msg){
        try {
            ProducerRecord<String,String> record = new ProducerRecord<>(topic, msg);
            // 从实例池获取连接,没有空闲连接则阻塞等待
            KafkaProducer<String, String> kafkaProducer = KafkaProducerQueue.queue.take();
            // 这里可以添加回调
            kafkaProducer.send(record);
            // 归还kafka连接到连接池队列
            KafkaProducerQueue.queue.put(kafkaProducer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
