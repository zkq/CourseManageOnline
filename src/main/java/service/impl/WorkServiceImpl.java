package service.impl;

import dao.CourseDAO;
import dao.TaskDAO;
import dao.WorkDAO;
import entity.Course;
import entity.Task;
import entity.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import service.WorkService;
import util.SaveFile;
import util.Names;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Flyme on 2017/1/27.
 */

@Service("workService")
@Transactional
public class WorkServiceImpl implements WorkService {

    @Autowired
    TaskDAO taskDAO;
    @Autowired
    CourseDAO courseDAO;
    @Autowired
    WorkDAO workDAO;

    public void addErrMsg(ModelMap model, String msg) {
        model.addAttribute(Names.ERR_TAG, msg);
    }


    public boolean newEdit(ModelMap model, String taskid) {

        Task task = taskDAO.getById(taskid);
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
        model.addAttribute("taskid", taskid);
        model.addAttribute("title", "提交");
        return true;
    }


    public boolean oldEdit(ModelMap model, HttpSession session, String taskid){
        Task task = taskDAO.getById(taskid);
        if (task == null) {
            addErrMsg(model, "作业不存在");
            return false;
        }

        String sid = session.getAttribute("roleid").toString();
        Work work = workDAO.getById(taskid, sid);
        if(work == null){
            addErrMsg(model, "作品不存在");
            return false;
        }

        Course course = courseDAO.getById(task.getCid());
        if (course == null) {
            addErrMsg(model, "课程不存在");
            return false;
        }

        model.addAttribute("coursename", course.getName());
        model.addAttribute("taskid", taskid);
        model.addAttribute("title", "修改");
        model.addAttribute("work", work);

        return true;
    }

    public boolean add(ModelMap model, HttpSession session,
                       Work work, MultipartFile attachment) throws IOException {

        work.setSid(session.getAttribute("roleid").toString());
        work.setHandtime(new Date());

        if(attachment !=null){
            boolean save = SaveFile.saveFile(session, attachment, work);
            if(!save){
                addErrMsg(model, "保存文件失败");
                return false;
            }
        }
        workDAO.addOrUpdate(work);
        return true;
    }

    public boolean getDone(ModelMap model, HttpSession session, String cid) {
        if(session.getAttribute("type").equals("1"))
            return true;
        List<String> taskids = taskDAO.getAllIdByCid(cid);
        String sid = session.getAttribute("roleid").toString();
        model.addAttribute("donelist", workDAO.getDone(taskids, sid));
        return true;
    }

    public boolean getDetail(ModelMap model, HttpSession session, String taskid, String sid) {
        Work work = workDAO.getById(taskid, sid);
        model.addAttribute("work", work);
        model.addAttribute("taskid", taskid);
        model.addAttribute("sid", sid);
        return true;
    }

    public boolean comment(ModelMap model, Work work){
        workDAO.addComment(work.getTaskid(), work.getSid(),
                work.getTcomment(), work.getScore(), new Date());
        return true;
    }
}
