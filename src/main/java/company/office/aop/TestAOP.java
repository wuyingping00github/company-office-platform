package company.office.aop;

import java.lang.annotation.*;

/**
 * 编写的拦截规则的注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAOP {

String name();

}
