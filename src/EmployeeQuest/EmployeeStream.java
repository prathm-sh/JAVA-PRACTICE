package EmployeeQuest;
//Problem Statement: Java Employee Management System (Service Layer)
//
//Objective:
//Design and implement an Employee Management System in Java using an ArrayList as the in-memory data store. You must create an Employee model class and an EmployeeService class that enforces business validation rules and implements specific query methods.
//
//        1. Model Requirements (Employee)
//
//Create an Employee class with the following attributes:
//        * id (int)
//* name (String)
//* department (String)
//* salary (double)
//Validation Rule:
//        * Salary Check: The salary must be strictly greater than 0 (salary > 0). If a value less than or equal to 0 is passed during creation or update, throw an IllegalArgumentException.
//
//        2. Service Layer Requirements (EmployeeService)
//
//Implement the EmployeeService class backed by a List<Employee> (ArrayList) with the following methods:
//        1. addEmployee(Employee emp): Adds a new employee to the list. Employee ID must be unique. If an employee with the same ID already exists, throw an IllegalArgumentException (or a custom DuplicateEmployeeException).
//        2. findEmployeeById(int id): Searches for an employee by ID and returns an Optional<Employee>.
//        3. removeEmployee(int id): Removes the employee with the given ID from the list and returns true if removed, or false if not found.
//        4. getHighestSalary() / getHighestPaidEmployee(): Returns the highest salary (OptionalDouble) or the highest-paid employee (Optional<Employee>) in the company.
//        5. getEmployeesByDepartmentSortedBySalary(String department): Filters employees belonging to the specified department (case-insensitive) and returns a List<Employee> sorted by salary in ascending (or descending) order.
//        6. getAllEmployees(): Returns a safe list (List<Employee>) containing all stored employees without exposing the internal list reference directly.
import java.util.*;
import java.util.stream.Collectors;

class EmployeeService{
    List<Employee> employees = new ArrayList<>();

    public void addEmployee(int id,String name,String department,double salary){

        boolean hasId = employees.stream()
                        .anyMatch(emp -> emp.getId() == id);
        if(hasId)
            throw new IllegalArgumentException("Id already exists");
        else
            employees.add(new Employee(id,name,department,salary));

    }
    public Optional<Employee> findEmployeeById(int id){
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    public boolean removeEmployee(int id){
        return employees.removeIf(employee -> employee.getId()==id);
    }

    public Optional<Employee> getHighestPaidEmployee(){
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
    }
    public Optional<Double> getHighestSalary(){
        return employees.stream()
                .map(emp->emp.getSalary())
                .max((e1,e2)->Double.compare(e1,e2));
    }

    public List<Employee> getEmployeesByDepartmentSortedBySalary(String department){
        return employees.stream()
                .filter(emp->emp.getDepartment().equalsIgnoreCase(department))
                .sorted((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary()))
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployees(){
        return  employees.stream().toList();
    }
}

public class EmployeeStream {

    public static void main(String[] args){
        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee(1,"Prathmesh","IT",90000);
        employeeService.addEmployee(2,"Ramesh","QC",80000);
        employeeService.addEmployee(3,"Ganesh","QC",810000);
        employeeService.addEmployee(4,"Akash","QC",10000);

        System.out.println(employeeService.findEmployeeById(1).get());
        System.out.println(employeeService.removeEmployee(1));
        System.out.println(employeeService.getHighestPaidEmployee());
        System.out.println(employeeService.getHighestSalary());
        System.out.println(employeeService.getEmployeesByDepartmentSortedBySalary("qc"));




    }



}
