package client_server.dao.user;

import client_server.model.UserItem;

import java.util.Optional;

public interface UserAddressDao {
    Optional<UserItem> getById(Long id);

    void update(UserItem updatedUserAddress);

    void delete(Long id);

    void save(UserItem value);
}
