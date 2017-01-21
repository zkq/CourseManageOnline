package dao;

import entity.Role;
import entity.Role;
import entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Flyme on 2017/1/20.
 */

@Repository
public class RoleDAO extends BaseDAO {

    public void add(Role role){
        initSession();
        session.save(role);
    }

    public void update(Role role){
        initSession();
        session.update(role);
    }


    public Role getById(String id){
        List<Role> list = getByProperty("roleid", id);
        if(list.isEmpty())
            return null;
        else
            return list.get(0);
    }


    public List<Role> getByProperty(String property, Object value){
        initSession();

        Criteria criteria = session.createCriteria(Role.class);
        criteria.add(Restrictions.eq(property, value));
        return criteria.list();
    }

}
