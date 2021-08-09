package view;

import controller.ManagerEmployee;
import controller.ManagerUser;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        ManagerUser.menu1();
    }

    public static void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ManagerEmployee huynam = new ManagerEmployee();
        huynam.readFile();

        while(true) {
            System.out.println("******** Hello MENU ********");
            System.out.println("1.<---- Bạn muốn thêm nhân viên---->");
            System.out.println("2.<---- Bạn muốn tìm kiếm nhân viên---->");
            System.out.println("3.<---- Bạn muốn kiểm tra trạng thái nhân viên---->");
            System.out.println("4.<---- Bạn muốn sửa thông tin nhân viên---->");
            System.out.println("5.<-----Bạn muốn thay đổi trạng thái nhân viên----->");
            System.out.println("6.<-----Hiển thị thông tin tài khoản----->");
            int choice = 0;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception var8) {
                System.out.println("-- Mời bạn nhập lại--");
            }

            switch(choice) {
                case 1:
                    System.out.println("1.---- Bạn muốn thêm nhân viên full_time----");
                    System.out.println("2.----Bạn muốn thêm nhân viên part_time----");
                    int choice2 = 0;

                    try {
                        choice2 = Integer.parseInt(scanner.nextLine());
                    } catch (Exception var9) {
                        System.out.println("--Mời bạn nhập lại--");
                    }

                    switch(choice2) {
                        case 1:
                            huynam.add("Full-time");
                            huynam.writeFile();
                            huynam.show();
                            continue;
                        case 2:
                            huynam.add("Part-Time");
                            huynam.writeFile();
                            huynam.show();
                        default:
                            continue;
                    }
                case 2:
                    huynam.Seach();
                    break;
                case 3:
                    huynam.Status();
                    System.out.println("-----Bạn muốn hiển thị lương nhân viên không----");
                    System.out.println("1:có");
                    System.out.println("2:không");
                    int choi = Integer.parseInt(scanner.nextLine());
                    switch(choi) {
                        case 1:
                            huynam.Slary();
                        case 2:
                        default:
                            continue;
                    }
                case 4:
                    System.out.println("<----bạn muốn đổi thông tin nhân viên hay xoá nhân viên---->");
                    System.out.println("1:<---tôi muốn thay đổi thông tin---->");
                    System.out.println("2:<----tôi muốn xoá nhân viên---->");
                    int choice4 = Integer.parseInt(scanner.nextLine());
                    switch(choice4) {
                        case 1:
                            System.out.println("<---nhập tên nhân viên muốn sửa--->");
                            String name = scanner.nextLine();
                            huynam.update(name);
                            huynam.show();
                            continue;
                        case 2:
                            huynam.delete();
                            huynam.show();
                        default:
                            continue;
                    }
                case 5:
                    huynam.updatestatus();
                    huynam.show();
                    System.out.println("<------bạn có muốn hiển thị danh sách nhân viên theo trạng thái----->");
                    System.out.println("1:<----có---->");
                    System.out.println("2:<----không---->");
                    int choice3 = Integer.parseInt(scanner.nextLine());
                    switch(choice3) {
                        case 1:
                            huynam.Status_();
                        case 2:
                        default:
                            continue;
                    }
                case 6:
                    ManagerUser.showuser();
                    System.out.println("bạn có muốn đăng xuất khỏi chương trình không?");
                    System.out.println("1:<-----có----->");
                    System.out.println("2:<----không---->");
                    int choice5 = Integer.parseInt(scanner.nextLine());
                    switch(choice5) {
                        case 1:
                            ManagerUser.menu1();
                        case 2:
                        default:
                            continue;
                    }
                default:
                    return;
            }
        }
    }
}