package pl.coderslab.medical_devices_query_system.controllers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.domain.model.user.User;
import pl.coderslab.medical_devices_query_system.services.UserService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/engineer")
public class EngineerListController {

    private final UserService userService;

    @RequestMapping("/list")
    public String showEngineersList(Model model) {
        List<User> engineers = userService.findUserByActiveAndRole("ROLE_ENGINEER");
        if (engineers.isEmpty()) {
            model.addAttribute("message", "Nie dodano jeszcze użytkowników");
        }
        model.addAttribute("engineers", engineers);
        return "engineer/listEngineers";
    }
}
