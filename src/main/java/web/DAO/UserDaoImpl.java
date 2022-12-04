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
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public void updateUser(Long id,User user) {
        User userUP = entityManager.find(User.class,id);
        userUP.setFirstName(user.getFirstName());
        userUP.setLastName(user.getLastName());
        userUP.setEmail(user.getEmail());

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