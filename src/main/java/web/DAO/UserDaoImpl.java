package web.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.Access;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    @Override
//    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
//    @Transactional
    public User getUserById(Long userId) {
        TypedQuery<User> q = entityManager.createQuery("select user from User user where user.id =:userId", User.class);
        q.setParameter("userId", userId);
        return q.getResultList().stream().findAny().orElse(null);
    }


    @Override
//    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
//    @Transactional
    public void updateUser(User user) {
        User user1 = entityManager.find(User.class, user.getId());
        if (user1 != null) {
            user1.setAge(user.getAge());
            user1.setName(user.getName());
            user1.setSurname(user.getSurname());
            user1.setDepartment(user.getDepartment());
        }
        entityManager.merge(user1);
    }

    @Override
//    @Transactional
    public void deleteUser(Long userId) {
        entityManager.remove(getUserById(userId));
    }
}
