package by.bsuir.vstudio.model.exception;

public class SubscriptionServiceException extends Exception {
    public SubscriptionServiceException() {
        super();
    }
    public SubscriptionServiceException(String message) {
        super(message);
    }
    public SubscriptionServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    public SubscriptionServiceException(Throwable cause) {
        super(cause);
    }
}
