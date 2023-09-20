package pro.sky.demoCollections.service.impliments;

import org.springframework.stereotype.Service;
import pro.sky.demoCollections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.demoCollections.exceptions.EmployeeNotFoundException;
import pro.sky.demoCollections.exceptions.EmployeeStorageIsFullException;
import pro.sky.demoCollections.model.Employee;
import pro.sky.demoCollections.service.EmployeeService;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employeeList;
    private static final int limitEmployees = 5;

    public EmployeeServiceImpl(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Уже есть такой пользователь");
        }
        if (employeeList.size() < limitEmployees) {
            employeeList.add(employee);
        } else throw new EmployeeStorageIsFullException("Лимит пользователей исчерпан");


        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }

        throw new EmployeeNotFoundException("Пользователь не найден");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Пользователь не найден");
    }

    @Override
    public List<Employee> getEmployeeList() {
        return Collections.unmodifiableList(employeeList);
    }
}
