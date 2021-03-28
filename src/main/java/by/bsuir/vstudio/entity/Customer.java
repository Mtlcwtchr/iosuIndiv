package by.bsuir.vstudio.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "customer")
public class Customer extends User {

    private String name;
    private String email;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "active_subscription_id")
    private Subscription activeSubscription;
    @Column(name = "active_subscription_term_start")
    private LocalDateTime activeSubscriptionTermStart;
    @Column(name = "active_subscription_term_end")
    private LocalDateTime activeSubscriptionTermEnd;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private PersonalizedGroup personalizedGroup;

    public Customer() { }

    public Customer(String username, String password, boolean isPromoted, String name, String email, LocalDate birthDate, LocalDate registrationDate) {
        super(username, password, isPromoted);
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
    }

    public Customer(String username, String password, boolean isPromoted, String name, String email, LocalDate birthDate, LocalDate registrationDate, Subscription activeSubscription, LocalDateTime activeSubscriptionTermStart, LocalDateTime activeSubscriptionTermEnd) {
        super(username, password, isPromoted);
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.activeSubscription = activeSubscription;
        this.activeSubscriptionTermStart = activeSubscriptionTermStart;
        this.activeSubscriptionTermEnd = activeSubscriptionTermEnd;
    }

    public Customer(String username, String password, boolean isPromoted, String name, String email, LocalDate birthDate, LocalDate registrationDate, Subscription activeSubscription, LocalDateTime activeSubscriptionTermStart, LocalDateTime activeSubscriptionTermEnd, PersonalizedGroup personalizedGroup) {
        super(username, password, isPromoted);
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.activeSubscription = activeSubscription;
        this.activeSubscriptionTermStart = activeSubscriptionTermStart;
        this.activeSubscriptionTermEnd = activeSubscriptionTermEnd;
        this.personalizedGroup = personalizedGroup;
    }

    public Customer(int id, String username, String password, boolean isPromoted, String name, String email, LocalDate birthDate, LocalDate registrationDate, Subscription activeSubscription, LocalDateTime activeSubscriptionTermStart, LocalDateTime activeSubscriptionTermEnd, PersonalizedGroup personalizedGroup) {
        super(id, username, password, isPromoted);
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.activeSubscription = activeSubscription;
        this.activeSubscriptionTermStart = activeSubscriptionTermStart;
        this.activeSubscriptionTermEnd = activeSubscriptionTermEnd;
        this.personalizedGroup = personalizedGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Subscription getActiveSubscription() {
        return activeSubscription;
    }

    public void setActiveSubscription(Subscription activeSubscription) {
        this.activeSubscription = activeSubscription;
    }

    public LocalDateTime getActiveSubscriptionTermStart() {
        return activeSubscriptionTermStart;
    }

    public void setActiveSubscriptionTermStart(LocalDateTime activeSubscriptionTermStart) {
        this.activeSubscriptionTermStart = activeSubscriptionTermStart;
    }

    public LocalDateTime getActiveSubscriptionTermEnd() {
        return activeSubscriptionTermEnd;
    }

    public void setActiveSubscriptionTermEnd(LocalDateTime activeSubscriptionTermEnd) {
        this.activeSubscriptionTermEnd = activeSubscriptionTermEnd;
    }

    public PersonalizedGroup getPersonalizedGroup() {
        return personalizedGroup;
    }

    public void setPersonalizedGroup(PersonalizedGroup personalizedGroup) {
        this.personalizedGroup = personalizedGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(birthDate, customer.birthDate) && Objects.equals(registrationDate, customer.registrationDate) && Objects.equals(activeSubscription, customer.activeSubscription) && Objects.equals(activeSubscriptionTermStart, customer.activeSubscriptionTermStart) && Objects.equals(activeSubscriptionTermEnd, customer.activeSubscriptionTermEnd) && Objects.equals(personalizedGroup, customer.personalizedGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, email, birthDate, registrationDate, activeSubscription, activeSubscriptionTermStart, activeSubscriptionTermEnd, personalizedGroup);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("name='" + name + "'")
                .add("email='" + email + "'")
                .add("birthDate=" + birthDate)
                .add("registrationDate=" + registrationDate)
                .add("activeSubscription=" + activeSubscription)
                .add("activeSubscriptionTermStart=" + activeSubscriptionTermStart)
                .add("activeSubscriptionTermEnd=" + activeSubscriptionTermEnd)
                .add("personalizedGroup=" + personalizedGroup)
                .toString();
    }
}
