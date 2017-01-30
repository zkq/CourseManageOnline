package service.impl;

import dao.ConcernDAO;
import dao.CourseDAO;
import dao.MessageDAO;
import dao.TaskDAO;
import entity.Course;
import entity.Message;
import entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import service.TaskService;
import util.Names;
import util.WorkAbstract;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Flyme on 2017/1/25.
 */

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDAO taskDAO;
    @Autowired
    CourseDAO courseDAO;
    @Autowired
    ConcernDAO concernDAO;
    @Autowired
    MessageDAO messageDAO;

    public void addErrMsg(ModelMap model, String msg) {
        model.addAttribute(Names.ERR_TAG, msg);
    }

    public boolean getAllByCid(ModelMap model, String cid) {
        List<Task> tasks = taskDAO.getAllByCid(cid);
        model.addAttribute("tasks", tasks);
        return true;
    }

    public boolean delete(ModelMap model, String id) {
        Task task = taskDAO.getById(id);
        if (task == null) {
            addErrMsg(model, "作业不存在");
            return false;
        }
        taskDAO.delete(id);
        return true;
    }

    public boolean newEdit(ModelMap model, String cid) {
        Course course = courseDAO.getById(cid);
        if (course == null) {
            addErrMsg(model, "课程不存在");
            return false;
        }
        model.addAttribute("coursename", course.getName());
        model.addAttribute("cid", cid);
        model.addAttribute("title", "发布");
        return true;
    }

    public boolean oldEdit(ModelMap model, String id) {

        Task task = taskDAO.getById(id);
        if (task == null) {
            addErrMsg(model, "作业不存在");
            return false;
        }
        Course course = courseDAO.getById(task.getCid());
        if (course == null) {
            addErrMsg(model, "课程不存在");
            return false;
        }
        model.addAttribute("coursename", course.getName());
        model.addAttribute("title", "修改");
        model.addAttribute("cid", task.getCid());
        model.addAttribute("task", task);
        return true;
    }

    public boolean add(ModelMap model, HttpSession session, Task task) {
        taskDAO.addOrUpdate(task);

        //发布作业发出通知
        String tid = session.getAttribute("roleid").toString();
        List<String> sids = concernDAO.getAllId(tid);
        for (String sid : sids) {
            Message message = new Message();
            message.setSid(sid);
            message.setTid(tid);
            message.setActiontype("2");
            message.setActiontime(task.getCreattime());
            message.setContent(task.getTitle());
            message.setDeleted(false);
            messageDAO.add(message);
        }

        return true;
    }

    public boolean getWorkList(ModelMap model, String id) {
        List<WorkAbstract> works = taskDAO.getAllWork(id);
        model.addAttribute("works", works);
        model.addAttribute("taskid", id);
        return true;
    }

}
