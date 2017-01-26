package service.impl;

import dao.ConcernDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import service.ConcernService;
import util.RoleAbstract;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Flyme on 2017/1/25.
 */

@Service("concernService")
@Transactional
public class ConcernServiceImpl implements ConcernService {

    @Autowired
    ConcernDAO concernDAO;

    public boolean toggleconcern(ModelMap model, String roleid, HttpSession session) {
        String myid = (String) session.getAttribute("roleid");
        if (concernDAO.hasConcenred(myid, roleid)) {
            concernDAO.cancelConcern(myid, roleid);
        } else {
            concernDAO.addConcern(myid, roleid);
        }
        return true;
    }

    public boolean getConcernCnt(HttpSession session, ModelMap model) {
        String myid = (String) session.getAttribute("roleid");
        int concerncnt = concernDAO.getConcernCnt(myid);
        session.setAttribute("concerncnt", concerncnt);
        return true;
    }

    public boolean getAll(HttpSession session, ModelMap model) {
        String myid = (String) session.getAttribute("roleid");
        //首先查出所有roleid
        List<String> roleids = concernDAO.getAllId(myid);
        //然后查出所有role 传入model
        List<RoleAbstract> roles = concernDAO.getAllRole(roleids);
        for (RoleAbstract r : roles) {
            r.setConcerned(concernDAO.hasConcenred(myid, r.getRoleid()));
        }
        model.addAttribute("roles", roles);
        if (session.getAttribute("type").equals("1"))
            model.addAttribute("title", "粉丝列表");
        else
            model.addAttribute("title", "关注列表");
        return true;
    }
}
