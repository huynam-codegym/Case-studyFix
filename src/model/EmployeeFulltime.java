package model;

public class EmployeeFulltime extends Employee {
    public EmployeeFulltime() {
    }

    public EmployeeFulltime(String name, String Status, int age, String gender, double salary) {
        super(name, Status, age, gender, salary);
    }

    public String toString() {
        return "EmployeeFulltime{}" + super.toString();
    }
}