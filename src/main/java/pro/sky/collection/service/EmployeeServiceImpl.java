package pro.sky.collection.service;

import org.springframework.stereotype.Service;
import pro.sky.collection.data.Employee;
import pro.sky.collection.exception.EmployeeNotFoundException;
import pro.sky.collection.exception.EmployeeStorageOverflowException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<Employee>();

    public Employee addEmployee(String firstName, String lastName) {
        validateData(firstName, lastName);
        Employee employee=new Employee(firstName,lastName);
        employees.add(employee);
        return employee;
    }

    private void validateData(String firstName, String lastName) {
        if (firstName == "" && lastName == "") {
            throw new EmployeeStorageOverflowException();
        }
    }

    public Employee removeEmployee(String firstName, String lastName){
        Employee employee=new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
            throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName){
        Employee employee=new Employee(firstName, lastName);
        validateData(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
        }

    public List<Employee> showAllEmployee() {
        return new ArrayList<>(employees);
    }
}
