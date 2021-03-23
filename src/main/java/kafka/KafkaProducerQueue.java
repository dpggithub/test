package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class KafkaProducerQueue {

    /**
     * 实例池大小
     */
    public static final int producerNum = 6;

    /**
     * 阻塞队列实现生产者实例池,获取连接作出队操作，归还连接作入队操作
     */
    public static BlockingQueue<KafkaProducer<String, String>> queue = new LinkedBlockingQueue<>(producerNum);

    // 初始化producer实例池
    static {
        for (int i = 0; i <producerNum ; i++) {
            KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(getDefaultProps());
            queue.add(kafkaProducer);
        }
    }

    private static Properties getDefaultProps(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        // acks=0 配置适用于实现非常高的吞吐量 , acks=all 这是最安全的模式
        props.put("acks", "all");
        // 发送到同一个partition的消息会被先存储在batch中，该参数指定一个batch可以使用的内存大小，
        // 单位是 byte。不一定需要等到batch被填满才能发送,  默认 16384=16KB
        props.put("batch.size", 16384);
        //生产者在发送消息前等待linger.ms，从而等待更多的消息加入到batch中。如果batch被填满或者linger.ms达到上限，就把batch中的消息发送出去
        // 当linger.ms>0时，延时性会增加，但会提高吞吐量，因为会减少消息发送频率
        props.put("linger.ms", 1);
        // 32MB
        props.put("buffer.memory", 33554432);
        // Snappy压缩技术是Google开发的，它可以在提供较好的压缩比的同时，减少对CPU的使用率并保证好的性能，所以建议在同时考虑性能和带宽的情况下使用。
        // Gzip压缩技术通常会使用更多的CPU和时间，但会产生更好的压缩比，所以建议在网络带宽更受限制的情况下使用
        // 默认不压缩，该参数可以设置成snappy、gzip 或 lz4 对发送给broker的消息进行压缩
        props.put("compression.type", "snappy");
        // 默认值为0，当设置为大于零的值，客户端会重新发送任何发送失败的消息。
        // 注意，此重试与客户端收到错误时重新发送消息是没有区别的。
        // 在配置max.in.flight.requests.per.connection不等于1的情况下，允许重试可能会改变消息的顺序
        // 因为如果两个批次的消息被发送到同一个分区，第一批消息发送失败但第二批成功，而第一批消息会被重新发送，则第二批消息会先被写入。
        props.put("retries", 1);
        // 生产者在收到服务器响应之前可以发送的消息个数
        props.put("max.in.flight.requests.per.connection", 2);
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", StringSerializer.class);
        return props;
    }

}
