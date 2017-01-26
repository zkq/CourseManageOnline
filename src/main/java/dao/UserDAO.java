package dao;

import entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Flyme on 2017/1/20.
 */

@Repository
public class UserDAO extends BaseDAO {

    public void add(User user){
        initSession();
        session.save(user);
    }

    public void update(User user){
        initSession();
        session.update(user);
    }





    public User getByName(String name){
        List<User> list = getByProperty("username", name);
        if(list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    public User getByRoleid(String id){
        List<User> list = getByProperty("roleid", id);
        if(list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    public List<User> getByProperty(String property, Object value){
        initSession();

        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq(property, value));
        return criteria.list();
    }



}
