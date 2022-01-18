package pro.sky.collection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collection.data.Employee;
import pro.sky.collection.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {

        this.employeeServiceImpl = employeeServiceImpl;
    }
    @GetMapping("/find")
    public Employee employee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServiceImpl.findEmployee(firstName,lastName);
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        employeeServiceImpl.addEmployee(firstName, lastName);
        return "Сотрудник "+firstName+" "+lastName+" успешно создан.";
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        employeeServiceImpl.removeEmployee(firstName, lastName);
        return "Сотрудник " + firstName + " " + lastName + " удален";
    }

    @GetMapping("/all")
    public List<Employee> allEmployee() {
        return employeeServiceImpl.allEmployee();
    }

}
