package pro.sky.demoCollections.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.demoCollections.model.Employee;
import pro.sky.demoCollections.service.impliments.DepartmentServiceImpl;
import pro.sky.demoCollections.service.impliments.EmployeeService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static pro.sky.demoCollections.constants.DepartmentServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentServiceImpl out;





    @Test
    void shouldFindMaxSalaryInDepartment() {
        when(employeeService.getEmployeeMap()).thenReturn(EMPLOYEES);
        Employee maxSalary = out.findMaxSalaryInDepartment(EMPLOYEES.get(0).getDepartment());
        assertEquals(EMPLOYEES.get(0), maxSalary);

    }
    @Test
    void shouldThrowExceptionWhenEmployeeWithMaxSalaryNotInDepartment() {

    }

    @Test
    void shouldThrowExceptionWhenEmployeeWithMinSalaryNotInDepartment() {

    }

    @Test
    void shouldFindMinSalaryInDepartment() {
        when(employeeService.getEmployeeMap()).thenReturn(EMPLOYEES);
        Employee minSalary = out.findMinSalaryInDepartment(EMPLOYEES.get(0).getDepartment());
        assertEquals(EMPLOYEES.get(3), minSalary);
    }

    @Test
    void shouldReturnAllEmployees() {
        when(employeeService.getEmployeeMap()).thenReturn(ALL_EMPLOYEES);
        assertEquals(GROUPING_BY_DEPARTMENTS_MAP, out.printSortedByDepartment());

    }

    @Test
    void shouldReturnEmptyList() {

    }
}
