package pl.coderslab.medical_devices_query_system.controllers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.medical_devices_query_system.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.domain.model.user.User;
import pl.coderslab.medical_devices_query_system.services.UserService;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/engineer")
public class RemoveEngineerController {
    private final UserService userService;

    @PostMapping("/remove")
    public String removeEngineer(@RequestParam long id) {
        Optional<User> engineer = userService.findUserById(id);
        if (!engineer.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono użytkownika o id" + id);
        }
        userService.deleteUser(engineer.get());
        return "redirect:/admin/engineer/list";
    }

}

