package pro.sky.demoCollections.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException(RuntimeException message) {
        super(message);
    }
}
