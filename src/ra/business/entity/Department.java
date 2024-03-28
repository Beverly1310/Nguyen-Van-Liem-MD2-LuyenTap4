package ra.business.entity;

import java.util.ArrayList;
import java.util.Scanner;

import static ra.business.implement.DepartmentImplement.listDepartment;
import static ra.business.implement.EmployeeImplement.listEmployee;

public class Department {
    private int Id;
    private String name;
    private int numberEmployee;
    private boolean status;

    public Department() {
        this.Id = autoId();
        this.status = true;
        this.numberEmployee = 0;
    }

    public Department(int id, String name) {
        Id = autoId();
        this.name = name;
        this.numberEmployee = 0;
        this.status = true;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberEmployee() {
        return numberEmployee;
    }

    public void setNumberEmployee(int numberEmployee) {
        this.numberEmployee = numberEmployee;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        this.name = getDepartmentName(scanner);
    }

    public String getDepartmentName(Scanner scanner) {
        do {
            System.out.println("Nhập tên phòng ban: ");
            String inputDepartmentName = scanner.nextLine();
            if (inputDepartmentName.isBlank()) {
                System.err.println("Không được để trống");
            } else {
                boolean isExist = false;
                for (int i = 0; i < listDepartment.size(); i++) {
                    if (listDepartment.get(i).getName().equals(inputDepartmentName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên đã tồn tại");
                } else {
                    return inputDepartmentName;
                }
            }

        }
        while (true);
    }


    public boolean getStatus(Scanner scanner) {
        System.out.println("Nhập trạng thái của phòng ban: ");
        boolean statusDepartment = Boolean.parseBoolean(scanner.nextLine());
        return statusDepartment;
    }

    public int autoId() {
        int maxId = 0;
        for (int i = 0; i < listDepartment.size(); i++) {
            if (listDepartment.get(i).getId() > maxId) {
                maxId = listDepartment.get(i).getId();
            }
        }
        return maxId + 1;
    }

    public void displayData() {
        System.out.printf("Mã phòng ban: %-5d || Tên phòng ban: %-15s || Số lượng nhân viên: %-5d || Trạng thái: %-10s",
                this.Id, this.name, this.numberEmployee, this.status ? "Hoạt động" : "Không hoạt động");
        System.out.println("\n=======================================");
    }
}
