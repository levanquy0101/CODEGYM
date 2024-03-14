package cg.m4.p1_login.controller;

import cg.m4.p1_login.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Controller
public class HomeController {
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("/home", "user", new User("quoc", "admin"));
    }

    @GetMapping("dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @GetMapping("test")
    public String test(Locale locale){
        request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("haw"));

        return "test";
    }
}
