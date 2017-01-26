package dao;

import entity.Course;
import entity.Selectc;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import util.CourseAbstract;
import util.CourseDetail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Flyme on 2017/1/23.
 */

@Repository
public class CourseDAO extends BaseDAO{

    public void add(Course course){
        initSession();
        session.save(course);
    }

    public boolean codeExist(String code){
        initSession();
        initSession();
        Criteria criteria = session.createCriteria(Course.class);
        criteria.add(Restrictions.eq("code", code));

        return criteria.list().size() > 0;
    }

    public List<Course> getAll(String roleid){
        initSession();
        Criteria criteria = session.createCriteria(Course.class);
        criteria.add(Restrictions.eq("tid", roleid));

        return criteria.list();
    }

    public List<CourseAbstract> getTeacherCourses(String roleid){
        initSession();
        String hql = "select new util.CourseAbstract(cid, name, code) from Course c where c.tid = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", roleid);
        return query.list();
    }

    public List<String> getStudentCourseIds(String roleid){
        initSession();
        String hql = "select s.cid from Selectc s where s.sid = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", roleid);
        return query.list();
    }

    public List<CourseAbstract> getCoursesByIds(List<String> ids){
        if(ids.size() == 0)
            return new ArrayList<CourseAbstract>();
        initSession();
        String hql = "select new util.CourseAbstract(cid, name, code) from Course c where c.cid in (:ids)";
        Query query = session.createQuery(hql);
        query.setParameterList("ids", ids);
        return query.list();
    }

    public Course getByCode(String code){
        List<Course> list = getByProperty("code", code);
        if(list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    public Course getById(String id){
        List<Course> list = getByProperty("cid", id);
        if(list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    public CourseDetail getDetailById(String id){
        initSession();
        String hql = "select new util.CourseDetail(r.roleid, r.name, c.cid, c.name, c.code, c.type, " +
                "c.introduction, c.creattime, c.starttime, c.finishtime, c.joinendtime) " +
                "from Course c, Role r " +
                "where c.tid = r.roleid and c.cid = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        return (CourseDetail) query.uniqueResult();
    }

    public CourseDetail getDetailByCode(String code){
        initSession();
        String hql = "select new util.CourseDetail(r.roleid, r.name, c.cid, c.name, c.code, c.type, " +
                "c.introduction, c.creattime, c.starttime, c.finishtime, c.joinendtime) " +
                "from Course c, Role r " +
                "where c.tid = r.roleid and c.code = :code";
        Query query = session.createQuery(hql);
        query.setParameter("code", code);
        return (CourseDetail) query.uniqueResult();
    }

    public Selectc getSelectInfo(String sid, String cid){
        initSession();
        String hql = "from Selectc s where s.cid = :cid and s.sid = :sid";
        Query query = session.createQuery(hql);
        query.setParameter("cid", cid);
        query.setParameter("sid", sid);
        return (Selectc) query.uniqueResult();
    }


    public boolean hasJoined(String sid, String cid){
        initSession();
        String hql = "from Selectc s where s.cid = :cid and s.sid = :sid";
        Query query = session.createQuery(hql);
        query.setParameter("cid", cid);
        query.setParameter("sid", sid);
        return query.uniqueResult() != null;
    }

    public List<Course> getByProperty(String property, Object value){
        initSession();

        Criteria criteria = session.createCriteria(Course.class);
        criteria.add(Restrictions.eq(property, value));
        return criteria.list();
    }

    public void join(String roleid, String cid, Date date) {
        initSession();
        Selectc s = new Selectc();
        s.setCid(cid);
        s.setSid(roleid);
        s.setSelecttime(date);
        session.save(s);
    }

    public void delete(String roleid, String id)  {
        initSession();
        String hql = "delete from Selectc s where s.cid = :cid and s.sid = :sid";
        Query query = session.createQuery(hql);
        query.setParameter("cid", id);
        query.setParameter("sid", roleid);
        query.executeUpdate();
    }

}
