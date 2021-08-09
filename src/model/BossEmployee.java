package model;

public class BossEmployee extends Employee {
    public BossEmployee(String name, String status, int age, String gender, double salary) {
        super(name, status, age, gender, salary);
    }

    public BossEmployee() {
    }

    public String toString() {
        return "model.BossOfficer{}";
    }
}
