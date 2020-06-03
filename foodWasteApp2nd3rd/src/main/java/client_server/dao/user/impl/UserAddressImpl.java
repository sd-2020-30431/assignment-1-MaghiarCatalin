package client_server.dao.user.impl;


import client_server.dao.user.UserAddressDao;
import client_server.dao.HibernateAbstractCrudRepository;
import client_server.model.UserItem;

public class UserAddressImpl extends HibernateAbstractCrudRepository<Long, UserItem> implements UserAddressDao {

    @Override
    protected Class<UserItem> getValueClass() {
        return UserItem.class;
    }
}
