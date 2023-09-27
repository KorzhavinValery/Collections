package pro.sky.demoCollections.service;

import pro.sky.demoCollections.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, String salary, int department);

    Employee removeEmployee(String firstName, String lastName, String salary, int department);

    Employee findEmployee(String firstName, String lastName, String salary, int department);

    Collection<Employee> getEmployeeMap();
}