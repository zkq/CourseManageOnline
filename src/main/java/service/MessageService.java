package service;

import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

/**
 * Created by Flyme on 2017/1/30.
 */
public interface MessageService {

    boolean getMyAll(ModelMap model, HttpSession session);


    boolean delete(ModelMap model, String mid);
}
