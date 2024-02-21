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
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public User getUserById(Integer userId) {
        TypedQuery<User> q = entityManager.createQuery("select user from User user where user.id =:userId", User.class);
        q.setParameter("userId", userId);
        return q.getResultList().stream().findAny().orElse(null);
    }


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        User user1 = entityManager.find(User.class, user.getId());
        if (user1 != null) {
            user1.setAge(user.getAge());
            user1.setName(user.getName());
            user1.setSurname(user.getSurname());
            user1.setDepartment(user.getDepartment());
            entityManager.merge(user1);
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        entityManager.remove(getUserById(userId));
    }
}
