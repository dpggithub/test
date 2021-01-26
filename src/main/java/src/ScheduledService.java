package src;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledService {
    @Scheduled(fixedRate = 6000*10)
    public  void syncMaterial() {
        String[] mediaTypes = {"image", "video", "voice", "news", "text"};
        for (String str : mediaTypes) {
            System.out.println(str);
        }
    }
}
