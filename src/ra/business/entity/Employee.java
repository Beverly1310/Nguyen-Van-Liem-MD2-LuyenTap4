package ra.business.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static ra.business.implement.DepartmentImplement.listDepartment;
import static ra.business.implement.EmployeeImplement.listEmployee;

public class Employee {
    private int id;
    private String fullName;
    private String address;
    private String phone;
    private LocalDate dateOfBirth;
    private Department department;
    private boolean status;

    public Employee() {
        this.id = autoId();
        this.status = true;
    }

    public Employee(String fullName, String address, String phone, LocalDate dateOfBirth, Department department) {
        this.id = autoId();
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.status = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
this.fullName = getEmployeeName(scanner);
this.address =getEmployeeAddress(scanner);
this.phone = getPhoneEmployee(scanner);
this.dateOfBirth=getDateOfBirthEmployee(scanner);
this.department=getDepartmentEmployee(scanner);
this.status=getStatusEmployee(scanner);
    }

    public String getEmployeeName(Scanner scanner) {
        do {
            System.out.println("Nhập tên nhân viên:");
            String nameEmployee = scanner.nextLine();
            if (nameEmployee.isBlank()) {
                System.err.println("Tên không được để trống");
            } else {
                return nameEmployee;
            }
        }
        while (true);
    }

    public String getEmployeeAddress(Scanner scanner) {
        do {
            System.out.println("Nhập địa chỉ nhân viên:");
            String addressEmployee = scanner.nextLine();
            if (addressEmployee.isBlank()) {
                System.err.println("Địa chỉ không được để trống");
            } else {
                return addressEmployee;
            }
        }
        while (true);
    }

    public String getPhoneEmployee(Scanner scanner) {
        do {
            System.out.println("Nhập SDT nhân viên:");
            String phoneEmployee = scanner.nextLine();
            String regex = "^\\+?(?:0|84)(?:3[2-9]|5[6-9]|7[0|6-9]|8[1-9]|9[0-9])\\d{7}$";
            if (phoneEmployee.matches(regex)) {
                return phoneEmployee;
            } else {
                System.err.println("SDT không đúng định dạng");
            }
        }
        while (true);
    }

    public LocalDate getDateOfBirthEmployee(Scanner scanner) {
        do {
            System.out.println("Nhập ngày sinh của nhân viên(dd/MM/yyyy): ");
            String dateOfBirthEmployee = scanner.nextLine();
            String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d{2}$";
            if (dateOfBirthEmployee.matches(regex)) {
                return LocalDate.parse(dateOfBirthEmployee, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } else {
                System.err.println("Ngày sinh không đúng định dạng (dd/MM/yyyy)");
            }
        } while (true);
    }
    public Department getDepartmentEmployee(Scanner scanner){
        System.out.println("Nhập tên phòng ban cho nhân viên");
        for (int i = 0; i < listDepartment.size(); i++) {
            System.out.println((i+1)+". "+listDepartment.get(i).getName());
        }
        String nameDepartment = scanner.nextLine();
        for (int i = 0; i < listDepartment.size(); i++) {
            if (listDepartment.get(i).getName().equals(nameDepartment)){
                listDepartment.get(i).setNumberEmployee(listDepartment.get(i).getNumberEmployee()+1);
                return listDepartment.get(i);
            }
        }
        return null;
    }
    public boolean getStatusEmployee(Scanner scanner){
        System.out.println("Nhập trạng thái cho nhân viên");
        return Boolean.parseBoolean(scanner.nextLine());
    }
    public void displayData(){
        System.out.printf("Mã nhân viên : %-5d || Họ và tên: %-15s || Địa chỉ: %-15s\n",this.id,this.fullName,this.address);
        System.out.printf("Số điện thoại: %-10s || Ngày sinh: %-10s\n",this.phone,dateOfBirth.toString());
        System.out.printf("Phòng ban: %-15s || Trạng thái: %-15s\n",this.department.getName(),this.status?"Đang làm việc":"Thôi việc");
        System.out.println("==========================================");
    }
    public int autoId() {
        int maxId = 0;
        for (int i = 0; i < listEmployee.size(); i++) {
            if (listEmployee.get(i).getId() > maxId) {
                maxId = listEmployee.get(i).getId();
            }
        }
        return maxId + 1;
    }
}
