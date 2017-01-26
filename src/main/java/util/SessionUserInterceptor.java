package util;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Calendar;

import static java.util.Calendar.HOUR_OF_DAY;

/**
 * Created by Flyme on 2017/1/22.
 */
public class SessionUserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("user") != null){
            return true;
        }

        String dest = request.getParameter("dest");
        if("go".equals(dest)){
            return true;
        }

        //response.sendRedirect("/index.jsp");
        //return false;
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<script>");
        out.println("window.open ('/index.jsp','_top')");
        out.println("</script>");
        out.println("</html>");
        return false;
    }
}
