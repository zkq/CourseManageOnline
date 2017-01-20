package service;

import dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Flyme on 2017/1/20.
 */

@Service("userService")
@Transactional
public class UserService {

    @Autowired
    UserDAO userDAO;

    public User getUserByName(String username){
        return new User();
    }
}
