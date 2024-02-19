package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUserById(Long userId);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);
}
