package pro.sky.demoCollections.service;

import java.util.List;

public interface EmployeeService {
    void addEmployee(String firstName, String lastName);

     Employee removeEmployee(String firstName, String lastName);

     Employee findEmployee(String firstName, String lastName);

    List<Employee> getEmployeeList();
}
