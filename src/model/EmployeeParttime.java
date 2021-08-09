package model;

public class EmployeeParttime extends Employee {
    private Double worktime;
    private double totalSalary;

    public EmployeeParttime() {
    }

    public EmployeeParttime(String name, String status, int age, String gender, double salary, Double worktime) {
        super(name, status, age, gender, salary);
        this.worktime = worktime;
    }

    public Double getWorktime() {
        return this.worktime;
    }

    public void setWorktime(Double worktime) {
        this.worktime = worktime;
    }

    public double getTotalSalary() {
        return this.getSalary() * this.worktime;
    }

    public String toString() {
        String var10000 = this.getName();
        return "EmployeeParttime{Name='" + var10000 + "', Status='" + this.getStatus() + "'," +
                " Age=" + this.getAge() + ", Gender='" + this.getGender() + "', salary=" + this.getSalary() +
                "',Worktime=" + this.worktime + "}";
    }

    public String sho() {
        String var10000 = this.getName();
        return var10000 + "," + this.getStatus() + "," + this.getAge() + "," + this.getGender() + "," +
                this.getSalary() + "," + this.getWorktime();
    }
}
