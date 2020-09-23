package pl.coderslab.medical_devices_query_system.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.coderslab.medical_devices_query_system.user.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@Slf4j
public class RepeatPasswordValidator implements ConstraintValidator<RepeatPassword, User> {
    @Override
    public void initialize(RepeatPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        log.info("Porównanie czy podane hasła są identyczne");
        return user.getPassword().equals(user.getRepeatPassword());
    }
}
