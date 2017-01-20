package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import entity.User;
import service.UserService;

/**
 * Created by zkq on 2017/1/11.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(ModelMap model, @ModelAttribute("user") User user, BindingResult result, @RequestBody String body){
        model.addAttribute("msg", "Spring MVC Hello World");
        model.addAttribute("name", "zkq2222");
        return "starter";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(ModelMap model, User user){


        //context.
        return "starter";
    }



}
