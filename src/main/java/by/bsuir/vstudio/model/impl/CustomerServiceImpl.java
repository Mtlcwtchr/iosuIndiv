package by.bsuir.vstudio.model.impl;

import by.bsuir.vstudio.dao.CustomerRepository;
import by.bsuir.vstudio.dao.UserRepository;
import by.bsuir.vstudio.entity.*;
import by.bsuir.vstudio.model.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<User> tryAuthorize(String username, String password) {
        Optional<User> result = Optional.empty();
        Optional<User> userByUsernameAndPassword = userRepository.findByUsernameAndPassword(username, password);
        if (userByUsernameAndPassword.isPresent()) {
            User user = userByUsernameAndPassword.get();
            if (user.isPromoted()) {
                result = userByUsernameAndPassword;
            } else {
                Optional<Customer> customerById = customerRepository.findById(user.getId());
                if(customerById.isPresent()) {
                    Customer customer = customerById.get();
                    result = Optional.of(customer);
                }
            }
        }
        return result;
    }

    @Override
    public Optional<Customer> tryRegister(String username, String password, String name, String email, LocalDate birthDate) {
        if(exists(username, email)) {
            return Optional.empty();
        }

        return Optional.of(customerRepository.save(new Customer(username, password, false, name, email, birthDate, LocalDate.now())));
    }

    @Override
    public boolean exists(String username, String email) {
        return customerRepository.findByUsernameOrEmail(username, email).isPresent();
    }

    @Override
    public List<Customer> listCustomers() {
        List<Customer> listCustomers = new ArrayList<>();
        Iterable<Customer> customers = customerRepository.findAll();
        customers.forEach(listCustomers::add);
        return listCustomers;
    }
}
