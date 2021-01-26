package condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata){
        return Objects.requireNonNull(conditionContext.getEnvironment().getProperty("os.name")).contains("Linux");
    }
}