package pl.coderslab.medical_devices_query_system.controllers.hospital;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.medical_devices_query_system.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.domain.model.hospital.Hospital;
import pl.coderslab.medical_devices_query_system.services.HospitalService;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/hospital")
public class RemoveHospitalController {

    private final HospitalService hospitalService;

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
