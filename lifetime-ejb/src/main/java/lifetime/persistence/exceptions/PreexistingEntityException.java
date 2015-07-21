package lifetime.persistence.exceptions;

public class PreexistingEntityException extends LifetimeSecurityException {
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public PreexistingEntityException(String message) {
        super(message);
    }
}
