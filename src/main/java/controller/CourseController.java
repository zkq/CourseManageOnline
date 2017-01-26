package controller;

import entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ConcernService;
import service.CourseService;
import service.TaskService;
import util.ServiceInvocation;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Flyme on 2017/1/23.
 */


@Controller
@RequestMapping(path = "/course")
public class CourseController extends BaseController {

    @Autowired
    CourseService courseService;
    @Autowired
    TaskService taskService;

    CourseService courseServiceProxy;
    TaskService taskServiceProxy;
    private void initProxy(){
        if(courseServiceProxy == null){
            courseServiceProxy = (CourseService) new ServiceInvocation(courseService).getProxy();
        }
        if(taskServiceProxy == null){
            taskServiceProxy = (TaskService) new ServiceInvocation(taskService).getProxy();
        }
    }


    @RequestMapping(path = "/add.do", method = RequestMethod.POST)
    @ResponseBody
    public String add(ModelMap model, HttpSession session, Course course, @RequestParam String classdate) {
        initProxy();

        if(course.getName().trim().equals("")){
            return "请填写课程名称";
        }

        String[] dates = classdate.split("-");
        if(dates.length != 2){
            return "开课结课日期格式不正确";
        }
        Date startdate, enddate;
        try {
            startdate = new Date(dates[0]);
            enddate = new Date(dates[1]);
        }catch (Exception e){
            e.printStackTrace();
            return "开课结课日期格式不正确";
        }
        if(startdate.after(enddate)){
            return "结课日期不应晚于开课日期";
        }

        course.setStarttime(startdate);
        course.setFinishtime(enddate);

        return responseBodyWrite(courseServiceProxy.add(course, session), model);
    }

    @RequestMapping(path = "/exist.do", method = RequestMethod.POST)
    @ResponseBody
    public String exist(ModelMap model, @RequestParam String code) {
        initProxy();
        return responseBodyWrite(courseServiceProxy.exist(model, code.trim()), model);
    }


    @RequestMapping(path = "/list.do")
    public String list(ModelMap model, HttpSession session) {
        initProxy();
        courseServiceProxy.getList(session);
        return "courselist";
    }


    @RequestMapping(path = "/detail.do")
    public String detail(ModelMap model, HttpSession session, @RequestParam String id) {
        initProxy();
        courseServiceProxy.getDetail(model, session, id, null);
        taskServiceProxy.getAllByCid(model, id);
        return "coursedetail";
    }

    @RequestMapping(path = "/search.do")
    public String search(ModelMap model, HttpSession session, @RequestParam String code) {
        initProxy();
        courseServiceProxy.getDetail(model, session, null, code);
        return "coursedetail";
    }

    @RequestMapping(path = "/join.do")
    @ResponseBody
    public String join(ModelMap model, HttpSession session, @RequestParam String id) {
        initProxy();
        return responseBodyWrite(courseServiceProxy.join(model, session, id), model);
    }

    @RequestMapping(path = "/exit.do")
    @ResponseBody
    public String exit(ModelMap model, HttpSession session, @RequestParam String id) {
        initProxy();
        return responseBodyWrite(courseServiceProxy.exit(model, session, id), model);
    }

}
