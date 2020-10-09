package pl.coderslab.medical_devices_query_system.controllers.system;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.domain.model.system.System;
import pl.coderslab.medical_devices_query_system.services.SystemService;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/system")
public class SystemDetailsController {

    private final SystemService systemService;

    @RequestMapping("/details/{id}")
    public String showDetailsSystem(@PathVariable long id, Model model) {
        Optional<System> system = systemService.findSystemById(id);
        if (!system.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono systemu o id " + id);
        }
        model.addAttribute("system", system.get());
        return "system/details";
    }
}
