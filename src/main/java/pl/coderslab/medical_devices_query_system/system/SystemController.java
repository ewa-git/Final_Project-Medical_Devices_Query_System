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

    @ModelAttribute("user")
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
                             @Valid System system,
                             BindingResult result){
        if(id!=system.getId()){
            throw new IdsAreNotTheSameException("Id podane w adresie nie zgadza się z tym z modelu");
        }
        if(result.hasErrors()){
            return "system/addSystem";
        }
        systemService.updateSystem(system);
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
        systemService.updateSystem(system.get());
        return "redirect:/system/active/list";
    }

}
