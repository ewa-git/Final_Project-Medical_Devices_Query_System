package pl.coderslab.medical_devices_query_system.customization.exceptions;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    public String errorHandler(HttpServletRequest request, Model model) {
        String statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString();
        if ("403".equals(statusCode)) {
            model.addAttribute("errorMessage", "Nie masz uprawnień by wejść na tą stronę");
        } else if ("404".equals(statusCode)) {
            model.addAttribute("errorMessage", "Strona o podanym adresie nie istnieje");
        }
        return "error/error";
    }
}
