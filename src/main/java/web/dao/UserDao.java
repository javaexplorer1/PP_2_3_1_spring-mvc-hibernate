package web.dao;

import web.model.User;

import java.util.List;


public interface UserDao {
    void add(User user);

    void removeUserById(long id);

    User getUserById(long id);

    void update(User user);

    List<User> listUsers();
}
