package by.bsuir.vstudio.dao;

import by.bsuir.vstudio.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserBaseRepository<T extends User> extends CrudRepository<T, Integer> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}
