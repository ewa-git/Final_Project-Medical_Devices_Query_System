package pl.coderslab.medical_devices_query_system.controllers.system;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.medical_devices_query_system.domain.model.system.System;
import pl.coderslab.medical_devices_query_system.domain.model.system.SystemType;
import pl.coderslab.medical_devices_query_system.services.SystemService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/system")
public class AddSystemController {

    private final SystemService systemService;

    @ModelAttribute("type")
    public List<String> systemTypes() {
        List<String> systemTypeList = new ArrayList<>();
        systemTypeList.add(SystemType.X_RAY.toString());
        systemTypeList.add(SystemType.COMPUTER_TOMOGRAPHY.toString());
        systemTypeList.add(SystemType.MAGNETIC_RESONANCE.toString());
        return systemTypeList;
    }

    @GetMapping("/add")
    public String showAddSystemForm(Model model) {
        model.addAttribute("system", new System());
        return "system/addSystem";
    }

    @PostMapping("/add")
    public String addSystem(@Valid System system, BindingResult result) {
        if (result.hasErrors()) {
            return "system/addSystem";
        }
        systemService.saveSystem(system);
        return "redirect:/system/active/list";
    }
}
