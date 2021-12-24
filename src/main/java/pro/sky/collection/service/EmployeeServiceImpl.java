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

    public EmployeeServiceImpl() {
        this.employees=new ArrayList<Employee>();
    }

    public Employee addEmployee(String firstName, String lastName) {
        if (firstName == "" && lastName == "") {
            throw new EmployeeStorageOverflowException();
        }
        Employee newEmployees=new Employee(firstName,lastName);
        employees.add(newEmployees);
        return newEmployees;
    }

    public Employee removeEmployees(String firstName, String lastName){
        Employee employeeRemove=new Employee(firstName, lastName);
        for (Employee employee:employees) {
            if (employees == null) {
                continue;
            }
            if (firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName())) {
                employees.remove(employeeRemove);
                return employeeRemove;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName){
        Employee employeeFind=new Employee(firstName, lastName);
            if (firstName == "" && lastName == ""){
                throw new EmployeeNotFoundException();
            }
            for (Employee employee:employees) {
                if (employees == null) {
                    continue;
                }
                if (firstName.equals(employee.getFirstName()) && lastName.equals(employee.getLastName())) {
                    return employeeFind;
                }
            }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> allEmployee() {
        if (employees == null) {
            throw new EmployeeNotFoundException();
        }
        return employees;
    }
}
