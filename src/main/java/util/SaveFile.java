package util;

import entity.Resource;
import entity.Work;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Flyme on 2017/1/28.
 */
public class SaveFile {

    private static String getMD5(MultipartFile attachment){
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(attachment.getBytes());
            byte[] md5 = digest.digest();
            return new BigInteger(1, md5).toString(16);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //根据work信息计算path
    private static String getPath(String md5) {
        return "/files/" + md5;
    }

    public static boolean saveFile(HttpSession session, MultipartFile attachment, Work work){
        String md5 = getMD5(attachment);
        if(md5 == null){
            return false;
        }
        String contextpath = session.getServletContext().getRealPath("");
        String savepath = contextpath + "/files/" + md5;
        File file = new File(savepath);
        if(!file.exists()){
            file.getParentFile().mkdirs();
            try {
                attachment.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        work.setAttachname(attachment.getOriginalFilename());
        work.setAttachmd5(md5);
        return true;
    }


    public static boolean saveResource(HttpSession session, MultipartFile resourcefile, Resource resource){
        String md5 = getMD5(resourcefile);
        if(md5 == null){
            return false;
        }
        String contextpath = session.getServletContext().getRealPath("");
        String savepath = contextpath + "/resources/" + md5;
        File file = new File(savepath);
        if(!file.exists()){
            file.getParentFile().mkdirs();
            try {
                resourcefile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        resource.setResourcename(resourcefile.getOriginalFilename());
        resource.setResourcemd5(md5);
        return true;
    }

}
