package code.controller;

import code.model.Account;
import code.model.Friend;
import code.services.IAccountServices;
import code.services.IFriendServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    IAccountServices iAccountServices;

    @Autowired
    IFriendServices iFriendServices;

    @ModelAttribute("getUser")
    public Account account(){
        return iAccountServices.findByUsername(getPrincipal());
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }



    @RequestMapping("/friendList")
    public ModelAndView friendList(){
        ModelAndView modelAndView = new ModelAndView("/friendList");
        modelAndView.addObject("home", iAccountServices.findAll());
        modelAndView.addObject("user1", iAccountServices.findIdByUsername(getPrincipal()));
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("detail", iAccountServices.findById(id));
        return modelAndView;
    }

    @GetMapping("/app/{id}")
    public ModelAndView app(@PathVariable long id, @ModelAttribute("detail") Friend friend){
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        Account account = iAccountServices.findByUsername(getPrincipal());
        friend.setId_friend(id);
        friend.setAccount(account);
        iFriendServices.save(friend);
        return modelAndView;
    }

    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("list", iFriendServices.findIdNon_Friend(iAccountServices.findIdByUsername(getPrincipal())));
        return modelAndView;
    }

    // xu li tinh nang ket ban

    @GetMapping("/yes/{id_list}")
    public ModelAndView yes(@PathVariable long id_list){
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        Friend friend = iFriendServices.findById(id_list);
        friend.setStatus(1);
        iFriendServices.save(friend);
        return modelAndView;
    }

    @GetMapping("/no/{id_list}")
    public ModelAndView cancel(@PathVariable long id_list){
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        iFriendServices.delete(iFriendServices.findById(id_list));
        return modelAndView;
    }


}
