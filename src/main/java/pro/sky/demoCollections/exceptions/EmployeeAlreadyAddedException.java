package pro.sky.demoCollections.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }

    public EmployeeAlreadyAddedException(RuntimeException message) {
        super(message);
    }
}
