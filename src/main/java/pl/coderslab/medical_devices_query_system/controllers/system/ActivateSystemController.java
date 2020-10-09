package pl.coderslab.medical_devices_query_system.controllers.system;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.domain.model.system.System;
import pl.coderslab.medical_devices_query_system.services.SystemService;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/system")
public class ActivateSystemController {

    private final SystemService systemService;

    @RequestMapping("/activate/{id}")
    public String activateSystem(@PathVariable long id) {
        Optional<System> system = systemService.findSystemById(id);
        if (!system.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono systemu o id " + id);
        }
        systemService.activateSystem(system.get());
        return "redirect:/system/active/list";
    }
}
