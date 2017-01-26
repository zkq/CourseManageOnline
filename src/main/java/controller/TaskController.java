package controller;

import entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TaskService;
import util.ServiceInvocation;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Flyme on 2017/1/25.
 */

@Controller
@RequestMapping("/task")
public class TaskController extends BaseController{

    @Autowired
    TaskService taskService;

    TaskService taskServiceProxy;

    private void initProxy() {
        if (taskServiceProxy == null) {
            taskServiceProxy = (TaskService) new ServiceInvocation(taskService).getProxy();
        }
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public String delete(ModelMap model, HttpSession session, @RequestParam String id){
        initProxy();
        return responseBodyWrite(taskServiceProxy.delete(model, id), model);
    }


    @RequestMapping("/newedit.do")
    public String  newedit(ModelMap model, HttpSession session, @RequestParam String cid){
        initProxy();
        taskServiceProxy.newEdit(model, cid);
        return "addtask";
    }

    @RequestMapping("/oldedit.do")
    public String oldedit(ModelMap model, HttpSession session, @RequestParam String id){
        initProxy();
        taskServiceProxy.oldEdit(model, id);
        return "addtask";
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public String add(ModelMap model, HttpSession session, Task task){
        initProxy();
        if(task.getTitle().trim().equals("")){
            return "请填写作业标题";
        }
        if(task.getTaskid().equals("")){
            task.setTaskid(null);
        }
        task.setCreattime(new Date());
        task.setDeleted(false);
        return responseBodyWrite(taskServiceProxy.add(model, task), model);
    }

}
