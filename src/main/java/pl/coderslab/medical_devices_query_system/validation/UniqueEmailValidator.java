package pl.coderslab.medical_devices_query_system.validation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.coderslab.medical_devices_query_system.services.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
@Slf4j
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserService userService;

    @Override
    public void initialize(UniqueEmail annotation) {

    }

    @Override
    public boolean isValid(String emailToCheck, ConstraintValidatorContext constraintValidatorContext) {
        log.info("Sprawdzenie czy użytkownik o emailu istnieje");
        return !userService.existByEmail(emailToCheck);
    }
}
