package pro.sky.collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {

        this.employeeServiceImpl = employeeServiceImpl;
    }
    @GetMapping(path ="/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServiceImpl.findEmployee(firstName,lastName);
    }

    @GetMapping(path ="/add")
    public String addEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        employeeServiceImpl.addEmployee(firstName, lastName);
        return "Сотрудник "+firstName+" "+lastName+" успешно создан.";
    }

    @GetMapping(path ="/remove")
    public String removeEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        employeeServiceImpl.removeEmployees(firstName, lastName);
        return "Сотрудник " + firstName + " " + lastName + " удален";
    }

}
