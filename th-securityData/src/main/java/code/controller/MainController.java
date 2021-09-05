package code.controller;

import code.services.IAccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    IAccountServices iAccountServices;

    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("home", iAccountServices.findAll());
        return modelAndView;
    }

}
