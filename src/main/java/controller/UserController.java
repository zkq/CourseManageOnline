package controller;

import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import util.ErrMsg;

import javax.servlet.http.HttpSession;

/**
 * Created by zkq on 2017/1/11.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/login.do", method = RequestMethod.POST)
    public String login(ModelMap model, User user, HttpSession session){
        //用户检查
        ErrMsg msg = userService.checkUser(user, session);
        if(msg != null){
            model.addAttribute("errMsg", msg.errMsg);
            return "forward:/index.jsp";
        }
        return "redirect:/pages/home.jsp";
    }


    @RequestMapping(path = "/register.do", method = RequestMethod.POST)
    public String register(ModelMap model, @ModelAttribute User user, @RequestParam String type){
        ErrMsg msg = userService.registerUser(user, type);

        if(msg != null){
            model.addAttribute("errMsg", msg.errMsg);
            return "forward:/register.jsp";
        }

        model.addAttribute("errMsg", "恭喜您，注册成功");
        return "forward:/index.jsp";
    }

    @RequestMapping(path = "/updaterole.do", method = RequestMethod.POST)
    @ResponseBody
    public String updateRole(ModelMap model, Role role, HttpSession session){
        ErrMsg msg = userService.updateRole(role, session);

        if(msg != null){
            return msg.errMsg;
        }
        session.setAttribute("role", role);
        return "修改成功";
    }
}
