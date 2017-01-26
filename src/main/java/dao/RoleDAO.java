package dao;

import entity.Role;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import util.RoleAbstract;

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


    public List<RoleAbstract> search(String name, String myid){
        initSession();

        String hql = "select new util.RoleAbstract(name, roleid) from Role role " +
                "where role.roleid != :myid and role.name like :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", "%" + name + "%");
        query.setParameter("myid", myid);
        return query.list();
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
