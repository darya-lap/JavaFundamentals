package Task_6_InClass;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Boat {
    String nameOfBoat();
    String leader();
    boolean isSailing() default false;
}
