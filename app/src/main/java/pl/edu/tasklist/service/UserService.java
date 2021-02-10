package pl.edu.tasklist.service;

import org.springframework.stereotype.Service;
import pl.edu.tasklist.entity.User;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class UserService {

    private final EntityManager entityManager;

    public UserService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(User user){
        String query = "SELECT count(user) FROM User user WHERE user.username =: username";
        Long count = (Long) entityManager
                .createQuery(query)
                .setParameter("username", user.getUsername())
                .getSingleResult();
        if(count != 0){
            throw new RuntimeException("TODO");
        }
        entityManager.persist(user);
    }



}
