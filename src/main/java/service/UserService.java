package service;

import dao.RoleDAO;
import dao.UserDAO;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.ErrMsg;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Flyme on 2017/1/20.
 */

@Service("userService")
@Transactional
public class UserService {


    @Autowired
    UserDAO userDAO;
    @Autowired
    RoleDAO roleDAO;

    /**
     * 判断用户是否存在
     * @param name 用户名
     * @return true 存在 false 不存在
     */
    public boolean isUserNameExist(String name){
        return userDAO.getByName(name) != null;
    }


    /**
     * 注册用户
     * @param user 用户信息
     * @return null 注册成功  ErrMsg 不成功，包含错误信息
     */
    public ErrMsg registerUser(User user, String type) {
        ErrMsg msg = new ErrMsg();
        if (isUserNameExist(user.getUsername())) {
            msg.errMsg = "用户名已存在";
            return msg;
        }
        try{
            //创建对应角色
            Role role = new Role();
            role.setType(type);
            roleDAO.add(role);

            user.setRoleid(role.getRoleid());
            userDAO.add(user);
        }catch (Exception e){
            e.printStackTrace();
            msg.errMsg = "创建新用户失败";
            return msg;
        }
        return null;
    }

    /**
     * 检查用户登录身份
     * @param user
     * @param session
     * @return
     */
    public ErrMsg checkUser(User user, HttpSession session){
        ErrMsg msg = new ErrMsg();
        if (!isUserNameExist(user.getUsername())) {
            msg.errMsg = "用户名不存在";
            return msg;
        }

        User dbUser = userDAO.getByName(user.getUsername());
        if(dbUser.getPassword().equals(user.getPassword())){
            user.setLastlogintime(dbUser.getLastlogintime());
            user.setUid(dbUser.getUid());
            user.setRoleid(dbUser.getRoleid());
            session.setAttribute("user", user);

            Role role = roleDAO.getById(user.getRoleid());
            if(role == null){
                msg.errMsg = "未分配角色";
                return msg;
            }
            session.setAttribute("role", role);

            dbUser.setLastlogintime(new Date());
            userDAO.update(dbUser);
            return null;
        }else{
            msg.errMsg = "密码错误";
            return msg;
        }
    }


    public ErrMsg updateRole(Role role, HttpSession session){
        ErrMsg msg = new ErrMsg();

        Role sessionRole = (Role) session.getAttribute("role");
        role.setRoleid(sessionRole.getRoleid());
        role.setType(sessionRole.getType());

        try{
            roleDAO.update(role);
            return null;
        }catch (Exception e){
            e.printStackTrace();
            msg.errMsg = "更新资料失败";
            return msg;
        }
    }
}
