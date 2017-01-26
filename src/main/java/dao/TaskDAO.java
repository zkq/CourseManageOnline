package dao;

import entity.Task;
import entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Flyme on 2017/1/25.
 */

@Repository
public class TaskDAO extends BaseDAO{

    public List<Task> getAllByCid(String cid){
        initSession();
        Criteria c = session.createCriteria(Task.class);
        c.add(Restrictions.eq("cid", cid));
        c.add(Restrictions.eq("deleted", false));
        return c.list();
    }

    public void delete(String id){
        initSession();
        String hql = "update Task t set t.deleted = true where t.taskid = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
    }


    public Task getById(String id){
        List<Task> list = getByProperty("taskid", id);
        if(list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    public List<Task> getByProperty(String property, Object value){
        initSession();

        Criteria criteria = session.createCriteria(Task.class);
        criteria.add(Restrictions.eq(property, value));
        return criteria.list();
    }

    public void addOrUpdate(Task task){
        initSession();
        session.saveOrUpdate(task);
    }

}
