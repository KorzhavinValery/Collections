package pro.sky.demoCollections.service.impliments;

import org.springframework.stereotype.Service;
import pro.sky.demoCollections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.demoCollections.exceptions.EmployeeNotFoundException;
import pro.sky.demoCollections.exceptions.EmployeeStorageIsFullException;
import pro.sky.demoCollections.service.Employee;
import pro.sky.demoCollections.service.EmployeeService;

import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employeeList;
    private static final int limitEmployees = 5;

    public EmployeeServiceImpl(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public void addEmployee(String firstName, String lastName) {

        for (Employee employee : employeeList) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("Пользователь уже создан");
            }
        }
        if (employeeList.size() < limitEmployees) {
            employeeList.add(new Employee(firstName, lastName));

        } else {
            throw new EmployeeStorageIsFullException("Лимит добавления пользователей исчерпан.");
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee signEmployee = null;
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName())) {
                signEmployee = employee;
                employeeIterator.remove();
            }
        }
        if (signEmployee == null) {
            throw new EmployeeNotFoundException("Пользователя с таким именем не найдено.");
        }
        return signEmployee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee searchEmployee = null;
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName())) {
                searchEmployee = employee;
                return searchEmployee;
            }
        }
        if (searchEmployee == null) {
            throw new EmployeeNotFoundException("Пользователя с таким именем не найдено.");
        }
        return searchEmployee;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }
}
