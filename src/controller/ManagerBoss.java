package controller;

import java.io.IOException;
import java.util.Scanner;

public class ManagerBoss {
    public ManagerBoss() {
    }

    public static void menu2() throws IOException {
        while(true) {
            ManagerEmployee managerOfficer = new ManagerEmployee();
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.hiển thị danh sách nhân viên");
            System.out.println("2.hiển thị mức lương của nhân viên");
            System.out.println("3.exit");
            int choice = 0;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception var4) {
                System.out.println("nhập lại");
            }

            switch(choice) {
                case 1:
                    managerOfficer.readFile();
                    managerOfficer.show();
                    break;
                case 2:
                    managerOfficer.readFile();
                    managerOfficer.Slary();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
