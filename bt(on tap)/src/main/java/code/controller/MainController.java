package code.controller;


import code.model.ClassRoom;
import code.model.Student;
import code.services.IClassRoomServices;
import code.services.IStudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;


@Controller
public class MainController {

    @Autowired
    IClassRoomServices iClassRoomServices;

    @Autowired
    IStudentServices iStudentServices;

    @ModelAttribute("classList")
    public ArrayList<ClassRoom> classRooms(){
        return iClassRoomServices.fillAll();
    }


    @RequestMapping("/home")
    public ModelAndView home(@RequestParam(defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("home", iStudentServices.findAllPage(PageRequest.of(page, 5, Sort.by("name"))));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/create");
            return modelAndView;
        }
        iStudentServices.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("edit", iStudentServices.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView showEdit(@Valid @ModelAttribute("edit") Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/edit");
            return modelAndView;
        }
        iStudentServices.edit(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id){
        iStudentServices.Delete(iStudentServices.findById(id));
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }

    @RequestMapping("/find")
    public ModelAndView find(@RequestParam(defaultValue = "0") int page, @RequestParam String nameFind){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("home", iStudentServices.findAllNamePage(nameFind, PageRequest.of(page, 5, Sort.by("name"))));
        return modelAndView;
    }

    @RequestMapping("/viewDetail/{id}")
    public ModelAndView view(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("detail", iStudentServices.findById(id));
        return modelAndView;
    }
}
