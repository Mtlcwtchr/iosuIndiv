package by.bsuir.vstudio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Subscription extends EntityObject {

    @Column(name = "subscription_type")
    private SubscriptionType subscriptionType;
    @Column(name = "subscription_term_days")
    private int subscriptionTermDays;
    @Column(name = "subscription_cost")
    private int subscriptionCost;

    public Subscription() { }

    public Subscription(SubscriptionType subscriptionType, int subscriptionTermDays, int subscriptionCost) {
        this.subscriptionType = subscriptionType;
        this.subscriptionTermDays = subscriptionTermDays;
        this.subscriptionCost = subscriptionCost;
    }

    public Subscription(int id, SubscriptionType subscriptionType, int subscriptionTermDays, int subscriptionCost) {
        super(id);
        this.subscriptionType = subscriptionType;
        this.subscriptionTermDays = subscriptionTermDays;
        this.subscriptionCost = subscriptionCost;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public int getSubscriptionTermDays() {
        return subscriptionTermDays;
    }

    public void setSubscriptionTermDays(int subscriptionTermDays) {
        this.subscriptionTermDays = subscriptionTermDays;
    }

    public int getSubscriptionCost() {
        return subscriptionCost;
    }

    public void setSubscriptionCost(int subscriptionCost) {
        this.subscriptionCost = subscriptionCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Subscription that = (Subscription) o;
        return subscriptionTermDays == that.subscriptionTermDays && subscriptionCost == that.subscriptionCost && subscriptionType == that.subscriptionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subscriptionType, subscriptionTermDays, subscriptionCost);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Subscription.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("subscriptionType=" + subscriptionType)
                .add("subscriptionTermDays=" + subscriptionTermDays)
                .add("subscriptionCost=" + subscriptionCost)
                .toString();
    }
}
