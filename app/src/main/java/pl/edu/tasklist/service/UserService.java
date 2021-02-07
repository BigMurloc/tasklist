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
        entityManager.persist(user);
    }

}
