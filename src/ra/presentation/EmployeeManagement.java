package ra.presentation;

import ra.business.design.IDepartment;
import ra.business.design.IEmployee;
import ra.business.implement.EmployeeImplement;

import java.util.Scanner;

public class EmployeeManagement {
    public static IEmployee employee = new EmployeeImplement();

    public static void employeeManager() {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = true;
        do {
            System.out.println("======================MENU======================\n" +
                    "1.Hiển thị tất cả nhân viên\n" +
                    "2.Thêm mới nhân viên\n" +
                    "3.Sửa thông tin nhân viên\n" +
                    "4.Thay đổi trạng thái nhân viên\n" +
                    "5.Tìm kiếm nhân viên theo tên\n" +
                    "6.Tìm kiếm nhân viên theo mã phòng ban\n" +
                    "7.Sắp xếp nhân viên tên tăng dần\n" +
                    "8.Quay lại");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    employee.readData(scanner);
                    break;
                case 2:
                    employee.createData(scanner);
                    break;
                case 3:
                    employee.updateData(scanner);
                    break;
                case 4:
                    employee.changeStatus(scanner);
                    break;
                case 5:
                    employee.findEmployeeByName(scanner);
                    break;
                case 6:
                    employee.findEmployeeByDepartMent(scanner);
                    break;
                case 7:
                    employee.sortByName(scanner);
                    break;
                case 8:
                    isExit=false;
                    break;
                default:
                    System.out.println("Mời nhập lại");
            }
        }
        while (isExit);
    }
}
