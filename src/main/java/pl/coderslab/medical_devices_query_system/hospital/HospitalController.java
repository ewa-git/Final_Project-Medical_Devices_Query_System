package pl.coderslab.medical_devices_query_system.hospital;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.user.model.User;
import pl.coderslab.medical_devices_query_system.user.reposiories.UserRepository;

import javax.validation.Valid;
import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping("/hospital")
public class HospitalController {

    private final HospitalRepository hospitalRepository;
    private final UserRepository userRepository;


    @ModelAttribute("user")
    public User showUser(Principal principal) {
        return userRepository.findUserByEmail(principal.getName());
    }

    @GetMapping("/add")
    public String showAddFormHospital(Model model) {
        model.addAttribute("hospital", new Hospital());
        return "hospital/addHospital";
    }

    @PostMapping("/add")
    public String addHospital(@Valid Hospital hospital, BindingResult result) {
        if (result.hasErrors()) {
            return "hospital/addHospital";
        }
        hospitalRepository.save(hospital);
        return "redirect:/manager/dashboard";
    }


}
