package pro.sky.demoCollections.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.demoCollections.exceptions.InvalidInputException;
import pro.sky.demoCollections.service.impliments.DepartmentServiceImpl;
import pro.sky.demoCollections.service.impliments.EmployeeServiceImpl;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.demoCollections.constants.DepartmentServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeServiceImpl;
    @InjectMocks
    private DepartmentServiceImpl out;


    @Test
    void shouldFindMaxSalaryInDepartment() {
        when(employeeServiceImpl.getEmployeeMap()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, out.findMaxSalaryInDepartment(DEPARTMENT_ID2));

    }

    @Test
    void shouldThrowExceptionWhenEmployeeWithMaxSalaryNotInDepartment() {
        when(employeeServiceImpl.getEmployeeMap()).thenReturn(emptyList());
        assertThrows(InvalidInputException.class, () -> out.findMaxSalaryInDepartment(DEPARTMENT_ID2));
    }

    @Test
    void shouldThrowExceptionWhenEmployeeWithMinSalaryNotInDepartment() {
        when(employeeServiceImpl.getEmployeeMap()).thenReturn(emptyList());
        assertThrows(InvalidInputException.class, () -> out.findMinSalaryInDepartment(DEPARTMENT_ID2));
    }

    @Test
    void shouldFindMinSalaryInDepartment() {
        when(employeeServiceImpl.getEmployeeMap()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, out.findMinSalaryInDepartment(DEPARTMENT_ID2));
    }

    @Test
    void shouldReturnAllEmployees() {
        when(employeeServiceImpl.getEmployeeMap()).thenReturn(ALL_EMPLOYEES);
        assertEquals(GROUPING_BY_DEPARTMENTS_MAP, out.printSortedByDepartment());

    }

    @Test
    void shouldReturnEmptyList() {
        when(employeeServiceImpl.getEmployeeMap()).thenReturn(emptyList());
        assertEquals(emptyMap(), out.printSortedByDepartment());
    }

}
