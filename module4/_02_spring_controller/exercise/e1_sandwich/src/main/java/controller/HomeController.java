package controller;

import model.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping
    public String home(Model model){
//        Test test= new Test();
//        model.addAttribute("test", test);
        return "index";
    }

    @PostMapping("save")
    public ModelAndView save(String condiment){
        ModelAndView modelAndView= new ModelAndView("index", "condiment", condiment);
        return modelAndView;
    }

//    @PostMapping("submit")
//    public ModelAndView submit(String c){
//        ModelAndView modelAndView= new ModelAndView("index", "condiment", c);
//        modelAndView.addObject("test", new Test());
//        return modelAndView;
//    }
//
//    @ModelAttribute("condiments")
//    public List<String> condiments()
//    {
//        return Arrays.asList("Lettuce", "Tomato", "Mustard", "Sprouts");
//    }
}
