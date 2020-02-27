package annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE) // scope is classes and interfaces
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    String name(); //annotation property
    boolean lazyLoad() default false; // unnecessary property

}
