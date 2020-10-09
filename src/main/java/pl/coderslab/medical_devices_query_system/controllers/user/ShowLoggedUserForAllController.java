package pl.coderslab.medical_devices_query_system.controllers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.medical_devices_query_system.domain.model.user.User;
import pl.coderslab.medical_devices_query_system.services.UserService;

import java.security.Principal;

@RequiredArgsConstructor
@ControllerAdvice
public class ShowLoggedUserForAllController {

    private final UserService userService;

    @ModelAttribute("loggedUser")
    public User showUser(Principal principal) {
        if (principal != null) {
            return userService.findUserByEmail(principal.getName());
        }
        return new User();
    }
}
