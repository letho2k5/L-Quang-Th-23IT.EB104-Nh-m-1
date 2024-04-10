import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.employeeCount++;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeByID(String ID) {
        for (Employee employee : employees) {
            if (employee.ID.equals(ID)) {
                return employee;
            }
        }
        return null;
    }

    public boolean removeEmployeeByID(String ID) {
        Employee employeeToRemove = null;
        for (Employee employee : employees) {
            if (employee.ID.equals(ID)) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            return true;
        }
        return false;
    }

    public void saveToFile(String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(employees);
            objectOut.close();
            fileOut.close();
            System.out.println("Employee information saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            employees = (List<Employee>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Employee information read from file: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
