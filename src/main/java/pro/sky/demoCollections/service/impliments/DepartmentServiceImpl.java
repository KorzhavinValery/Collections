package pro.sky.demoCollections.service.impliments;

import org.springframework.stereotype.Service;
import pro.sky.demoCollections.exceptions.InvalidInputException;
import pro.sky.demoCollections.model.Employee;
import pro.sky.demoCollections.service.DepartamentService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartamentService {
    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }


    @Override
    public Employee findMaxSalaryInDepartment(int department) {
        return employeeServiceImpl.getEmployeeMap().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(InvalidInputException::new);
    }

    @Override
    public Employee findMinSalaryInDepartment(int department) {
        return employeeServiceImpl.getEmployeeMap().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(InvalidInputException::new);
    }

    @Override
    public BigDecimal printSalaryPerDepartment(int department) {
        BigDecimal sum = employeeServiceImpl.getEmployeeMap()
                .stream().filter(employee -> employee.getDepartment()==department)
                .map(Employee::getSalary).reduce(BigDecimal::add).orElseThrow(InvalidInputException::new);
        return sum.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public Collection<Employee> printAllFromDepartment(int department) {
        return employeeServiceImpl.getEmployeeMap().stream().filter(employee -> employee.getDepartment() == department).toList();
    }

    @Override
    public Map<Integer, List<Employee>> printSortedByDepartment() {
        return employeeServiceImpl.getEmployeeMap().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
