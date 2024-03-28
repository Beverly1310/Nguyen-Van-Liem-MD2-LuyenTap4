package ra.business.implement;

import ra.business.design.CRUD;
import ra.business.design.IDepartment;
import ra.business.entity.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentImplement implements IDepartment {
    public static List<Department> listDepartment = new ArrayList<>();

    @Override
    public void createData(Scanner scanner) {
        System.out.println("Nhập số phòng ban muốn thêm:");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập tên cho phòng ban thứ " + (i + 1));
            Department newDepartment = new Department();
            newDepartment.inputData(scanner);
            listDepartment.add(newDepartment);
        }
    }

    @Override
    public void readData(Scanner scanner) {
        System.out.println("Danh sách phòng ban: ");
        for (int i = 0; i < listDepartment.size(); i++) {
            listDepartment.get(i).displayData();
        }
    }

    @Override
    public void updateData(Scanner scanner) {
        readData(scanner);
        int indexDepartment = findIndexById(scanner);
        if (indexDepartment != -1) {
            do {
                System.out.println("Chọn thông tinh muốn thay đổi\n" +
                        "1.Tên phòng ban\n" +
                        "2.Trạng thái\n" +
                        "3.Thoát\n" +
                        "Mời nhập lựa chọn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println(listDepartment.get(indexDepartment).getName());
                        listDepartment.get(indexDepartment).setName("");
                        listDepartment.get(indexDepartment).inputData(scanner);
                        break;
                    case 2:
                        listDepartment.get(indexDepartment).getStatus(scanner);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Mời nhập lại");
                        break;
                }
            }
            while (true);
        } else {
            System.err.println("Không tìm thấy phòng ban");
        }
    }

    @Override
    public void deleteData(Scanner scanner) {
        readData(scanner);
        int deleteIndex = findIndexById(scanner);
        if (deleteIndex != -1) {
            listDepartment.remove(deleteIndex);
        } else {
            System.err.println("Phòng ban không tồn tại");
        }
    }

    @Override
    public void changeStatus(Scanner scanner) {
        readData(scanner);
        int indexDepartment = findIndexById(scanner);
        if (indexDepartment!=-1){
            listDepartment.get(indexDepartment).setStatus(!listDepartment.get(indexDepartment).isStatus());
            System.out.println("Thay đổi trạng thái thành công");
        } else {
            System.err.println("Phòng ban không tồn tại");
        }
    }

    @Override
    public void searchDepartmentByName(Scanner scanner) {
        System.out.println("Nhập tên của phòng ban");
        String nameDepartment = scanner.nextLine();
        listDepartment.stream().filter(department -> department.getName().equals(nameDepartment)).forEach(Department::displayData);
    }


    @Override
    public int findIndexById(Scanner scanner) {
        System.out.println("Nhập Id của phòng ban");
        int idDepartment = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < listDepartment.size(); i++) {
            if (listDepartment.get(i).getId() == idDepartment) {
                return i;
            }
        }
        return -1;
    }

}
