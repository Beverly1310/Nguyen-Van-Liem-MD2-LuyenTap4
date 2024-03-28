package ra.presentation;

import javax.print.attribute.standard.Finishings;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = true;
        do {
            System.out.println("=======================MENU=======================\n" +
                    "1.Quản lý phòng ban\n" +
                    "2.Quản lý nhân viên\n" +
                    "3.Thoát\n" +
                    "Mời nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    DepartmenManagement.departmentManager();
                    break;
                case 2:
                    EmployeeManagement.employeeManager();
                    break;
                case 3:
                    isExit=false;
                    break;
                default:
                    System.out.println("Mời nhập lại");
            }
        }
        while (isExit);
    }
}