package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ConcernService;
import service.UserService;
import util.ServiceInvocation;

import javax.servlet.http.HttpSession;

/**
 * Created by zkq on 2017/1/11.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ConcernService concernService;

    UserService userServiceProxy;
    ConcernService concernServiceProxy;

    private void initProxy() {
        if (userServiceProxy == null) {
            userServiceProxy = (UserService) new ServiceInvocation(userService).getProxy();
        }
        if (concernServiceProxy == null) {
            concernServiceProxy = (ConcernService) new ServiceInvocation(concernService).getProxy();
        }
    }

    @RequestMapping(path = "/login.do", method = RequestMethod.POST)
    public String login(ModelMap model, User user, HttpSession session) {
        initProxy();
        //用户检查 添加user role到session
        boolean b1 = userServiceProxy.checkUser(user, session, model);
        if (!b1) {
            return "forward:/index.jsp";
        }
        //添加关注到session
        boolean b2 = concernServiceProxy.getConcernCnt(session, model);
        if (!b2) {
            return "forward:/index.jsp";
        }
        return "redirect:/pages/home.jsp";
    }

    @RequestMapping(path = "/logout.do")
    public String logout(ModelMap model, HttpSession session) {
        initProxy();
        //用户注销
        session.invalidate();
        return "redirect:/index.jsp";
    }


    @RequestMapping(path = "/register.do", method = RequestMethod.POST)
    public String register(ModelMap model, @ModelAttribute User user, @RequestParam String type) {
        initProxy();
        boolean b = userServiceProxy.registerUser(model, user, type);
        if (!b) {
            return "forward:/register.jsp";
        }
        model.addAttribute("errMsg", "恭喜您，注册成功");
        return "forward:/index.jsp";
    }

}
