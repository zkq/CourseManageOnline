package dao;

import entity.Resource;
import entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Flyme on 2017/1/29.
 */

@Repository
public class ResourceDAO extends BaseDAO {


    public Resource getById(String id) {
        List<Resource> list = getByProperty("rid", id);
        if (list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    public List<Resource> getAllByCid(String cid) {
        initSession();
        return getByProperty("cid", cid);
    }

    public List<Resource> getByProperty(String property, Object value) {
        initSession();

        Criteria criteria = session.createCriteria(Resource.class);
        criteria.add(Restrictions.eq(property, value));
        return criteria.list();
    }

    public void saveOrUpdate(Resource resource) {
        initSession();
        session.saveOrUpdate(resource);
    }

    public void delete(String rid){
        initSession();
        String hql = "delete from Resource r where r.rid = :rid";
        Query query = session.createQuery(hql);
        query.setParameter("rid", rid);
        query.executeUpdate();
    }

}
