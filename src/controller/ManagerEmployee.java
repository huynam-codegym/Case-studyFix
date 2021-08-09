package controller;

import model.Employee;
import model.EmployeeFulltime;
import model.EmployeeParttime;
import view.RegexGender;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ManagerEmployee {
    Scanner scanner;
    ArrayList<Employee> list;
    int count;
    File huynam;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    String mucluc;

    public ManagerEmployee() {
        this.scanner = new Scanner(System.in);
        this.list = new ArrayList();
        this.count = 0;
        this.huynam = new File("huynam.csv");
        this.mucluc = "tên,trạng thái,tuổi ,giới tính,lương";
    }

    public void add(String type) {
        Employee officer;
        if (type.equals("Part-Time")) {
            officer = this.creat(type);
        } else {
            officer = this.creat(type);
        }

        this.list.add(officer);
        ++this.count;
        System.out.println("đang quản lý " + this.count + " nhân viên");
    }

    public Employee creat(String type) {
        while(true) {
            System.out.println("---nhập tên nhân viên---");
            String Name = this.scanner.nextLine();
            if (Name != "") {
                Integer age;
                while(true) {
                    try {
                        System.out.println("---nhập tuổi nhân viên---");
                        age = Integer.parseInt(this.scanner.nextLine());
                        break;
                    } catch (Exception var13) {
                        System.out.println("---tuổi phải là số---");
                    }
                }

                String Gender;
                while(true) {
                    try {
                        System.out.println("--- Hãy nhập giới tính nhân viên:nam/nu---");
                        Gender = this.scanner.nextLine();
                        if (RegexGender.validate(Gender)) {
                            break;
                        }
                    } catch (Exception var12) {
                        System.out.println("---Chỉ 2 giới tính trên là hợp lệ--- ");
                    }
                }

                String Status;
                while(true) {
                    try {
                        System.out.println("--- Bạn hãy nhập trạng thái nhân viên:true/false---");
                        Status = this.scanner.nextLine();
                        if (RegexGender.valida(Status)) {
                            break;
                        }
                    } catch (Exception var11) {
                        System.out.println("---nhân viên chỉ có 2 trạng thái---");
                    }
                }

                Double salary;
                while(true) {
                    try {
                        System.out.println("---nhập lương cứng nhân viên---");
                        salary = Double.parseDouble(this.scanner.nextLine());
                        break;
                    } catch (NumberFormatException var10) {
                        System.out.println("---lương phải là số---");
                    }
                }

                if (type.equals("Part-Time")) {
                    System.out.println("---nhập số giờ làm của nhân viên parttime---");
                    double WorkTime = Double.parseDouble(this.scanner.nextLine());
                    Employee officer = new EmployeeParttime(Name, Status, age, Gender, salary, WorkTime);
                    return officer;
                }

                Employee officer = new EmployeeFulltime(Name, Status, age, Gender, salary);
                return officer;
            }

            System.out.println("---hãy điền đầy đủ họ tên---");
        }
    }

    public void delete() {
        System.out.println("---nhập tên nhân viên muốn xoá---");
        String name = this.scanner.nextLine();

        int i;
        for(i = 0; i < this.list.size(); ++i) {
            if (((Employee)this.list.get(i)).getName().equals(name)) {
                PrintStream var10000 = System.out;
                String var10001 = ((Employee)this.list.get(i)).toString();
                var10000.println(var10001 + "---đang ở vị trí thứ--- " + i);
            }
        }

        System.out.println("---nhập vị trí nhân viên muốn xoá---");
        i = Integer.parseInt(this.scanner.nextLine());
        Employee officer = (Employee)this.list.get(i);
        if (officer.getName().equals(name)) {
            this.list.remove(officer);
        }

        try {
            this.writeFile();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void update(String name) {
        int index;
        for(index = 0; index < this.list.size(); ++index) {
            if (((Employee)this.list.get(index)).getName().equals(name)) {
                PrintStream var10000 = System.out;
                String var10001 = ((Employee)this.list.get(index)).toString();
                var10000.println(var10001 + " ---đang ở vị trí thứ---" + index);
            }
        }

        System.out.println("---nhập vị trí của nhân viên thay đổi---");
        index = Integer.parseInt(this.scanner.nextLine());
        Employee officer;
        if (this.list.get(index) instanceof EmployeeParttime) {
            officer = this.creat("Part-Time");
        } else {
            officer = this.creat("Full-Time");
        }

        this.list.set(index, officer);
    }

    public void show() {
        Iterator var1 = this.list.iterator();

        while(var1.hasNext()) {
            Employee ahihi = (Employee)var1.next();
            System.out.println(ahihi);
            System.out.println("");
        }

    }

    public void Seach() {
        System.out.println("---nhập nhân viên bạn muốn tìm kiếm---");
        String Name = this.scanner.nextLine();
        Iterator var2 = this.list.iterator();

        while(var2.hasNext()) {
            Employee gg = (Employee)var2.next();
            if (gg.getName().contains(Name)) {
                System.out.println("---nhân viên bạn cần tìm kiếm là:" + gg);
            }
        }

    }

    public void Status() {
        System.out.println("---nhập tên nhân viên bạn muốn kiểm tra---");
        String name = this.scanner.nextLine();
        Iterator var2 = this.list.iterator();

        while(var2.hasNext()) {
            Employee hh = (Employee)var2.next();
            if (hh.getName().equals(name)) {
                System.out.println(hh.getStatus());
            }
        }

    }

    public void updatestatus() {
        System.out.println("---bạn muốn cập nhật tình trạng của nhân viên nào---");
        String name = this.scanner.nextLine();

        for(int i = 0; i < this.list.size(); ++i) {
            if (((Employee)this.list.get(i)).getName().equals(name)) {
                System.out.println("---Sửa trạng thái thành---");
                ((Employee)this.list.get(i)).setStatus(this.scanner.nextLine());
            }
        }

    }

    public void writeFile() throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(this.huynam);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(this.mucluc);
            Iterator var3 = this.list.iterator();

            while(var3.hasNext()) {
                Employee gg = (Employee)var3.next();
                bufferedWriter.newLine();
                bufferedWriter.write(gg.sho());
            }

            bufferedWriter.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void readFile() {
        try {
            FileReader fileReader = new FileReader(this.huynam);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr.length == 5) {
                    this.list.add(new EmployeeFulltime(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3], Double.parseDouble(arr[4])));
                } else {
                    this.list.add(new EmployeeParttime(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3], Double.parseDouble(arr[4]), Double.parseDouble(arr[5])));
                }
            }
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    public void Status_() {
        System.out.println("---Nhân viên đang đi làm là---");

        int i;
        for(i = 0; i < this.list.size(); ++i) {
            if (((Employee)this.list.get(i)).getStatus().equals("true")) {
                System.out.println(((Employee)this.list.get(i)).getName());
            } else {
                System.out.println("---Không có nhân viên trên ở đây---");
            }
        }

        System.out.println("---nhân viên đã nghỉ làm là---");

        for(i = 0; i < this.list.size(); ++i) {
            if (!((Employee)this.list.get(i)).getStatus().equals("true")) {
                System.out.println(((Employee)this.list.get(i)).getName());
            }
        }

    }

    public void Slary() {
        System.out.println("---lương nhân viên pass time là:---");

        PrintStream var10000;
        String var10001;
        int i;
        for(i = 0; i < this.list.size(); ++i) {
            if (this.list.get(i) instanceof EmployeeParttime) {
                var10000 = System.out;
                var10001 = ((Employee)this.list.get(i)).getName();
                var10000.println("tên nhân viên " + var10001 + " có tiền lương là" +
                        ((EmployeeParttime)this.list.get(i)).getTotalSalary());
            }
        }

        System.out.println("---lương nhân viên full time là:---");

        for(i = 0; i < this.list.size(); ++i) {
            if (this.list.get(i) instanceof EmployeeFulltime) {
                var10000 = System.out;
                var10001 = ((Employee)this.list.get(i)).getName();
                var10000.println("Tên nhân viên" + var10001 + " có tiền lương là" +
                        ((EmployeeFulltime)this.list.get(i)).getSalary());
            }
        }

    }
}
