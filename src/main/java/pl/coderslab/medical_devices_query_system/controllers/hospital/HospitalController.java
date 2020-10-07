package pl.coderslab.medical_devices_query_system.controllers.hospital;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.medical_devices_query_system.customization.exceptions.exception.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.customization.exceptions.exception.IdsAreNotTheSameException;
import pl.coderslab.medical_devices_query_system.services.HospitalService;
import pl.coderslab.medical_devices_query_system.model.hospital.Hospital;
import pl.coderslab.medical_devices_query_system.model.user.User;
import pl.coderslab.medical_devices_query_system.services.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/hospital")
@Slf4j
public class HospitalController {

    private final UserService userService;
    private final HospitalService hospitalService;




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
        hospitalService.saveHospital(hospital);
        return "redirect:/hospital/list";
    }

    @GetMapping("/list")
    public String showHospitalList(Principal principal, Model model) {
        User user = userService.findUserByEmail(principal.getName());
        List<Hospital> hospitals = hospitalService.findAllByActiveAndManagerId(user.getId());
        if(hospitals.isEmpty()){
            model.addAttribute("message", "Nie dodano jeszcze szpitali");
        }
        model.addAttribute("hospitalList", hospitals);
        return "hospital/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditFormHospital(@PathVariable long id, Model model) {
        Optional<Hospital> hospital = hospitalService.findHospitalById(id);
        if (!hospital.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono szpitala o id " + id);
        }
        model.addAttribute("hospital", hospital.get());
        return "hospital/addHospital";
    }

    @PostMapping("/edit/{id}")
    public String editHospital(@PathVariable long id,
                               @Valid Hospital hospitalFromModel,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "hospital/addHospital";
        }
        Optional<Hospital> hospitalFromDbOptional = hospitalService.findHospitalById(id);
        if (!hospitalFromDbOptional.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono szpitala o id " + id);
        }
        Hospital hospitalFromDb = hospitalFromDbOptional.get();
        if (hospitalFromModel.getId() != hospitalFromDb.getId()) {
            throw new IdsAreNotTheSameException("Id podane w adresie nie zgadza się z tym z modelu");
        }
             hospitalService.editHospital(hospitalFromModel, hospitalFromDb);
        return "redirect:/hospital/list";
    }

    @PostMapping("/remove")
    public String removeHospital(@RequestParam long id) {
        Optional<Hospital> hospital = hospitalService.findHospitalById(id);
        if (!hospital.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono szpitala o id " + id);
        }
        hospitalService.deleteHospital(hospital.get());
        return "redirect:/hospital/list";
    }




}
