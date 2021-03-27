package kafka.controller;

import com.lyentech.bdc.http.response.ResultEntity;
import kafka.service.ProduceMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/produce")
public class ProduceMessageController {
    @Autowired
    private ProduceMessageService produceMessageService;

    @PostMapping("/create")
    public ResultEntity createTopic() throws InterruptedException {
        produceMessageService.createTopic();
        return ResultEntity.success();
    }

    @PostMapping("/pm")
    public ResultEntity produceMessage(){
        produceMessageService.produceMessage();
        return ResultEntity.success();
    }
}
