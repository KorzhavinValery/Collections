package pro.sky.demoCollections.constants;

import pro.sky.demoCollections.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentServiceTestConstants {
    public static final String FIRST_NAME = "Fedor";
    public static final String LAST_NAME = "Symkin";
    public static final String FIRST_NAME1 = "Cliff";
    public static final String LAST_NAME1 = "Steel";
    public static final String FIRST_NAME2 = "Nick";
    public static final String LAST_NAME2 = "Colder";
    public static final int SALARY = 1000;
    public static final int MAX_SALARY = 77777;
    public static final int DEPARTMENT_ID = 5;
    public static final int DEPARTMENT_ID2 = 1;

    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME2, LAST_NAME2, MAX_SALARY, DEPARTMENT_ID2);
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID2);
    public static final Employee OTHER_DEPARTMENT_EMPLOYEE = new Employee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);

    public static final List<Employee> EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, MIN_SALARY_EMPLOYEE);
    public static final List<Employee> ALL_EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, MIN_SALARY_EMPLOYEE, OTHER_DEPARTMENT_EMPLOYEE);
    public static final Map<Integer,List<Employee>> GROUPING_BY_DEPARTMENTS_MAP = ALL_EMPLOYEES.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));
    public static final int DEPARTMENT_TOTAL_SALARY = EMPLOYEES.stream().mapToInt(Employee::getSalary).sum();


}
