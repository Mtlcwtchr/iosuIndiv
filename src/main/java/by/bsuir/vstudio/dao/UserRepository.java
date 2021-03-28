package by.bsuir.vstudio.dao;

import by.bsuir.vstudio.entity.User;

import java.util.Optional;

public interface UserRepository extends UserBaseRepository<User> {
    Optional<User> findByUsername(String username);
}
