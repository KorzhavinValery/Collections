package pro.sky.demoCollections.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }

    public EmployeeStorageIsFullException(RuntimeException message) {
        super(message);
    }
}
