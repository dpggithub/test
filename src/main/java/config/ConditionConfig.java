package config;

import condition.LinuxCondition;
import condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import service.LinuxServiceImpl;
import service.ListService;
import service.WindowsServiceImpl;

@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowService(){
        return new WindowsServiceImpl();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxService(){
        return new LinuxServiceImpl();
    }
}
