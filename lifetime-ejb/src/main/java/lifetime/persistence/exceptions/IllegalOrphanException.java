package lifetime.persistence.exceptions;

public class IllegalOrphanException extends LifetimeSecurityException {

    public IllegalOrphanException(String messages) {
        super(messages);
    }
}
