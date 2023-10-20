package web.Dao;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.user.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository

public class UserDaoHiber implements UserDao {
    @PersistenceContext
EntityManager entityManager;
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void deleteUser(User user) {
       User user1=entityManager.find(User.class, user.getId());
        entityManager.remove(user1);

    }


    @Override
    public User findUser(Long id) {
       return entityManager.find(User.class, id);


    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);

    }


}
