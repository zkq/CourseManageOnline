package service;

import dao.ConcernDAO;
import dao.RoleDAO;
import dao.UserDAO;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import util.RoleAbstract;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Flyme on 2017/1/22.
 */

public interface RoleService {

    boolean updateRole(ModelMap model, Role role, HttpSession session);

    boolean searchRole(String name, ModelMap model, HttpSession session);

    boolean roleProfile(String roleid, ModelMap model, HttpSession session);

}
