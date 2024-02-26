package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUserById(Integer userId);
    public void saveUser(User user);
//    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);
}
