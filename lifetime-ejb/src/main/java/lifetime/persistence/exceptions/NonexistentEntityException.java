package lifetime.persistence.exceptions;

public class NonexistentEntityException extends LifetimeSecurityException  {
    public NonexistentEntityException(String message) {
        super(message);
    }
}
