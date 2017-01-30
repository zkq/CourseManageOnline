package controller;

import entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.ResourceService;
import util.ServiceInvocation;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Flyme on 2017/1/29.
 */

@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController {


    @Autowired
    ResourceService resourceService;

    ResourceService resourceServiceProxy;

    private void initProxy(){
        if(resourceServiceProxy == null){
            resourceServiceProxy = (ResourceService) new ServiceInvocation(resourceService).getProxy();
        }
    }

    @RequestMapping("/my.do")
    public String my(ModelMap model, HttpSession session){
        initProxy();
        resourceServiceProxy.getMyCreats(model, session);
        resourceServiceProxy.getMyDownloads(model, session);
        return "myresourcelist";
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public String delete(ModelMap model, HttpSession session, @RequestParam String id){
        initProxy();
        return responseBodyWrite(resourceServiceProxy.delete(model, id), model);
    }


    @RequestMapping("/newedit.do")
    public String newedit(ModelMap model, HttpSession session, @RequestParam String cid){
        initProxy();

        resourceServiceProxy.newEdit(model, session, cid);
        return "editresource";
    }

    @RequestMapping("/oldedit.do")
    public String oldEdit(ModelMap model, HttpSession session, @RequestParam String rid){
        initProxy();
        resourceServiceProxy.oldEdit(model, session, rid);
        return "editresource";
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public String add(ModelMap model, HttpSession session, Resource resource, @RequestParam MultipartFile file){
        initProxy();
        if(resource.getRid().equals("")){
            resource.setRid(null);
        }
        return  responseBodyWrite(resourceServiceProxy.add(model, session, resource, file), model);
    }


    //文件的下载
    @RequestMapping("/download.do")
    public ResponseEntity<byte[]> testResponseEntity(ModelMap model, HttpSession session, String resourcemd5, String resourcename) throws IOException {
        initProxy();
        resourceServiceProxy.recordDownload(model, session, resourcemd5);

        byte[] body=null;
        ServletContext servletContext=session.getServletContext();
        ///files/abc.txt：所要下载文件的地址
        InputStream in=servletContext.getResourceAsStream("/resources/" + resourcemd5);
        body=new byte[in.available()];
        in.read(body);

        HttpHeaders headers=new HttpHeaders();
        //响应头的名字和响应头的值
        String fileName=new String(resourcename.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.add("Content-Disposition", "attachment;filename=" + fileName);
        HttpStatus statusCode=HttpStatus.OK;
        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }

}
