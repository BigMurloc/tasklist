package pl.edu.tasklist.service;

import org.springframework.stereotype.Service;
import pl.edu.tasklist.entity.User;

import javax.persistence.EntityManager;

@Service
public class UserService {

    private final EntityManager entityManager;

    public UserService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save (User user){
        entityManager.persist(user);
    }


}
