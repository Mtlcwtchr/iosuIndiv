package by.bsuir.vstudio.model;

import by.bsuir.vstudio.entity.Customer;
import by.bsuir.vstudio.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Optional<User> tryAuthorize(String username, String password);
    Optional<Customer> tryRegister(String username, String password, String name, String email, LocalDate birthDate);
    boolean exists(String username, String email);
    List<Customer> listCustomers();
}
