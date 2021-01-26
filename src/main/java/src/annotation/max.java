package src.annotation;

import java.lang.annotation.*;

@Inherited
@Documented
@Repeatable(kk.class) //可重复注解的标识
@Target({ElementType.FIELD,ElementType.PARAMETER}) //注解作用于源码的位置
@Retention(RetentionPolicy.RUNTIME) //注解的生命周期 此处会加载到jvm内存并被程序读取
public @interface max {
    String name() default "";
    int Maxvalue() default 195;
    int Minvalue() default 150;
}

@Target({ElementType.FIELD,ElementType.PARAMETER}) //注解作用于源码的位置
@Retention(RetentionPolicy.RUNTIME)
 @interface min {
    String name() default "";
    int Maxvalue() default 100;
    int Minvalue() default 50;
}

@Inherited
@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER}) //注解作用于源码的位置
@Retention(RetentionPolicy.RUNTIME)
@interface kk{
    max[] value();
}

