package pl.coderslab.medical_devices_query_system.controllers.system;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.domain.model.system.System;
import pl.coderslab.medical_devices_query_system.services.SystemService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/system")
public class InactiveSystemLisstController {

    private final SystemService systemService;

    @RequestMapping("/inactive/list")
    public String showInactiveSystemList(Model model) {
        List<System> nonActiveSystem = systemService.findAllByNotActive();
        if (nonActiveSystem.isEmpty()) {
            model.addAttribute("message", "Lista nieaktywnych systemów jest pusta");
        }
        model.addAttribute("inactiveSystems", systemService.findAllByNotActive());
        return "system/inactiveList";
    }
}
