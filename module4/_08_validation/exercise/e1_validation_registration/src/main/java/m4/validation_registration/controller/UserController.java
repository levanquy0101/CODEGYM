package m4.validation_registration.controller;

import m4.validation_registration.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("user", new User());
        return "home";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        new User().validate(user, result);

        if(result.hasErrors()){
            System.out.println(result.getErrorCount());
            return "home";
        }

        model.addAttribute("user", user);
        return "result";
    }
}
