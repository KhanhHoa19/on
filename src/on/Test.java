package on;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import static on.EmployeeType.EXPERIENCED;
import static on.EmployeeType.FRESHER;

public class Test {
    public static void writeEmployeesToFile(List<Employee> employees, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees have been written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readEmployeesFromFile(String fileName) {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees have been read from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public static void main(String[] args) {
    // Example usage:
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee(1, "John Doe","14-02-2005","0","m@gmail.com",EXPERIENCED));
    employees.add(new Employee(2, "Jane Smith", "01-01-2000","0","j@gmail.com",FRESHER));

    // Write employees to file
    writeEmployeesToFile(employees, "employees.txt");

    // Read employees from file
    List<Employee> employeesFromFile = readEmployeesFromFile("employees.txt");

    // Display employees read from file
    for (Employee employee : employeesFromFile) {
        employee.showInfo();
    }
}
}
