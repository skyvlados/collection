package pro.sky.collection.service;

import pro.sky.collection.data.Employee;

public interface EmployeeService {
    public Employee addEmployee(String firstName, String lastName);
    public Employee removeEmployees(String firstName, String lastName);
    public Employee findEmployee(String firstName, String lastName);
}
