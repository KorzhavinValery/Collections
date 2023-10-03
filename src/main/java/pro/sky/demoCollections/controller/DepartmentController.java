package pro.sky.demoCollections.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.demoCollections.model.Employee;
import pro.sky.demoCollections.service.DepartamentService;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
    private final DepartamentService departamentService;

    public DepartmentController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee findMaxSalaryFromDepartment(@RequestParam int departmentId) {
        return departamentService.findMaxSalaryInDepartment(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee findMinSalaryFromDepartment(@RequestParam int departmentId) {
        return departamentService.findMinSalaryInDepartment(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> printAllFromDepartment() {
        return departamentService.printSortedByDepartment();
    }
    @GetMapping(path = "/all", params = "departmentId")
    public Collection<Employee> printAllFromDepartment(@RequestParam (value = "departmentId") int departmentId) {
        return departamentService.printAllFromDepartment(departmentId);
    }

    @GetMapping(path = "/sum-salary")
    public BigDecimal printSalaryPerDepartment(@RequestParam int departmentId) {
        return departamentService.printSalaryPerDepartment(departmentId);
    }


}
