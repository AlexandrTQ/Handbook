package alexandr.exeptions;

public class CarDoesNotExistException extends RuntimeException {
    public CarDoesNotExistException() {
        super("Car does not exist");
    }
}
