package ra.business.design;

import java.util.Scanner;

public interface IEmployee extends CRUD {
    void findEmployeeByName(Scanner scanner);
    void findEmployeeByDepartMent(Scanner scanner);
    void sortByName(Scanner scanner);
}
