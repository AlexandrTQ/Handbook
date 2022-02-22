package alexandr.exeptions;

public class CarAlreadyInExistException extends RuntimeException {
    public CarAlreadyInExistException() {
        super("car already exits");
    }
}
