package pl.coderslab.medical_devices_query_system.controllers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.medical_devices_query_system.customization.exceptions.exception.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.model.user.User;
import pl.coderslab.medical_devices_query_system.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/engineer")
public class AdminEngineerController {

    private final UserService userService;

    @GetMapping("/add")
    public String showAddFormUser(Model model) {
        model.addAttribute("user", new User());
        return "engineer/addEngineer";
    }

    @PostMapping("/add")
    public String addEngineer(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "engineer/addEngineer";
        }
        userService.createEngineer(user);
        return "redirect:/admin/engineer/list";
    }

    @RequestMapping("/list")
    public String showEngineersList(Model model) {
        List<User> engineers = userService.findUserByActiveAndRole("ROLE_ENGINEER");
        if (engineers.isEmpty()) {
            model.addAttribute("message", "Nie dodano jeszcze użytkowników");
        }
        model.addAttribute("engineers", engineers);
        return "engineer/listEngineers";
    }

/*    @GetMapping("/edit/{id}")
    public String showEditFormEngineer(@PathVariable long id, Model model) {
        Optional<User> engineer = userService.findUserById(id);
        if (!engineer.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono użytkownika o id" + id);
        }
        model.addAttribute("user", engineer.get());
        return "engineer/editEngineer";
    }

    @PostMapping("/edit/{id}")
    public String editEngineer(@PathVariable long id,
                               @Valid User user,
                               BindingResult result) {
        if (id != user.getId()) {
            throw new IdsAreNotTheSameException("Nie odnaleziono systemu o id " + id);
        }
        if(result.hasErrors()){
            return "engineer/editEngineer";
        }
        userService.updateUser(user);
        return "redirect:/admin/engineer/list";
    }*/

    @PostMapping("/remove")
    public String removeEngineer(@RequestParam long id) {
        Optional<User> engineer = userService.findUserById(id);
        if (!engineer.isPresent()) {
            throw new ElementNotFoundException("Nie odnaleziono użytkownika o id" + id);
        }
        userService.deleteUser(engineer.get());
        return "redirect:/admin/engineer/list";
    }
}
