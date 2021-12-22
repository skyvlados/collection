package pro.sky.collection;

public interface EmployeeService {
    public Employee addEmployee(String firstName, String lastName);
    public Employee removeEmployees(String firstName, String lastName);
    public Employee findEmployee(String firstName, String lastName);
}
