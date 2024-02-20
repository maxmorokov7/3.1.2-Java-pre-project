package web.Service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {
    @Transactional
    List<User> getAllUsers();
    @Transactional
    User getUserById(Long userId);
    @Transactional
    void addUser(User user);
    @Transactional
    void updateUser(User user);
    @Transactional
    void deleteUser(Long userId);

}
