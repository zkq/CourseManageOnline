package service;

import entity.Work;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by Flyme on 2017/1/27.
 */
public interface WorkService {

    boolean newEdit(ModelMap model, String taskid);

    boolean oldEdit(ModelMap model, HttpSession session, String taskid);

    boolean add(ModelMap model, HttpSession session, Work work, MultipartFile attachment) throws IOException;

    boolean getDone(ModelMap model, HttpSession session, String cid);

    boolean getDetail(ModelMap model, HttpSession session, String taskid, String sid);

    boolean comment(ModelMap model, Work work);
}
