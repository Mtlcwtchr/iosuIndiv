package by.bsuir.vstudio.dao;

import by.bsuir.vstudio.entity.Customer;

import java.util.Optional;

public interface CustomerRepository extends UserBaseRepository<Customer> {
    Optional<Customer> findByUsernameOrEmail(String username, String email);
}
