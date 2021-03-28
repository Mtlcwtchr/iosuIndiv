package by.bsuir.vstudio.dao;

import by.bsuir.vstudio.entity.Subscription;
import by.bsuir.vstudio.entity.SubscriptionType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
    Optional<Subscription> findBySubscriptionType(SubscriptionType subscriptionType);
}
