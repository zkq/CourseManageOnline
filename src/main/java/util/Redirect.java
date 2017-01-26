package util;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Flyme on 2017/1/23.
 */
public class Redirect {

    public static void iframeToIndex(){

    }

    public static void iframeToHome(HttpServletResponse response){
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        out.println("<html>");
        out.println("<script>");
        out.println("window.open ('/pages/home.jsp','_top')");
        out.println("</script>");
        out.println("</html>");
    }
}
