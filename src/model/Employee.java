package model;

public class Employee {
    private String Name;
    private String Status;
    private int Age;
    private String Gender;
    private double salary;

    public Employee() {
    }

    public Employee(String name, String status, int age, String gender, double salary) {
        this.Name = name;
        this.Status = status;
        this.Age = age;
        this.Gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getStatus() {
        return this.Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public int getAge() {
        return this.Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public String getGender() {
        return this.Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "model.Officer{Name='" + this.Name + "', Status='" + this.Status + "', Age=" + this.Age + ", Gender='" + this.Gender + "', salary=" + this.salary + "}";
    }

    public String sho() {
        return this.Name + "," + this.Status + "," + this.Age + "," + this.Gender + "," + this.salary;
    }
}
