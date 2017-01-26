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
import service.UserService;
import util.Names;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Flyme on 2017/1/25.
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;
    @Autowired
    RoleDAO roleDAO;
    @Autowired
    ConcernDAO concernDAO;

    public void addErrMsg(ModelMap model, String msg){
        model.addAttribute(Names.ERR_TAG, msg);
    }

    /**
     * 判断用户是否存在
     *
     * @param name 用户名
     * @return true 存在 false 不存在
     */
    public boolean isUserNameExist(String name) {
        return userDAO.getByName(name) != null;
    }


    /**
     * 注册用户
     *
     * @param user 用户信息
     * @return
     */
    public boolean registerUser(ModelMap model, User user, String type) {
        if (isUserNameExist(user.getUsername())) {
            addErrMsg(model, "用户名已存在");
            return false;
        }

        //创建对应角色
        Role role = new Role();
        role.setType(type);
        roleDAO.add(role);

        user.setRoleid(role.getRoleid());
        userDAO.add(user);

        return true;
    }

    /**
     * 检查用户登录身份
     * 通过验证则添加user role到session
     *
     * @param user
     * @param session
     * @return
     */
    public boolean checkUser(User user, HttpSession session, ModelMap model) {
        if (!isUserNameExist(user.getUsername())) {
            addErrMsg(model, "用户名不存在");
            return false;
        }

        User dbUser = userDAO.getByName(user.getUsername());
        if (!dbUser.getPassword().equals(user.getPassword())) {
            addErrMsg(model, "密码错误");
            return false;
        }

        user.setLastlogintime(dbUser.getLastlogintime());
        user.setUid(dbUser.getUid());
        user.setRoleid(dbUser.getRoleid());


        Role role = roleDAO.getById(user.getRoleid());
        if (role == null) {
            addErrMsg(model, "未分配角色");
            return false;
        }

        session.setAttribute("user", user);
        session.setAttribute("role", role);
        session.setAttribute("type", role.getType());
        session.setAttribute("roleid", role.getRoleid());

        dbUser.setLastlogintime(new Date());
        return true;
    }
}
