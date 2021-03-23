//package kafka.controller;
//
//import com.lyentech.bdc.http.response.ResultEntity;
//import kafka.service.ConsumeMessageService;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/kafka/consume")
//public class ConsumeMessageController {
//    @Autowired
//    private ConsumeMessageService consumeMessageService;
//
//    @PostMapping("cm")
//    public ResultEntity consumeMessage(ConsumerRecord<?,String> record){
//        consumeMessageService.consumeMessage(record);
//        return ResultEntity.success();
//    }
//}
