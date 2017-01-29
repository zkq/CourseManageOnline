package controller;

import entity.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.WorkService;
import util.ServiceInvocation;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Flyme on 2017/1/27.
 */

@Controller
@RequestMapping(path = "/work")
public class WorkController extends BaseController {


    @Autowired
    WorkService workService;

    WorkService workServiceProxy;

    private void initProxy() {
        if (workServiceProxy == null) {
            workServiceProxy = (WorkService) new ServiceInvocation(workService).getProxy();
        }
    }

    @RequestMapping("/newedit.do")
    public String newEdit(ModelMap model, @RequestParam String taskid) {
        initProxy();
        workServiceProxy.newEdit(model, taskid);
        return "editwork";
    }

    @RequestMapping("/oldedit.do")
    public String oldEdit(ModelMap model, HttpSession session, @RequestParam String taskid) {
        initProxy();
        workServiceProxy.oldEdit(model, session, taskid);
        return "editwork";
    }


    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    @ResponseBody
    public String add(ModelMap model, HttpSession session,
                      @RequestParam(required = false) MultipartFile file, Work work) throws IOException {
        initProxy();
        if (work.getTitle().trim().equals("")) {
            return "请填写作品标题";
        }

        return responseBodyWrite(workServiceProxy.add(model, session, work, file), model);
    }

    @RequestMapping(value = "/detail.do")
    public String detail(ModelMap model, HttpSession session, @RequestParam String taskid, @RequestParam String sid){
        initProxy();
        workServiceProxy.getDetail(model, session, taskid, sid);
        return "workdetail";
    }



    //文件的下载
    @RequestMapping("/download.do")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session, String attachmd5, String attachname) throws IOException{

        byte[] body=null;
        ServletContext servletContext=session.getServletContext();
        ///files/abc.txt：所要下载文件的地址
        InputStream in=servletContext.getResourceAsStream("/files/" + attachmd5);
        body=new byte[in.available()];
        in.read(body);

        HttpHeaders headers=new HttpHeaders();
        //响应头的名字和响应头的值
        String fileName=new String(attachname.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.add("Content-Disposition", "attachment;filename=" + fileName);
        HttpStatus statusCode=HttpStatus.OK;
        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }



    @RequestMapping("/comment.do")
    @ResponseBody
    public String comment(ModelMap model, Work work){
        initProxy();
        if(work.getScore() == 0){
            return "请填写评分";
        }
        return responseBodyWrite(workServiceProxy.comment(model, work), model);

    }
}
