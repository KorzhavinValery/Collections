package pro.sky.demoCollections.service;

import pro.sky.demoCollections.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartamentService {
    Employee findMaxSalaryInDepartment(int department);
    Employee findMinSalaryInDepartment(int department);

    Integer printSalaryPerDepartment(int department);

    Collection<Employee> printAllFromDepartment(int department);

    Map<Integer, List<Employee>> printSortedByDepartment();


}
