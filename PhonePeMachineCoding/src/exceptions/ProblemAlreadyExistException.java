package exceptions;

public class ProblemAlreadyExistException extends RuntimeException{


    public ProblemAlreadyExistException(String message) {
        super(message);
    }
}
