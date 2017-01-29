package dao;

import entity.Task;
import entity.Work;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Flyme on 2017/1/27.
 */

@Repository
public class WorkDAO extends BaseDAO {


    public void addOrUpdate(Work work) {
        initSession();
        session.saveOrUpdate(work);
    }

    public Work getById(String taskid, String sid) {
        initSession();
        Criteria c = session.createCriteria(Work.class);

        c.add(Restrictions.eq("taskid", taskid));
        c.add(Restrictions.eq("sid", sid));

        return (Work) c.uniqueResult();

    }


    public List<String> getDone(List<String> taskids, String sid) {
        if (taskids == null || taskids.size() == 0) {
            return new ArrayList<String>();
        }
        initSession();
        String hql = "select taskid from Work w where " +
                "w.sid = :sid and w.taskid in (:ids)";
        Query query = session.createQuery(hql);
        query.setParameter("sid", sid);
        query.setParameterList("ids", taskids);
        return query.list();
    }

    public void addComment(String taskid, String sid, String comment, Double score, Date time) {
        initSession();
        String hql = "update Work w set w.tcomment = :comment, w.score = :score, w.commenttime = :time where " +
                "w.taskid = :taskid and w.sid = :sid";
        Query query = session.createQuery(hql);
        query.setParameter("comment", comment);
        query.setParameter("score", score);
        query.setParameter("time", time);
        query.setParameter("taskid", taskid);
        query.setParameter("sid", sid);
        query.executeUpdate();
    }

}