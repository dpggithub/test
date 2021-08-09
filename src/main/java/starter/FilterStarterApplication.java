package starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableLogFilter
public class FilterStarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilterStarterApplication.class,args);
    }

    @GetMapping("/test")
    public String test(){
        return "this is a demo boot.";
    }
}
