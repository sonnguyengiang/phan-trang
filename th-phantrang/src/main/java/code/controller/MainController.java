package code.controller;

import code.model.District;
import code.services.IDistrictServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    IDistrictServices iDistrictServices;



    @RequestMapping("/home")
    public ModelAndView home(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("home", iDistrictServices.findAll(PageRequest.of(page,5)));
        return modelAndView;
    }
}
