package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zkq on 2017/1/11.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(ModelMap model){
        model.addAttribute("msg", "Spring MVC Hello World");
        model.addAttribute("name", "zkq2222");
        return "starter";
    }
}
