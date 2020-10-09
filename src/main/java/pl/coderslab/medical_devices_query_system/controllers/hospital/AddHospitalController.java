package pl.coderslab.medical_devices_query_system.controllers.hospital;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.domain.model.hospital.Hospital;
import pl.coderslab.medical_devices_query_system.services.HospitalService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/hospital")
public class AddHospitalController {

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
}
