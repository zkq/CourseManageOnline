package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MessageService;
import util.ServiceInvocation;

import javax.servlet.http.HttpSession;

/**
 * Created by Flyme on 2017/1/30.
 */

@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {

    @Autowired
    MessageService messageService;

    MessageService messageServiceProxy;

    private void initProxy(){
        if (messageServiceProxy == null) {
            messageServiceProxy = (MessageService) new ServiceInvocation(messageService).getProxy();
        }
    }

    @RequestMapping("/my.do")
    public String my(ModelMap model, HttpSession session){
        initProxy();
        messageServiceProxy.getMyAll(model, session);
        return "mymessagelist";
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public String delete(ModelMap model, HttpSession session, String mid){
        initProxy();
        return responseBodyWrite(messageServiceProxy.delete(model, mid), model);
    }
}
