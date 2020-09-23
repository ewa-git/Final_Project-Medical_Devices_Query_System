package pl.coderslab.medical_devices_query_system.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RepeatPasswordValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatPassword {
    String message() default "Podane hasła nie są identyczne";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
