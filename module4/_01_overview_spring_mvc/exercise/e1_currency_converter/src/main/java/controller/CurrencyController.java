package controller;

import model.Cunrrency;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyController {
    @GetMapping
    public String home(){
        return "home";
    }

    @PostMapping("convert")
    public ModelAndView convert(Cunrrency cunrrency){
        ModelAndView modelAndView= new ModelAndView("detail");
        double result= cunrrency.getUsd() * cunrrency.getRate();
        modelAndView.addObject("result", String.format("%.2f", result));
        return modelAndView;
    }
}
