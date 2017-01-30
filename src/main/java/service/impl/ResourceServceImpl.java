package service.impl;

import dao.ConcernDAO;
import dao.CourseDAO;
import dao.MessageDAO;
import dao.ResourceDAO;
import entity.Course;
import entity.Message;
import entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import service.ResourceService;
import util.Names;
import util.ResourceDetail;
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
    @Autowired
    ConcernDAO concernDAO;
    @Autowired
    MessageDAO messageDAO;

    public void addErrMsg(ModelMap model, String msg) {
        model.addAttribute(Names.ERR_TAG, msg);
    }

    public boolean getMyCreats(ModelMap model, HttpSession session) {
        String roleid = session.getAttribute("roleid").toString();
        List<ResourceDetail> mycreats = resourceDAO.getByRoleid(roleid);
        model.addAttribute("mycreats", mycreats);
        return true;
    }

    public boolean getMyDownloads(ModelMap model, HttpSession session) {
        String roleid = session.getAttribute("roleid").toString();
        List<ResourceDetail> mydownloads = resourceDAO.getDownloads(roleid);
        model.addAttribute("mydownloads", mydownloads);
        return true;
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

        //发布资源通知
        String tid = session.getAttribute("roleid").toString();
        List<String> sids = concernDAO.getAllId(tid);
        for (String sid : sids) {
            Message message = new Message();
            message.setSid(sid);
            message.setTid(tid);
            String messageType = Integer.parseInt(resource.getType()) + 2 + "";
            message.setActiontype(messageType);
            message.setActiontime(resource.getCreattime());
            message.setContent(resource.getResourcemd5() + " " + resource.getResourcename());
            message.setDeleted(false);
            messageDAO.add(message);
        }

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
        List<ResourceDetail> resources = resourceDAO.getAllByCid(cid);
        model.addAttribute("resources", resources);
        return true;
    }

    public boolean getByCidSid(ModelMap model, HttpSession session, String cid) {
        String roleid = session.getAttribute("roleid").toString();
        List<String> myres = resourceDAO.getIdsByRoleidCid(roleid, cid);
        model.addAttribute("myreslist", myres);
        return true;
    }

    public boolean recordDownload(ModelMap model, HttpSession session, String resmd5) {
        Resource resource = resourceDAO.getByMd5(resmd5);
        if (resource == null) {
            return false;
        }

        String rid = resource.getRid();
        String roleid = session.getAttribute("roleid").toString();
        if (resourceDAO.downExist(rid, roleid))
            return true;
        resourceDAO.addDown(rid, roleid);
        return true;
    }

    public boolean delete(ModelMap model, String id) {
        resourceDAO.delete(id);
        return true;
    }
}
