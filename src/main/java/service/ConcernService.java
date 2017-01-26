package service;

import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

/**
 * Created by Flyme on 2017/1/22.
 */


public interface ConcernService {

    boolean toggleconcern(ModelMap model, String roleid, HttpSession session);

    boolean getConcernCnt(HttpSession session, ModelMap model);

    boolean getAll(HttpSession session, ModelMap model);
}
