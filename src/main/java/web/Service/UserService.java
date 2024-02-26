package web.Service;


import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Integer userId);

    //    void addUser(User user);
    public void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);

}
