package kafka.service;

public interface ProduceMessageService {

    /**
     * 创建主题
     */
    void createTopic() throws InterruptedException;

    /**
     * 生产消息
     */
    void produceMessage();
}
