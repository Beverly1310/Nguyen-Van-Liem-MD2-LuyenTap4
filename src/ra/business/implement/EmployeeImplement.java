package ra.business.implement;

import ra.business.design.CRUD;
import ra.business.design.IEmployee;
import ra.business.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ra.business.implement.DepartmentImplement.listDepartment;

public class EmployeeImplement implements IEmployee {
    public static List<Employee> listEmployee = new ArrayList<>();

    @Override
    public void createData(Scanner scanner) {
        System.out.println("Nhập số nhân viên muốn thêm: ");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhân viên thứ: " + (i + 1));
            Employee newEmployee = new Employee();
            newEmployee.inputData(scanner);
            listEmployee.add(newEmployee);
        }
    }

    @Override
    public void readData(Scanner scanner) {
        int firstIndexOfPage = 0;
        int lastIndexOfPage = 2;
        int elementPerPage = 3;
        int page = 1;
        int numberOfPage;
        if (listEmployee.size() % elementPerPage == 0) {
            numberOfPage = listEmployee.size() / elementPerPage;
        } else {
            numberOfPage = listEmployee.size() / elementPerPage + 1;
        }

        do {
            for (int i = 0; i < listEmployee.size(); i++) {
                if (i >= firstIndexOfPage && i <= lastIndexOfPage) {
                    listEmployee.get(i).displayData();
                }
            }

            System.out.println("Trang : " + page + "/" + numberOfPage);
            if (page == 1) {
                System.out.println("2.Trang sau");
                System.out.println("3.Thoát");
            } else if (page == numberOfPage) {
                System.out.println("1.Trang Trước");
                System.out.println("3.Thoát");
            } else {
                System.out.println("1.Trang trước  ||  2.Trang sau");
                System.out.println("3.Thoát");
            }
            System.out.println("Mời nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    firstIndexOfPage -= elementPerPage;
                    lastIndexOfPage -= elementPerPage;
                    page -= 1;
                    break;
                case 2:
                    firstIndexOfPage += elementPerPage;
                    lastIndexOfPage += elementPerPage;
                    page += 1;
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
        while (true);


    }


    @Override
    public void updateData(Scanner scanner) {
        readData(scanner);
        int updateIndex = findIndexById(scanner);
        if (updateIndex != -1) {
            listEmployee.get(updateIndex).displayData();
            listEmployee.get(updateIndex).setFullName("");
            listEmployee.get(updateIndex).inputData(scanner);
        } else {
            System.out.println("Nhân viên không tồn ");
        }
    }

    @Override
    public void deleteData(Scanner scanner) {
        readData(scanner);
        int deleteIndex = findIndexById(scanner);
        if (deleteIndex != -1) {
            listEmployee.remove(deleteIndex);
        } else {
            System.out.println("Nhân viên không tồn tại");
        }
    }

    @Override
    public void changeStatus(Scanner scanner) {
        readData(scanner);
        int indexEmployee = findIndexById(scanner);
        listEmployee.get(indexEmployee).setStatus(!listEmployee.get(indexEmployee).isStatus());
    }

    @Override
    public void findEmployeeByName(Scanner scanner) {
        System.out.println("Nhập tên nhân viên cần tìm kiếm: ");
        String inputEmployeeName = scanner.nextLine();
        boolean isExist = false;
        for (int i = 0; i < listEmployee.size(); i++) {
            if (listEmployee.get(i).getFullName().equals(inputEmployeeName)) {
                listEmployee.get(i).displayData();
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Nhân viên không tồn tại");
        }
    }

    @Override
    public void findEmployeeByDepartMent(Scanner scanner) {
        System.out.println("Nhập tên phòng ban: ");
        String inputDepartmentName = scanner.nextLine();
        boolean isExist = false;
        boolean isExistEmployee = false;
        for (int i = 0; i < listDepartment.size(); i++) {
            if (inputDepartmentName.equals(listEmployee.get(i).getDepartment().getName())) {
                isExist = true;
                break;
            }
        }
        if (isExist) {
            for (int j = 0; j < listEmployee.size(); j++) {
                if (listEmployee.get(j).getDepartment().getName().equals(inputDepartmentName)) {
                    listEmployee.get(j).displayData();
                    isExistEmployee = true;
                }
            }
            if (!isExistEmployee) {
                System.out.println("Phòng ban không có nhân viên nào");
            }
        }
    }

    @Override
    public void sortByName(Scanner scanner) {
        listEmployee = listEmployee.stream().sorted((o1, o2) -> {
            return o1.getFullName().compareTo(o2.getFullName());
        }).toList();
        readData(scanner);
    }

    @Override
    public int findIndexById(Scanner scanner) {
        System.out.println("Nhập Id của nhân viên");
        int idEmployee = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < listEmployee.size(); i++) {
            if (listEmployee.get(i).getId() == idEmployee) {
                return i;
            }
        }
        return -1;
    }
}
