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

    @GetMapping(path = "/{id}/salary/max")
    public Employee findMaxSalaryFromDepartment(@PathVariable(value = "id") int departmentId) {
        return departamentService.findMaxSalaryInDepartment(departmentId);
    }

    @GetMapping(path = "/{id}/salary/min")
    public Employee findMinSalaryFromDepartment(@PathVariable (value = "id") int departmentId) {
        return departamentService.findMinSalaryInDepartment(departmentId);
    }

    @GetMapping(path = "/{id}/salary/sum")
    public BigDecimal printSalaryPerDepartment(@PathVariable (value = "id") int departmentId) {
        return departamentService.printSalaryPerDepartment(departmentId);
    }

    @GetMapping(path = "/{id}/employees")
    public Collection<Employee> printAllFromDepartment(@PathVariable (value = "id") int departmentId) {
        return departamentService.printAllFromDepartment(departmentId);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> printAllFromDepartment() {
        return departamentService.printSortedByDepartment();
    }


}
