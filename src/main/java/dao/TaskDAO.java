package dao;

import entity.Task;
import entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import util.WorkAbstract;

import java.util.List;

/**
 * Created by Flyme on 2017/1/25.
 */

@Repository
public class TaskDAO extends BaseDAO {

    public List<Task> getAllByCid(String cid) {
        initSession();
        Criteria c = session.createCriteria(Task.class);
        c.add(Restrictions.eq("cid", cid));
        c.add(Restrictions.eq("deleted", false));
        c.addOrder(Order.desc("creattime"));

        return c.list();
    }

    public List<String> getAllIdByCid(String cid) {
        initSession();
        String hql = "select t.taskid from Task t where t.cid = :cid";
        Query query = session.createQuery(hql);
        query.setParameter("cid", cid);
        return query.list();
    }


    public void delete(String id) {
        initSession();
        String hql = "update Task t set t.deleted = true where t.taskid = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
    }


    public Task getById(String id) {
        List<Task> list = getByProperty("taskid", id);
        if (list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    public List<Task> getByProperty(String property, Object value) {
        initSession();

        Criteria criteria = session.createCriteria(Task.class);
        criteria.add(Restrictions.eq(property, value));
        return criteria.list();
    }

    public void addOrUpdate(Task task) {
        initSession();
        session.saveOrUpdate(task);
    }

    public List<WorkAbstract> getAllWork(String taskid){
        initSession();
        String hql = "select new util.WorkAbstract(r.name, r.roleid, w.handtime, w.attachmd5, w.attachname, w.score, w.commenttime) " +
                "from Role r, Work w where " +
                "r.roleid = w.sid and w.taskid = :taskid";
        Query query = session.createQuery(hql);
        query.setParameter("taskid", taskid);
        return query.list();
    }

}
