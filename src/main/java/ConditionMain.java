import config.ConditionConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.ListService;

public class ConditionMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService=context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name")+ "系统下的命令列表为：" +listService.showListCmd());
        context.close();
    }

}
