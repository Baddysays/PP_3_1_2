package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> listUsers();

    void updateUser(User user);

    void removeUser(Long id);

    User findById(Long id);
}