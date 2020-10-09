package pl.coderslab.medical_devices_query_system.controllers.system;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.medical_devices_query_system.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.domain.model.system.System;
import pl.coderslab.medical_devices_query_system.services.SystemService;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/system")
public class DeactivateSystemController {

    private final SystemService systemService;

    @PostMapping("/remove")
    public String deactivateSystem(@RequestParam long id) {
        Optional<System> system = systemService.findSystemById(id);
        if (!system.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono systemu o id " + id);
        }
        systemService.deactivateSystem(system.get());
        return "redirect:/system/inactive/list";
    }
}
