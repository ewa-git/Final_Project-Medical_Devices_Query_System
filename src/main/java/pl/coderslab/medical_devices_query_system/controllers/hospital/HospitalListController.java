package pl.coderslab.medical_devices_query_system.controllers.hospital;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.domain.model.hospital.Hospital;
import pl.coderslab.medical_devices_query_system.domain.model.user.User;
import pl.coderslab.medical_devices_query_system.services.HospitalService;
import pl.coderslab.medical_devices_query_system.services.UserService;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/hospital")
public class HospitalListController {

    private final UserService userService;
    private final HospitalService hospitalService;

    @GetMapping("/list")
    public String showHospitalList(Principal principal, Model model) {
        User user = userService.findUserByEmail(principal.getName());
        List<Hospital> hospitals = hospitalService.findAllByActiveAndManagerId(user.getId());
        if (hospitals.isEmpty()) {
            model.addAttribute("message", "Nie dodano jeszcze szpitali");
        }
        model.addAttribute("hospitalList", hospitals);
        return "hospital/list";
    }

}
