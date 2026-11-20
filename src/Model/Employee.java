package Model;

//Employee: int id, String name, String department, double salary, int yearsOfService

import java.time.LocalDate;

public class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;
    private int yearsOfService;
    private LocalDate joiningDate;


    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }


    public Employee(int id,String name,String department,double salary,int yearsOfService,LocalDate joiningDate) {
        this.joiningDate = joiningDate;
        this.yearsOfService = yearsOfService;
        this.salary = salary;
        this.department = department;
        this.name = name;
        this.id = id;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", yearsOfService=" + yearsOfService +
                '}';
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }
}
