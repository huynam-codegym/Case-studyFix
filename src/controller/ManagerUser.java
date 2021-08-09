package controller;

import model.User;
import view.Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ManagerUser {
    static ArrayList<User> list = new ArrayList();
    static Scanner scanner;
    static User nam;
    static File huynamuser;
    static String tieudeu;

    public ManagerUser() {
    }

    public static User gettem() {
        return nam;
    }

    public static void menu1() throws IOException {
        while(true) {
            System.out.println("1.đăng nhập tài khoản");
            System.out.println("2.đăng ký tài khoản");
            System.out.println("3.exit");
            int choice = 0;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception var2) {
                System.out.println("nhập lại");
            }

            switch(choice) {
                case 1:
                    login();
                    break;
                case 2:
                    signUp();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    private static void login() throws IOException {
        System.out.println("nhập tên đăng nhập");
        String UserName = scanner.nextLine();
        System.out.println("nhập mật khẩu");
        String passwork = scanner.nextLine();
        read();
        Iterator var2 = list.iterator();

        User namuser;
        do {
            if (!var2.hasNext()) {
                System.out.println("thông tin mật khẩu hoặc tài khoản không đúng");
                System.out.println("mời bạn trải nghiệm với vị trí nhân viên thường");
                ManagerBoss.menu2();
                return;
            }

            namuser = (User)var2.next();
        } while(!namuser.getUsername().equalsIgnoreCase(UserName) || !namuser.getPasswork().equalsIgnoreCase(passwork));

        System.out.println("---welcom---" + UserName);
        nam = namuser;
        Main.menu();
    }

    private static void signUp() throws IOException {
        System.out.println("nhập tên đăng ký");
        String name = scanner.nextLine();
        System.out.println("nhập mật khẩu đăng ký");
        String pass = scanner.nextLine();
        read();
        Iterator var2 = list.iterator();

        User namuser;
        do {
            if (!var2.hasNext()) {
                System.out.println("đăng ký thành công");
                list.add(new User(name, pass));
                write();
                login();
                return;
            }

            namuser = (User)var2.next();
        } while(!namuser.getUsername().equals(name));

        System.out.println(" XIn lỗi tài khoản đã tồn tại");
    }

    public static void write() {
        try {
            FileWriter fileWriter = new FileWriter("src/huynamuser.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(tieudeu);
            Iterator var2 = list.iterator();

            while(var2.hasNext()) {
                User gg = (User)var2.next();
                bufferedWriter.newLine();
                bufferedWriter.write(gg.shoe());
            }

            bufferedWriter.close();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public static void read() {
        try {
            FileReader fileReader = new FileReader("src/huynamuser.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                list.add(new User(arr[0], arr[1]));
            }
        } catch (FileNotFoundException var4) {
            var4.printStackTrace();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public static void showuser() {
        System.out.println(gettem().shoe());
    }

    static {
        scanner = new Scanner(System.in);
        huynamuser = new File("src/huynamuser.csv");
        tieudeu = "tai khoan,mat khau";
    }
}