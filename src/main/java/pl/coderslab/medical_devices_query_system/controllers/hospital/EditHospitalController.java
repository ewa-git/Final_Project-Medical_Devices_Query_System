package pl.coderslab.medical_devices_query_system.controllers.hospital;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.exceptions.IdsAreNotTheSameException;
import pl.coderslab.medical_devices_query_system.domain.model.hospital.Hospital;
import pl.coderslab.medical_devices_query_system.services.HospitalService;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/hospital")
public class EditHospitalController {

    private final HospitalService hospitalService;

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
}
