package by.javatr.tasks.exception;

public class IncorrectPositionException extends Exception{
    public IncorrectPositionException() {
    }

    public IncorrectPositionException(String message) {
        super(message);
    }

    public IncorrectPositionException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectPositionException(Throwable cause) {
        super(cause);
    }
}
