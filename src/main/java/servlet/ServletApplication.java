package servlet;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("redis.dao")
public class ServletApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServletApplication.class,args);
    }
}
