package pl.coderslab.medical_devices_query_system.hospital;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.medical_devices_query_system.user.model.User;
import pl.coderslab.medical_devices_query_system.user.reposiories.UserRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/hospital")
@Slf4j
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
        return "redirect:/hospital/list";
    }

    @GetMapping("/list")
    public String showHospitalList(Principal principal, Model model){
        User user = userRepository.findUserByEmail(principal.getName());
        model.addAttribute("hospitalList", hospitalRepository.findAllByActiveAndManagerId(user.getId()));
        return "hospital/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditFormHospital(@PathVariable long id, Model model){
        Optional<Hospital> hospital = hospitalRepository.findHospitalById(id);
        if(!hospital.isPresent()){
            model.addAttribute("errorMessage", "Nie odnaleziono takiego szpitala");
            return "error/error";
        }
        model.addAttribute("hospital", hospital.get());
        return "hospital/addHospital";
    }

    @PostMapping("/edit/{id}")
    public String editHospital(@PathVariable long id,
                               Model model,
                               @Valid Hospital hospital,
                               BindingResult result){
        if(hospital.getId() != id){
            model.addAttribute("errorMessage", "ID szpitala się nie zgadza");
        }
        if(result.hasErrors()){
            return "hospital/addHospital";
        }
        hospitalRepository.save(hospital);
        return "redirect:/hospital/list";
    }
}
