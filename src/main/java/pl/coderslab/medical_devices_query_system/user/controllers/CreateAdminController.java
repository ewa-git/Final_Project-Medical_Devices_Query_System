package pl.coderslab.medical_devices_query_system.user.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.user.services.UserService;

@Controller
@RequiredArgsConstructor
public class CreateAdminController {

    private final UserService userService;

    @RequestMapping("/create/admin")
    public String createAdmin(){
        userService.createAdmin();
        return "redirect:/login";
    }
}
