package async.threadpool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class SpringAsyncConfigurer extends AsyncSupportConfigurer {
    @Bean
    public ThreadPoolTaskExecutor asyncExecutor(){
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(3);
        threadPool.setMaxPoolSize(3);
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        threadPool.setAwaitTerminationSeconds(15*60);
        return threadPool;
    }

    @Bean(name = "threadPoolTaskExecutor1")
    public Executor threadPoolTaskExecutor1(){
        return asyncExecutor();
    }

    @Bean(name = "threadPoolTaskExecutor2")
    public Executor threadPoolTaskExecutor2(){
        return asyncExecutor();
    }
}
