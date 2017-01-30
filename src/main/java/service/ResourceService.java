package service;

import entity.Resource;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * Created by Flyme on 2017/1/29.
 */
public interface ResourceService {

    boolean getMyCreats(ModelMap model, HttpSession session);

    boolean getMyDownloads(ModelMap model, HttpSession session);

    boolean add(ModelMap model, HttpSession session, Resource resource, MultipartFile file);

    boolean newEdit(ModelMap model, HttpSession session, String cid);

    boolean oldEdit(ModelMap model, HttpSession session, String rid);

    boolean getAllByCid(ModelMap model, String cid);

    boolean delete(ModelMap model, String id);

    boolean getByCidSid(ModelMap model, HttpSession session, String cid) ;

    boolean recordDownload(ModelMap model, HttpSession session, String resmd5);
}
