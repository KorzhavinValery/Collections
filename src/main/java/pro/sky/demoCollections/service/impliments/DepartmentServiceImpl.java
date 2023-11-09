package pro.sky.demoCollections.service.impliments;

import org.springframework.stereotype.Service;
import pro.sky.demoCollections.exceptions.InvalidInputException;
import pro.sky.demoCollections.model.Employee;
import pro.sky.demoCollections.service.DepartamentService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartamentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee findMaxSalaryInDepartment(int department) {
        return employeeService.getEmployeeMap().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(InvalidInputException::new);
    }

    @Override
    public Employee findMinSalaryInDepartment(int department) {
        return employeeService.getEmployeeMap().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(InvalidInputException::new);
    }

    @Override
    public Integer printSalaryPerDepartment(int department) {
       return employeeService.getEmployeeMap()
                .stream()
               .filter(employee -> employee.getDepartment()==department)
                .collect(Collectors.summingInt(empl -> empl.getSalary()));
                };




    @Override
    public Collection<Employee> printAllFromDepartment(int department) {
        return employeeService.getEmployeeMap().stream().filter(employee -> employee.getDepartment() == department).toList();
    }

    @Override
    public Map<Integer, List<Employee>> printSortedByDepartment() {
        return employeeService.getEmployeeMap().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
