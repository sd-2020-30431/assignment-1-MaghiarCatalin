package client_server.service.user.impl;

import client_server.dao.user.UserDao;
import client_server.dao.user.impl.UserDaoImpl;
import client_server.service.user.UserService;
import client_server.model.User;
import client_server.model.UserRole;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getAll() {
        List<User> users = userDao.getAll();
        users.forEach(user -> Hibernate.initialize(user.getUserAddressList()));
        return users;
    }

    @Override
    public UserRole getCredentials(User user) {

        return userDao.getCredentials(user);
    }

    @Override
    public void delete(String email) {
        userDao.getUserByEmail(email).ifPresentOrElse(foundProduct -> {
            userDao.delete(email);
        }, () -> {
            throw new NoSuchElementException("The specified element does not exist.");
        });
    }

    @Override
    public void insert(User user) {
        userDao.save(user);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        Optional<User> user = userDao.getUserByEmail(email);
        return user;
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
