package controller;

import dao.RoleDAO;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.RoleService;
import util.Names;
import util.ServiceInvocation;

import javax.servlet.http.HttpSession;

/**
 * Created by Flyme on 2017/1/22.
 */

@Controller
@RequestMapping(path = "/role")
public class RoleController extends BaseController{

    @Autowired
    RoleService roleService;

    RoleService roleServiceProxy;
    private void initProxy(){
        if(roleServiceProxy == null){
            roleServiceProxy = (RoleService) new ServiceInvocation(roleService).getProxy();
        }
    }


    @RequestMapping(path = "/update.do", method = RequestMethod.POST)
    @ResponseBody
    public String updateRole(ModelMap model, Role role, HttpSession session){
        initProxy();
        return responseBodyWrite(roleServiceProxy.updateRole(model, role, session), model);
    }

    @RequestMapping(path = "/search.do")
    public String search(ModelMap model, @RequestParam String name, HttpSession session){
        initProxy();
        roleServiceProxy.searchRole(name, model, session);
        return "rolelist";
    }

    @RequestMapping(path = "/profile.do")
    public String profile(ModelMap model, @RequestParam String id, HttpSession session){
        initProxy();
        roleServiceProxy.roleProfile(id, model, session);
        return "otherprofile";
    }

}
