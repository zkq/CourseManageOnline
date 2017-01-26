package service;

import entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

/**
 * Created by Flyme on 2017/1/20.
 */

@Service("userService")
@Transactional
public interface UserService {

    void addErrMsg(ModelMap model, String msg);
    /**
     * 判断用户是否存在
     *
     * @param name 用户名
     * @return true 存在 false 不存在
     */
    boolean isUserNameExist(String name);


    /**
     * 注册用户
     *
     * @param user 用户信息
     * @return
     */
    boolean registerUser(ModelMap model, User user, String type);

    /**
     * 检查用户登录身份
     * 通过验证则添加user role到session
     *
     * @param user
     * @param session
     * @return
     */
    boolean checkUser(User user, HttpSession session, ModelMap model);
}
