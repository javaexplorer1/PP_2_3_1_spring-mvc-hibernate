package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext(name = "TDPersistenceUnit")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("from User").getResultList();
    }
}
