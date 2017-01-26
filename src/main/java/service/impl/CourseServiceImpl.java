package service.impl;

import dao.CourseDAO;
import entity.Course;
import entity.Selectc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import service.CourseService;
import util.CourseAbstract;
import util.CourseDetail;
import util.GenerateCode;
import util.Names;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Flyme on 2017/1/25.
 */


@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDAO courseDAO;

    public void addErrMsg(ModelMap model, String msg) {
        model.addAttribute(Names.ERR_TAG, msg);
    }

    public boolean add(Course course, HttpSession session) {
        String code;
        while (courseDAO.codeExist(code = GenerateCode.randomCode(5))) ;

        course.setCode(code);
        course.setCreattime(new Date());
        course.setTid(session.getAttribute(Names.ROLE_ID).toString());
        courseDAO.add(course);

        return true;
    }

    public boolean exist(ModelMap model, String code) {
        if (!courseDAO.codeExist(code)) {
            addErrMsg(model, "课程不存在");
            return false;
        }
        return true;
    }

    public boolean getList(HttpSession session) {
        String id = session.getAttribute(Names.ROLE_ID).toString();
        String type = session.getAttribute("type").toString();
        List<CourseAbstract> courses = null;
        if (type.equals("1")) {
            courses = courseDAO.getTeacherCourses(id);
        } else {
            List<String> ids = courseDAO.getStudentCourseIds(id);
            courses = courseDAO.getCoursesByIds(ids);
        }
        session.setAttribute("courses", courses);
        return true;

    }

    public boolean getDetail(ModelMap model, HttpSession session, String id, String code) {
        String myid = session.getAttribute("roleid").toString();
        CourseDetail courseDetail;
        if (id != null) {
            courseDetail = courseDAO.getDetailById(id);
        } else if (code != null) {
            courseDetail = courseDAO.getDetailByCode(code);
        } else {
            addErrMsg(model, "未提供查询条件");
            return false;
        }

        if (courseDetail == null) {
            addErrMsg(model, "没有该课程信息");
            return false;
        }

        String type = session.getAttribute("type").toString();
        if (type.equals("2")) {
            Selectc select = courseDAO.getSelectInfo(myid, courseDetail.getCid());
            if (select != null) {
                courseDetail.setHasjoined(true);
                courseDetail.setJointime(select.getSelecttime());
            } else {
                courseDetail.setHasjoined(false);
            }
        }
        model.addAttribute("courseDetail", courseDetail);

        return true;
    }



    public boolean join(ModelMap model, HttpSession session, String id) {
        String roleid = session.getAttribute("roleid").toString();
        Course course = courseDAO.getById(id);
        if(courseDAO.hasJoined(roleid, course.getCid())){
            addErrMsg(model, "已经加入该课程");
            return false;
        }

        Date current = new Date();
        if (current.after(course.getJoinendtime())) {
            addErrMsg(model, "课程加入已截止");
            return false;
        }
        courseDAO.join(roleid, course.getCid(), current);
        return true;
    }

    public boolean exit(ModelMap model, HttpSession session, String id) {
        String roleid = session.getAttribute("roleid").toString();
        courseDAO.delete(roleid, id);
        return true;
    }
}
