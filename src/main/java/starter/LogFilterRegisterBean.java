package starter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

public class LogFilterRegisterBean extends FilterRegistrationBean<LogFilter>{
        public LogFilterRegisterBean(){
            super();
            this.setFilter(new LogFilter());
            this.addUrlPatterns("/*");
            this.setName("LogFilter");
            this.setOrder(1);
        }
    }
