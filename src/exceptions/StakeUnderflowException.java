package exceptions;

public class StakeUnderflowException extends CardGameException {
    public StakeUnderflowException(String message) {
        super(message);
    }
}
