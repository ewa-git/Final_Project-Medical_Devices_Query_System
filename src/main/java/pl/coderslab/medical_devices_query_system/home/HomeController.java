package pl.coderslab.medical_devices_query_system.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String hello(){
        return "home";
    }
}
