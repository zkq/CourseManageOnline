package service.impl;

import dao.CourseDAO;
import dao.ResourceDAO;
import entity.Course;
import entity.Resource;
import entity.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import service.ResourceService;
import util.Names;
import util.SaveFile;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Flyme on 2017/1/29.
 */

@Service("resourceService")
@Transactional
public class ResourceServceImpl implements ResourceService {

    @Autowired
    CourseDAO courseDAO;

    @Autowired
    ResourceDAO resourceDAO;

    public void addErrMsg(ModelMap model, String msg) {
        model.addAttribute(Names.ERR_TAG, msg);
    }

    public boolean add(ModelMap model, HttpSession session, Resource resource, MultipartFile file) {
        resource.setRoleid(session.getAttribute("roleid").toString());
        resource.setCreattime(new Date());

        if(file !=null){
            boolean save = SaveFile.saveResource(session, file, resource);
            if(!save){
                addErrMsg(model, "保存资源失败");
                return false;
            }
        }
        resourceDAO.saveOrUpdate(resource);
        return true;
    }

    public boolean newEdit(ModelMap model, HttpSession session, String cid) {
        Course course = courseDAO.getById(cid);
        if (course == null) {
            addErrMsg(model, "课程不存在");
            return false;
        }

        model.addAttribute("coursename", course.getName());
        model.addAttribute("cid", cid);
        model.addAttribute("title", "添加");
        return true;
    }

    public boolean oldEdit(ModelMap model, HttpSession session, String rid) {
        Resource resource = resourceDAO.getById(rid);
        if(resource == null){
            addErrMsg(model, "资源不存在");
            return false;
        }

        Course course = courseDAO.getById(resource.getCid());
        if (course == null) {
            addErrMsg(model, "课程不存在");
            return false;
        }

        model.addAttribute("coursename", course.getName());
        model.addAttribute("rid", rid);
        model.addAttribute("title", "修改");
        model.addAttribute("resource", resource);

        return true;
    }

    public boolean getAllByCid(ModelMap model, String cid) {
        List<Resource> resources = resourceDAO.getAllByCid(cid);
        model.addAttribute("resources", resources);
        return true;
    }

    public boolean delete(ModelMap model, String id) {
        resourceDAO.delete(id);
        return true;
    }
}
