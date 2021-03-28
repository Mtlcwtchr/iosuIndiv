package by.bsuir.vstudio.model;

import by.bsuir.vstudio.entity.Customer;
import by.bsuir.vstudio.entity.Subscription;
import by.bsuir.vstudio.entity.SubscriptionType;
import by.bsuir.vstudio.model.exception.SubscriptionServiceException;
import com.sun.istack.NotNull;

import java.util.List;

public interface SubscriptionService {
    List<Subscription> listSubscriptions();
    boolean hasActiveSubscription(@NotNull Customer customer);
    @NotNull
    boolean applySubscription(@NotNull Customer customer, SubscriptionType subscriptionType) throws SubscriptionServiceException;
    @NotNull
    boolean renewSubscription(@NotNull Customer customer) throws SubscriptionServiceException;
}
