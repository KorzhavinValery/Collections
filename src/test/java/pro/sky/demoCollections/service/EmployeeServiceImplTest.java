package pro.sky.demoCollections.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.demoCollections.model.Employee;
import pro.sky.demoCollections.service.impliments.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeServiceImplTest {


    private EmployeeServiceImpl out;
    @BeforeEach
    void setUp() {
        out = new EmployeeServiceImpl();
    }

    private Employee expected = new Employee("Ivan", "Skvorcov", 100000, 1);

    @Test
    void shouldAddEmployee() {
        Employee result = out.addEmployee(expected.getFirstName(),
                expected.getLastName(),
                expected.getSalary(),
                expected.getDepartment());
        assertTrue(out.getEmployeeMap().contains(expected));
        assertEquals(expected, result);
    }

    @Test
    void shouldThrowExceptionAlreadyAddedWhenAddEmployee() {
    }

    @Test
    void shouldThrowExceptionStorageIsFullWhenAddEmployee() {
    }

    @Test
    void shouldFindEmployee() {
    }

    @Test
    void shouldThrowNotFoundExceptionsWhenFindEmployee() {
    }

    @Test
    void shouldRemoveEmployee() {
    }

    @Test
    void shouldThrowNotFoundExceptionsWhenRemoveEmployee() {
    }
}
