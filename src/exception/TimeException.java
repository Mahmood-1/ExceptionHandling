package exception;

public class TimeException extends Exception {
    @Override
    public String getMessage() {
        return super.getMessage() + "\nInvalid Time";
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage() + "\nPlease Enter A valid Time";
    }
}
