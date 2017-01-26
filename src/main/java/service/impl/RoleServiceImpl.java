package service.impl;

import dao.ConcernDAO;
import dao.RoleDAO;
import dao.UserDAO;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import service.RoleService;
import util.RoleAbstract;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Flyme on 2017/1/25.
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleDAO roleDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    ConcernDAO concernDAO;

    public boolean updateRole(ModelMap model, Role role, HttpSession session) {
        Role sessionRole = (Role) session.getAttribute("role");
        role.setRoleid(sessionRole.getRoleid());
        role.setType(sessionRole.getType());

        roleDAO.update(role);
        session.setAttribute("role", role);
        return true;
    }


    public boolean searchRole(String name, ModelMap model, HttpSession session) {
        String myid = (String) session.getAttribute("roleid");
        List<RoleAbstract> roles = roleDAO.search(name, myid);
        for (RoleAbstract r : roles) {
            r.setConcerned(concernDAO.hasConcenred(myid, r.getRoleid()));
        }
        model.addAttribute("roles", roles);
        model.addAttribute("title", "搜索结果");
        return true;
    }

    public boolean roleProfile(String roleid, ModelMap model, HttpSession session) {
        String myid = (String) session.getAttribute("roleid");
        Role role = roleDAO.getById(roleid);
        User user = userDAO.getByRoleid(roleid);

        model.addAttribute("concerned", concernDAO.hasConcenred(myid, roleid));
        model.addAttribute("concerncnt", concernDAO.getConcernCnt(roleid));
        model.addAttribute("otheruser", user);
        model.addAttribute("otherrole", role);
        return true;
    }
}
