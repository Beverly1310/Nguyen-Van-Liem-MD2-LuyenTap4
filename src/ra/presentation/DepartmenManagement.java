package ra.presentation;

import ra.business.design.IDepartment;
import ra.business.implement.DepartmentImplement;

import java.util.Scanner;

public class DepartmenManagement {
    public static IDepartment department = new DepartmentImplement();

    public static void departmentManager() {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = true;
        do {
            System.out.println("======================MENU======================\n" +
                    "1.Hiển thị tất cả phòng ban\n" +
                    "2.Thêm mới phòng ban\n" +
                    "3.Sửa thông tin phòng ban\n" +
                    "4.Thay đổi trạng thái phòng ban\n" +
                    "5.Tìm kiếm phòng ban theo tên\n" +
                    "6.Quay lại");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    department.readData(scanner);
                    break;
                case 2:
                    department.createData(scanner);
                    break;
                case 3:
                    department.updateData(scanner);
                    break;
                case 4:
                    department.changeStatus(scanner);
                    break;
                case 5:
                    department.searchDepartmentByName(scanner);
                    break;
                case 6:
                    isExit=false;
                    break;
                default:
                    System.out.println("Mời nhập lại");
            }
        }
        while (isExit);
    }
    }


