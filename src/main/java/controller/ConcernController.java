package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ConcernService;
import service.RoleService;
import util.Names;
import util.ServiceInvocation;

import javax.servlet.http.HttpSession;

/**
 * Created by Flyme on 2017/1/22.
 */

@Controller
@RequestMapping(path = "/concern")
public class ConcernController extends BaseController {

    @Autowired
    ConcernService concernService;

    ConcernService concernServiceProxy;

    private void initProxy() {
        if (concernServiceProxy == null) {
            concernServiceProxy = (ConcernService) new ServiceInvocation(concernService).getProxy();
        }
    }

    @RequestMapping(path = "toggle.do")
    @ResponseBody
    public String toggle(ModelMap model, @RequestParam String id, HttpSession session) {
        initProxy();
        boolean b = concernServiceProxy.toggleconcern(model, id, session);
        if (!b) {
            return model.get(Names.ERR_TAG).toString();
        }
        boolean b2 = concernServiceProxy.getConcernCnt(session, model);
        if (!b) {
            return model.get(Names.ERR_TAG).toString();
        }
        return "";
    }

    @RequestMapping(path = "all.do")
    public String all(ModelMap model, HttpSession session) {
        initProxy();
        concernServiceProxy.getAll(session, model);
        return "rolelist";
    }
}
