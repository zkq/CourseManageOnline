package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Flyme on 2017/1/20.
 */

@Repository
public class UserDAO {

    @Autowired
    SessionFactory sessionFactory;

}
