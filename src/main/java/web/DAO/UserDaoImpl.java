package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUserById(Integer userId) {
        return entityManager.find(User.class, userId);
    }

    public void saveUser(User user) {
//        entityManager.persist(entityManager.contains(user) ? user : entityManager.merge(user));
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
//        User userToUpdate = getUserById(user.getId());
//
//        if (userToUpdate != null) {
//            userToUpdate.setName(user.getName());
//            userToUpdate.setSurname(user.getSurname());
//            userToUpdate.setAge(user.getAge());
//            userToUpdate.setDepartment(user.getDepartment());
//        }
        entityManager.merge(user);
    }


    @Override
    public void deleteUser(Integer userId) {
        entityManager.remove(getUserById(userId));
    }
}
