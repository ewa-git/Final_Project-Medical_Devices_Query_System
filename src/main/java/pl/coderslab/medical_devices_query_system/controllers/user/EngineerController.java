package pl.coderslab.medical_devices_query_system.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EngineerController {

    @RequestMapping("/engineer/dashboard")
    public String showEngineerDashboard(){
        return "dashboardes/engineerDashboard";
    }


}
