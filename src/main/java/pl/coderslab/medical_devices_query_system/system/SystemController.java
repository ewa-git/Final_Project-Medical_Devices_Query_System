package pl.coderslab.medical_devices_query_system.system;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.medical_devices_query_system.customization.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.customization.exceptions.IdsAreNotTheSameException;
import pl.coderslab.medical_devices_query_system.user.model.User;
import pl.coderslab.medical_devices_query_system.user.services.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/system")
public class SystemController {

    private final UserService userService;
    private final SystemService systemService;

    @ModelAttribute("loggedUser")
    public User showUser(Principal principal) {
        return userService.findUserByEmail(principal.getName());
    }

    @ModelAttribute("type")
    public List<String> systemTypes(){
        List<String> systemTypeList = new ArrayList<>();
        systemTypeList.add(SystemType.X_RAY.toString());
        systemTypeList.add(SystemType.COMPUTER_TOMOGRAPHY.toString());
        systemTypeList.add(SystemType.MAGNETIC_RESONANCE.toString());
        return systemTypeList;
    }

    @GetMapping("/add")
    public String showAddSystemForm(Model model){
        model.addAttribute("system", new System());
        return "system/addSystem";
    }

    @PostMapping("/add")
    public String addSystem(@Valid System system, BindingResult result){
        if(result.hasErrors()){
            return "system/addSystem";
        }
        systemService.saveSystem(system);
        return "redirect:/system/active/list";
    }

    @RequestMapping("/active/list")
    public String showActiveSystemList(Model model){
        List<System> activeSystemList = systemService.findAllByActive();
        if (activeSystemList.isEmpty()){
            model.addAttribute("message", "Nie dodano jeszcze systemów");
        }
        model.addAttribute("activeSystems", systemService.findAllByActive());
        return "system/activeList";
    }

    @GetMapping("/edit/{id}")
    public String showEditFormSystem(@PathVariable long id, Model model){
        Optional<System> system = systemService.findSystemById(id);
        if(!system.isPresent()){
            throw new ElementNotFoundException("Nie odnaleziono systemu o id " + id);
        }
        model.addAttribute("system", system.get());
        return "system/addSystem";
    }

    @PostMapping("/edit/{id}")
    public String editSystem(@PathVariable long id,
                             @Valid System systemFromModel,
                             BindingResult result){
        if(result.hasErrors()){
            return "system/addSystem";
        }
        Optional<System> systemFromDbOptional = systemService.findSystemById(id);
        if(!systemFromDbOptional.isPresent()){
            throw new ElementNotFoundException("Nie odnaleziono systemu o id " + id);
        }
        System systemFromDb = systemFromDbOptional.get();
        if(systemFromDb.getId() != systemFromModel.getId()){
            throw new IdsAreNotTheSameException("Id podane w adresie nie zgadza się z tym z modelu");
        }

        systemService.updateSystem(systemFromModel, systemFromDb);
        return "redirect:/system/active/list";
    }

    @PostMapping("/remove")
    public String deactivateSystem(@RequestParam long id){
        Optional<System> system = systemService.findSystemById(id);
        if(!system.isPresent()){
            throw new ElementNotFoundException("Nie odnaleziono systemu o id " + id);
        }
        systemService.deactivateSystem(system.get());
        return "redirect:/system/inactive/list";
    }

    @RequestMapping("/inactive/list")
    public String showInactiveSystemList(Model model){
        List<System> nonActiveSystem = systemService.findAllByNotActive();
        if(nonActiveSystem.isEmpty()){
            model.addAttribute("message", "Lista nieaktywnych systemów jest pusta");
        }
        model.addAttribute("inactiveSystems", systemService.findAllByNotActive());
        return "system/inactiveList";
    }

    @RequestMapping("/details/{id}")
    public String showDetailsSystem(@PathVariable long id, Model model){
        Optional<System> system = systemService.findSystemById(id);
        if(!system.isPresent()){
            throw new ElementNotFoundException("Nie odnaleziono systemu o id " + id);
        }
        model.addAttribute("system", system.get());
        return "system/details";
    }

    @RequestMapping("/activate/{id}")
    public String activateSystem(@PathVariable long id){
        Optional<System> system = systemService.findSystemById(id);
        if(!system.isPresent()){
            throw new ElementNotFoundException("Nie odnaleziono systemu o id " + id);
        }
        systemService.activateSystem(system.get());
        return "redirect:/system/active/list";
    }

}
