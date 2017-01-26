package dao;

import entity.Concern;
import entity.Role;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import util.RoleAbstract;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Flyme on 2017/1/22.
 */

@Repository
public class ConcernDAO extends BaseDAO {

    public boolean hasConcenred(String roleid1, String roleid2){
        initSession();

        String hql = "from Concern c where c.roleid1 = :id1 and c.roleid2 = :id2";
        Query query = session.createQuery(hql);
        query.setParameter("id1", roleid1);
        query.setParameter("id2", roleid2);

        return query.list().size() > 0;
    }

    public void cancelConcern(String roleid1, String roleid2){
        initSession();

        String hql = "delete from Concern c where c.roleid1 = :id1 and c.roleid2 = :id2";
        Query query = session.createQuery(hql);
        query.setParameter("id1", roleid1);
        query.setParameter("id2", roleid2);

        query.executeUpdate();
    }

    public void addConcern(String roleid1, String roleid2){
        initSession();

        Concern concern = new Concern();
        concern.setRoleid1(roleid1);
        concern.setRoleid2(roleid2);
        concern.setTime(new Date());
        session.saveOrUpdate(concern);
    }

    public int getConcernCnt(String roleid){
        initSession();

        //首先确定类型
        String hql1 = "from Role r where  r.roleid = :id";
        Query query1 = session.createQuery(hql1);
        query1.setParameter("id", roleid);
        Role role = (Role) query1.list().get(0);

        int type = Integer.parseInt(role.getType());
        String s;
        if(type == 1){
            s = "roleid2";
        }else{
            s = "roleid1";
        }
        String hql = "select count(*) from Concern c where c." + s +" = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", roleid);

        Long cnt = (Long) query.list().get(0);

        return cnt.intValue();
    }

    public List<String> getAllId(String roleid){
        initSession();

        //首先确定类型
        String hql1 = "from Role r where  r.roleid = :id";
        Query query1 = session.createQuery(hql1);
        query1.setParameter("id", roleid);
        Role role = (Role) query1.list().get(0);

        int type = Integer.parseInt(role.getType());
        String hql;
        if(type == 1){
            hql = "select roleid1 from Concern c where c.roleid2 = :id";
        }else{
            hql = "select roleid2 from Concern c where c.roleid1 = :id";
        }
        Query query = session.createQuery(hql);
        query.setParameter("id", roleid);

        return query.list();
    }

    public List<RoleAbstract> getAllRole(List<String> ids){
        if(ids == null || ids.size() == 0)
        {
            return new ArrayList<RoleAbstract>();
        }

        initSession();
        String hql = "select new util.RoleAbstract(name, roleid) from Role role " +
                "where role.roleid in (:ids)";
        Query query = session.createQuery(hql);
        query.setParameterList("ids", ids);

        return query.list();
    }

}
