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
public class ActiveSystemListController {

    private final SystemService systemService;

    @RequestMapping("/active/list")
    public String showActiveSystemList(Model model) {
        List<System> activeSystemList = systemService.findAllByActive();
        if (activeSystemList.isEmpty()) {
            model.addAttribute("message", "Nie dodano jeszcze systemów");
        }
        model.addAttribute("activeSystems", systemService.findAllByActive());
        return "system/activeList";
    }
}
