package pl.edu.tasklist.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import pl.edu.tasklist.entity.User;
import pl.edu.tasklist.exception.UserAlreadyExistsException;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class UserService {

    private final EntityManager entityManager;

    public UserService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(User user) throws UserAlreadyExistsException {
        Long count = doesExist(user.getUsername());
        if(count != 0){
            throw new UserAlreadyExistsException();
        }
        entityManager.persist(user);
    }

    private Long doesExist(String username) {
        String query = "SELECT count(user) FROM User user WHERE user.username =: username";
        Long count = (Long) entityManager
                .createQuery(query)
                .setParameter("username", username)
                .getSingleResult();
        return count;
    }


}
