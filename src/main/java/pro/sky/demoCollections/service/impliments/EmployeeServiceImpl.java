package pro.sky.demoCollections.service.impliments;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.demoCollections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.demoCollections.exceptions.EmployeeNotFoundException;
import pro.sky.demoCollections.exceptions.EmployeeStorageIsFullException;
import pro.sky.demoCollections.exceptions.InvalidInputException;
import pro.sky.demoCollections.model.Employee;
import pro.sky.demoCollections.service.EmployeeService;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap;
    private static final int limitEmployees = 5;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, String salary, int department) {
        validateInput(firstName, lastName);

        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Уже есть такой пользователь");
        }
        if (employeeMap.size() < limitEmployees) {
            employeeMap.put(employee.getFullName(), employee);
        } else throw new EmployeeStorageIsFullException("Лимит пользователей исчерпан");


        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, String salary, int department) {
        validateInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsKey(employee.getFullName())) {
            return employeeMap.remove(employee.getFullName());

        }

        throw new EmployeeNotFoundException("Пользователь не найден");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, String salary, int department) {
        validateInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsKey(employee.getFullName())) {
            return employeeMap.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Пользователь не найден");
    }

    @Override
    public Collection<Employee> getEmployeeMap() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }

    private void validateInput(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new InvalidInputException();
        }
    }
}