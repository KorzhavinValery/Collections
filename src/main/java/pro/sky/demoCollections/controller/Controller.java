package pro.sky.demoCollections.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.demoCollections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.demoCollections.exceptions.EmployeeNotFoundException;
import pro.sky.demoCollections.exceptions.EmployeeStorageIsFullException;
import pro.sky.demoCollections.service.Employee;
import pro.sky.demoCollections.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class Controller {
    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public ResponseEntity<?> addEmployee(@RequestParam String firstName,
                                         @RequestParam String lastName) {
        try {
            employeeService.addEmployee(firstName, lastName);
            Employee employee = new Employee(firstName, lastName);
            return ResponseEntity.ok(employee);
        } catch (EmployeeStorageIsFullException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Лимит добавления пользователей исчерпан.");
        } catch (EmployeeAlreadyAddedException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Пользователь уже создан");
        }
    }

    @GetMapping(path = "/remove")
    public ResponseEntity<?> removeEmployee(@RequestParam String firstName,
                                            @RequestParam String lastName) {
        try {
            Employee removedEmployee = employeeService.removeEmployee(firstName, lastName);
            return ResponseEntity.ok(removedEmployee);
        } catch (EmployeeNotFoundException e) {
            return new ResponseEntity("ФИО не найдено", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/find")
    public ResponseEntity<?> findEmployee(@RequestParam String firstName,
                                                 @RequestParam String lastName) {
        try {
            Employee findEmployee = employeeService.findEmployee(firstName, lastName);
            return ResponseEntity.ok(findEmployee);
        } catch (EmployeeNotFoundException e) {
            return new ResponseEntity<>("ФИО не найдено", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> printAll() {
        List<Employee> employeeList = employeeService.getEmployeeList();
        return ResponseEntity.ok(employeeList);
    }
}
