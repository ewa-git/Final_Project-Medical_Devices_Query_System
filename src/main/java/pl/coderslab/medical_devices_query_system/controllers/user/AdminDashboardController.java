package pl.coderslab.medical_devices_query_system.controllers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.model.user.User;
import pl.coderslab.medical_devices_query_system.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminDashboardController {


    @RequestMapping("/dashboard")
    public String showAdminDashboard(){
        return "dashboardes/adminDashboard";
    }
}
