package client_server.dao.user.impl;

import client_server.dao.HibernateAbstractCrudRepository;
import client_server.dao.user.UserDao;
import client_server.model.User;
import client_server.model.UserRole;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class UserDaoImpl extends HibernateAbstractCrudRepository<String, User> implements UserDao {

    @Override
    protected Class<User> getValueClass() {
        return User.class;
    }


    @Override
    public Optional<User> getUserByEmail(String email) {
        Session session = this.getCurrentSession();
        return Optional.ofNullable(session.get(this.getValueClass(), email));
    }

    @Override
    public Optional<User> getByPhoneNumber(String phoneNumber) {
        Query<User> query = super.getCurrentSession().createQuery("FROM users where phoneNumber=:phoneNumber ", User.class);
        query.setParameter("phoneNumber", phoneNumber);
        return Optional.ofNullable(query.uniqueResult());
    }

    @Override
    public UserRole getCredentials(User user) {
        Query<User> query = super.getCurrentSession().createQuery("FROM User WHERE email =: email AND password=: password", User.class);
        query.setParameter("email", user.getEmail());
        query.setParameter("password", user.getPassword());

        if (query.uniqueResult() != null) {
            return query.uniqueResult().getRole();
        }
        return null;
    }


}
