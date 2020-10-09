package pl.coderslab.medical_devices_query_system.controllers.system;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.medical_devices_query_system.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.exceptions.IdsAreNotTheSameException;
import pl.coderslab.medical_devices_query_system.domain.model.system.System;
import pl.coderslab.medical_devices_query_system.domain.model.system.SystemType;
import pl.coderslab.medical_devices_query_system.services.SystemService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/system")
public class EditSystemController {

    private final SystemService systemService;

    @ModelAttribute("type")
    public List<String> systemTypes() {
        List<String> systemTypeList = new ArrayList<>();
        systemTypeList.add(SystemType.X_RAY.toString());
        systemTypeList.add(SystemType.COMPUTER_TOMOGRAPHY.toString());
        systemTypeList.add(SystemType.MAGNETIC_RESONANCE.toString());
        return systemTypeList;
    }

    @GetMapping("/edit/{id}")
    public String showEditFormSystem(@PathVariable long id, Model model) {
        Optional<System> system = systemService.findSystemById(id);
        if (!system.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono systemu o id " + id);
        }
        model.addAttribute("system", system.get());
        return "system/addSystem";
    }

    @PostMapping("/edit/{id}")
    public String editSystem(@PathVariable long id,
                             @Valid System systemFromModel,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "system/addSystem";
        }
        Optional<System> systemFromDbOptional = systemService.findSystemById(id);
        if (!systemFromDbOptional.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono systemu o id " + id);
        }
        System systemFromDb = systemFromDbOptional.get();
        if (systemFromDb.getId() != systemFromModel.getId()) {
            throw new IdsAreNotTheSameException("Id podane w adresie nie zgadza się z tym z modelu");
        }

        systemService.updateSystem(systemFromModel, systemFromDb);
        return "redirect:/system/active/list";
    }
}
