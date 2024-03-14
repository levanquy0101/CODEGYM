package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.CustomerServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
    //    private CustomerService customerService = CustomerServiceFactory.getInstance();


//    @Autowired
//    private CustomerService customerService;
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customers")
//    public String showList(HttpServletRequest request) {
//        List<Customer> customers = customerService.findAll();
//        request.setAttribute("customers", customers);
//        return "customers/list.jsp";
//    }
//    public String showList(Model model) {
//        List<Customer> customers = customerService.findAll();
//        model.addAttribute("customers", customers);
//        return "customers/list.jsp";
//    }
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list.jsp");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/customer/{id}")
    public ModelAndView showDetail(@PathVariable("id") Long id){
        ModelAndView modelAndView= new ModelAndView("../customers/info.jsp");
        Customer customer= customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
}
