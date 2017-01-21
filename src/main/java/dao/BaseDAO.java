package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Flyme on 2017/1/20.
 */


public class BaseDAO {

    @Autowired
    SessionFactory sessionFactory;

    protected Session session;
    protected void initSession(){
        session = sessionFactory.getCurrentSession();
    }

}
