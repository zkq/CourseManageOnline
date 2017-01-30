package dao;

import entity.Download;
import entity.Resource;
import entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import util.ResourceDetail;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by Flyme on 2017/1/29.
 */

@Repository
public class ResourceDAO extends BaseDAO {

    public List<ResourceDetail> getDownloads(String roleid) {
        initSession();
        String hql = "select new util.ResourceDetail(r.rid, c.cid, c.name, ro.roleid, " +
                "ro.name, r.type, r.resourcemd5, r.resourcename, r.introduction, r.creattime) " +
                "from Download d, Resource r, Course c, Role ro " +
                "where d.roleid = :roleid and r.rid = d.rid and " +
                "r.cid = c.cid and r.roleid = ro.roleid";
        Query query = session.createQuery(hql);
        query.setParameter("roleid", roleid);
        return query.list();
    }

    public List<ResourceDetail> getByRoleid(String roleid) {
        initSession();
        String hql = "select new util.ResourceDetail(r.rid, c.cid, c.name, ro.roleid, " +
                "ro.name, r.type, r.resourcemd5, r.resourcename, r.introduction, r.creattime) " +
                "from Resource r, Course c, Role ro " +
                "where r.cid = c.cid and r.roleid = ro.roleid " +
                "and r.roleid = :roleid";
        Query query = session.createQuery(hql);
        query.setParameter("roleid", roleid);
        return query.list();
    }

    public Resource getById(String id) {
        initSession();
        List<Resource> list = getByProperty("rid", id);
        if (list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    public Resource getByMd5(String md5) {
        initSession();
        List<Resource> list = getByProperty("resourcemd5", md5);
        if (list.isEmpty())
            return null;
        else
            return list.get(0);
    }

    public boolean downExist(String rid, String roleid){
        initSession();
        Criteria c = session.createCriteria(Download.class);
        c.add(Restrictions.eq("rid", rid));
        c.add(Restrictions.eq("roleid", roleid));
        return c.list().size() > 0;
    }

    public void addDown(String rid, String roleid){
        initSession();
        Download download = new Download();
        download.setRid(rid);
        download.setRoleid(roleid);
        download.setTime(new Date());
        session.save(download);
    }

    public List<ResourceDetail> getAllByCid(String cid) {
        initSession();
        String hql = "select new util.ResourceDetail(r.rid, c.cid, c.name, ro.roleid, " +
                "ro.name, r.type, r.resourcemd5, r.resourcename, r.introduction, r.creattime) " +
                "from Resource r, Course c, Role ro " +
                "where r.cid = c.cid and r.roleid = ro.roleid " +
                "and r.cid = :cid";
        Query query = session.createQuery(hql);
        query.setParameter("cid", cid);
        return query.list();
    }

    public List<String> getIdsByRoleidCid(String roleid, String cid){
        initSession();
        String hql = "select rid from Resource r where r.roleid = :roleid and r.cid = :cid";
        Query query = session.createQuery(hql);
        query.setParameter("roleid", roleid);
        query.setParameter("cid", cid);
        return query.list();
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
