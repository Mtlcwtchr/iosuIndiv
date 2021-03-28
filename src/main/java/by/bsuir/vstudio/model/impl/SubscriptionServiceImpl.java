package by.bsuir.vstudio.model.impl;

import by.bsuir.vstudio.dao.CustomerRepository;
import by.bsuir.vstudio.dao.SubscriptionRepository;
import by.bsuir.vstudio.entity.Customer;
import by.bsuir.vstudio.entity.Subscription;
import by.bsuir.vstudio.entity.SubscriptionType;
import by.bsuir.vstudio.model.SubscriptionService;
import by.bsuir.vstudio.model.exception.PrematureSubscriptionRenewalException;
import by.bsuir.vstudio.model.exception.SubscriptionSubstitutionInabilityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionServiceImpl.class);

    private final CustomerRepository customerRepository;
    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionServiceImpl(CustomerRepository customerRepository, SubscriptionRepository subscriptionRepository) {
        this.customerRepository = customerRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public List<Subscription> listSubscriptions() {
        List<Subscription> listSubscriptions = new ArrayList<>();
        Iterable<Subscription> subscriptions = subscriptionRepository.findAll();
        subscriptions.forEach(listSubscriptions::add);
        return listSubscriptions;
    }

    @Override
    public boolean hasActiveSubscription(Customer customer) {
        return customer.getActiveSubscriptionTermEnd().isBefore(LocalDateTime.now()) &&
                customer.getActiveSubscription().getSubscriptionType() != SubscriptionType.NONE;
    }

    @Override
    public boolean applySubscription(Customer customer, SubscriptionType subscriptionType) throws SubscriptionSubstitutionInabilityException, PrematureSubscriptionRenewalException {
        if(hasActiveSubscription(customer)) {
            String message = String.format(
                    "Couldn't apply subscription: %s has active subscription of type %s with expiration date %s",
                    customer,
                    customer.getActiveSubscription().getSubscriptionType(),
                    customer.getActiveSubscriptionTermEnd());

            log.info(message);
            throw new SubscriptionSubstitutionInabilityException(message);
        }

        if(customer.getActiveSubscription().getSubscriptionType().equals(subscriptionType)) {
            renewSubscription(customer);
        }

        boolean result = proceedPurchaseOperation(customer, subscriptionType);
        if(result) {
            Subscription subscription = subscriptionRepository.findBySubscriptionType(subscriptionType).orElseThrow();

            customer.setActiveSubscription(subscription);
            customer.setActiveSubscriptionTermStart(LocalDateTime.now());
            customer.setActiveSubscriptionTermEnd(customer.getActiveSubscriptionTermStart().plusDays(subscription.getSubscriptionTermDays()));

            customerRepository.save(customer);
        }

        return result;
    }

    @Override
    public boolean renewSubscription(Customer customer) throws PrematureSubscriptionRenewalException {
        if(hasActiveSubscription(customer)) {
            String message = String.format(
                    "Couldn't renew subscription: %s has active subscription of type %s with expiration date %s",
                    customer,
                    customer.getActiveSubscription().getSubscriptionType(),
                    customer.getActiveSubscriptionTermEnd());

            log.info(message);
            throw new PrematureSubscriptionRenewalException(message);
        }

        boolean result = proceedRenewOperation(customer);

        if(result) {
            customer.setActiveSubscriptionTermEnd(LocalDateTime.now().plusDays(customer.getActiveSubscription().getSubscriptionTermDays()));
            customerRepository.save(customer);
        }

        return result;
    }

    private boolean proceedPurchaseOperation(Customer customer, SubscriptionType subscriptionType) {
        log.info(String.format("%s paid %s bucks to purchase subscription", customer, subscriptionRepository.findBySubscriptionType(subscriptionType).orElseThrow().getSubscriptionCost()));
        return true;
    }

    private boolean proceedRenewOperation(Customer customer) {
        log.info(String.format("%s paid %s bucks to renew subscription", customer, customer.getActiveSubscription().getSubscriptionCost()));
        return true;
    }
}
