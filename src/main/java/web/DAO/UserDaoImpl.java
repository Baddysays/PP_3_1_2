package web.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;


import java.util.List;
@Component
@Repository
public class UserDaoImpl implements UserDao {

@PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);


    }

    @Override
    public List<User> listUsers() {
        List <User> userList = entityManager.createQuery("FROM User", User.class).getResultList();
        return userList;
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }



    @Override
    public void removeUser(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
}