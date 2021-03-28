package by.bsuir.vstudio.dao;

import by.bsuir.vstudio.entity.Customer;
import by.bsuir.vstudio.entity.Movie;
import by.bsuir.vstudio.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findAllByCustomer(Customer customer);
    List<Order> findAllByMovie(Movie movie);
    List<Order> findAllByOrderDate(LocalDateTime date);
    List<Order> findAllByOrderDateAfter(LocalDateTime date);
    List<Order> findALlByCustomerMarkAfter(int mark);
}
