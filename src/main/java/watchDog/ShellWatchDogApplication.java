package watchDog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ShellWatchDogApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShellWatchDogApplication.class,args);
    }
}
