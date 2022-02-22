package alexandr.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ IllegalNumberException.class, CarAlreadyInExistException.class})
    public ResponseEntity<ExceptionDto> illegalArgumentHandle(Exception exception) {
        return new ResponseEntity<ExceptionDto>
                (new ExceptionDto(exception.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CarDoesNotExistException.class})
    public ResponseEntity<ExceptionDto> NotFoundHandle(Exception exception) {
        return new ResponseEntity<ExceptionDto>
                (new ExceptionDto(exception.getLocalizedMessage()), HttpStatus.NOT_FOUND);
    }
}
