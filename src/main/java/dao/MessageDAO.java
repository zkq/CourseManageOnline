package dao;

import com.sun.corba.se.pept.protocol.MessageMediator;
import entity.Message;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import util.MessageDetail;

import java.util.Date;
import java.util.List;

/**
 * Created by Flyme on 2017/1/30.
 */

@Repository
public class MessageDAO extends BaseDAO {

    public void add(Message message) {
        initSession();
        session.save(message);
    }

    public List<MessageDetail> getBySid(String sid) {
        initSession();
        String hql = "select new util.MessageDetail(m.mid, m.sid, m.tid, r.name, m.actiontype, " +
                "a.actionname, a.tip, m.actiontime, m.content, m.readed, m.deleted) from Message m, Role r, Actiontype a where " +
                "m.actiontype = a.aid and m.tid = r.roleid and m.sid = :sid and m.deleted = false order by m.actiontime desc";
        Query query = session.createQuery(hql);
        query.setParameter("sid", sid);
        return query.list();
    }

    public void delete(String mid) {
        initSession();
        String hql = "update Message m set m.deleted = true where m.mid = :mid";
        Query query = session.createQuery(hql);
        query.setParameter("mid", mid);
        query.executeUpdate();
    }
}
