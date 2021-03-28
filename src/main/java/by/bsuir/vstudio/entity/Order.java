package by.bsuir.vstudio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Order extends EntityObject{

    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "customer_mark")
    private int customerMark;


    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order() { }

    public Order(LocalDateTime orderDate, int customerMark, Movie movie, Customer customer) {
        this.orderDate = orderDate;
        this.customerMark = customerMark;
        this.movie = movie;
        this.customer = customer;
    }

    public Order(int id, LocalDateTime orderDate, int customerMark, Movie movie, Customer customer) {
        super(id);
        this.orderDate = orderDate;
        this.customerMark = customerMark;
        this.movie = movie;
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerMark() {
        return customerMark;
    }

    public void setCustomerMark(int customerMark) {
        this.customerMark = customerMark;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return customerMark == order.customerMark && Objects.equals(orderDate, order.orderDate) && Objects.equals(movie, order.movie) && Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderDate, customerMark, movie, customer);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("orderDate=" + orderDate)
                .add("customerMark=" + customerMark)
                .add("movie=" + movie)
                .add("customer=" + customer)
                .toString();
    }
}
