package pro.sky.demoCollections.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.demoCollections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.demoCollections.exceptions.EmployeeNotFoundException;
import pro.sky.demoCollections.exceptions.EmployeeStorageIsFullException;
import pro.sky.demoCollections.exceptions.InvalidInputException;
import pro.sky.demoCollections.model.Employee;
import pro.sky.demoCollections.service.impliments.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {


    private EmployeeServiceImpl out;

    @BeforeEach
    void setUp() {
        out = new EmployeeServiceImpl();
        out.addEmployee("Fedor", "Symkin", 5, 4);
        out.addEmployee("Bilbo", "Begins", 100, 4);
        out.addEmployee("Semen", "Pytnik", 5, 4);
        out.addEmployee("Aragorn", "Aratorn", 20, 5);
    }

    private Employee expected = new Employee("Ivan", "Skvorcov", 100000, 1);

    @Test
    void shouldAddEmployee() {
        Employee result = out.addEmployee(expected.getFirstName(),
                expected.getLastName(),
                expected.getSalary(),
                expected.getDepartment());
        assertEquals(expected, result);
    }

    @Test
    void shouldThrowExceptionAlreadyAddedWhenAddEmployee() {
        out.addEmployee(expected.getFirstName(),
                expected.getLastName(),
                expected.getSalary(),
                expected.getDepartment());
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee(expected.getFirstName(),
                        expected.getLastName(),
                        expected.getSalary(),
                        expected.getDepartment()));
    }

    @Test
    void shouldThrowExceptionStorageIsFullWhenAddEmployee() {
        Employee result = new Employee("Limit", "Prevushen", 1000, 2);

        out.addEmployee(expected.getFirstName(),
                expected.getLastName(),
                expected.getSalary(),
                expected.getDepartment());


        assertThrows(EmployeeStorageIsFullException.class,
                () -> out.addEmployee(result.getFirstName(),
                        result.getLastName(),
                        result.getSalary(),
                        result.getDepartment()));
    }

    @Test
    void shouldFindEmployee() {
        out.addEmployee(expected.getFirstName(),
                expected.getLastName(),
                expected.getSalary(),
                expected.getDepartment());

        Employee result = out.findEmployee(expected.getFirstName(),
                expected.getLastName(),
                expected.getSalary(),
                expected.getDepartment());
        assertEquals(expected, result);
    }

    @Test
    void shouldThrowNotFoundExceptionsWhenFindOrRemoveEmployee() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee(expected.getFirstName(),
                        expected.getLastName(),
                        expected.getSalary(),
                        expected.getDepartment()));
    }

    @Test
    void shouldRemoveEmployee() {
        out.addEmployee(expected.getFirstName(),
                expected.getLastName(),
                expected.getSalary(),
                expected.getDepartment());
        Employee result = out.removeEmployee(expected.getFirstName(),
                expected.getLastName(),
                expected.getSalary(),
                expected.getDepartment());
        assertEquals(expected, result);
    }

    @Test
    void shouldThrowInvalidInputExceptionWhenAddEmployee() {
        Employee result = new Employee("Iva123", "Petr0v", 1000000, 1);
        assertThrows(InvalidInputException.class,
                () -> out.addEmployee(result.getFirstName(),
                        result.getLastName(),
                        result.getSalary(),
                        result.getDepartment()));
    }

}
