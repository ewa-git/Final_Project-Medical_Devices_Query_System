package pl.coderslab.medical_devices_query_system.controllers.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.coderslab.medical_devices_query_system.exceptions.ElementNotFoundException;
import pl.coderslab.medical_devices_query_system.exceptions.IdsAreNotTheSameException;
import pl.coderslab.medical_devices_query_system.exceptions.UserAlreadyExists;


@ControllerAdvice
@Slf4j
public class CustomExceptionHandlerController {

    @ExceptionHandler(ElementNotFoundException.class)
    public String elementNotFound(Exception e, Model model){
        log.error("Exception: Element not found");
        model.addAttribute("errorMessage", e.getMessage());
        return "error/error";
    }

    @ExceptionHandler(IdsAreNotTheSameException.class)
    public String idsAreNotTheSameException(Exception e, Model model){
        log.error("Exception: Given id's are not the same");
        model.addAttribute("errorMessage", e.getMessage());
        return "error/error";
    }

    @ExceptionHandler(UserAlreadyExists.class)
    public String userAlreadyExists(Exception e, Model model){
        log.error("Exception: User already existis in database");
        model.addAttribute("errorMessage", e.getMessage());
        return "error/error";
    }
}
