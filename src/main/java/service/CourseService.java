package service;

import dao.CourseDAO;
import entity.Course;
import entity.Selectc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import util.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Flyme on 2017/1/23.
 */

public interface CourseService {


     void addErrMsg(ModelMap model, String msg);

     boolean add(Course course, HttpSession session);

     boolean exist(ModelMap model, String code);

     boolean getList(HttpSession session) ;

     boolean getDetail(ModelMap model, HttpSession session, String id, String code) ;

     boolean join(ModelMap model, HttpSession session, String id) ;

     boolean exit(ModelMap model, HttpSession session, String code) ;
}
