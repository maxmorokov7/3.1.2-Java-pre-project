package web.Service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long userId);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);

}
