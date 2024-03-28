package ra.business.design;

import java.util.Scanner;

public interface CRUD {
    void createData(Scanner scanner);
    void readData(Scanner scanner);
    void updateData(Scanner scanner);
    void deleteData(Scanner scanner);
    int findIndexById(Scanner scanner);
    void changeStatus(Scanner scanner);
}
