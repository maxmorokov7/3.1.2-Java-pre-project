package web.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.model.User;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    @Transactional(readOnly=true )
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional(readOnly=true )
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

//    @Override
//    public void addUser(User user) {
//        userDao.addUser(user);
//    }


    @Override
    public void updateUser(User user) {
    userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userDao.deleteUser(userId);
    }
}
