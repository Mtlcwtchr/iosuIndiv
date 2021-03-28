package by.bsuir.vstudio.model.exception;

public class PrematureSubscriptionRenewalException extends SubscriptionServiceException {
    public PrematureSubscriptionRenewalException() {
        super();
    }
    public PrematureSubscriptionRenewalException(String message) {
        super(message);
    }
    public PrematureSubscriptionRenewalException(String message, Throwable cause) {
        super(message, cause);
    }
    public PrematureSubscriptionRenewalException(Throwable cause) {
        super(cause);
    }
}
