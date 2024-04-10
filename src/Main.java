import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        connectDTB dbConnection = new connectDTB();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Employee Management System ====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Remove Employee");
            System.out.println("4. Save Employees to File");
            System.out.println("5. Load Employees from File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee(employeeManager, scanner);
                    break;
                case 2:
                    viewAllEmployees(employeeManager);
                    break;
                case 3:
                    removeEmployee(employeeManager, scanner);
                    break;
                case 4:
                    saveEmployeesToFile(employeeManager, scanner);
                    break;
                case 5:
                    loadEmployeesFromFile(employeeManager, scanner);
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
    private static void addEmployee(EmployeeManager employeeManager, Scanner scanner) {
        // Prompt user for employee details
        System.out.println("Enter Employee Details:");
        System.out.print("ID: ");
        String ID = scanner.nextLine();
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Birth Day: ");
        String birthDay = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Employee Type (Experience/Fresher/Intern): ");
        String employeeType = scanner.nextLine();

        switch (employeeType) {
            case "Experience":
                System.out.print("Years of Experience: ");
                int expInYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                System.out.print("Professional Skill: ");
                String proSkill = scanner.nextLine();
                employeeManager.addEmployee(new Experience(ID, fullName, birthDay, phone, email, employeeType, 1, expInYear, proSkill));
                break;
            case "Fresher":
                System.out.print("Graduation Date: ");
                String graduationDate = scanner.nextLine();
                System.out.print("Graduation Rank: ");
                String graduationRank = scanner.nextLine();
                System.out.print("Education: ");
                String education = scanner.nextLine();
                employeeManager.addEmployee(new Fresher(ID, fullName, birthDay, phone, email, employeeType, 1, graduationDate, graduationRank, education));
                break;
            case "Intern":
                System.out.print("Majors: ");
                String majors = scanner.nextLine();
                System.out.print("Semester: ");
                String semester = scanner.nextLine();
                System.out.print("University Name: ");
                String universityName = scanner.nextLine();
                employeeManager.addEmployee(new Intern(ID, fullName, birthDay, phone, email, employeeType, 1, majors, semester, universityName));
                break;
            default:
                System.out.println("Invalid employee type.");
        }
    }

    private static void viewAllEmployees(EmployeeManager employeeManager) {
        System.out.println("All Employees:");
        List<Employee> allEmployees = employeeManager.getAllEmployees();
        for (Employee employee : allEmployees) {
            employee.showInfo();
            System.out.println();
        }
    }

    private static void removeEmployee(EmployeeManager employeeManager, Scanner scanner) {
        System.out.print("Enter the ID of the employee to remove: ");
        String ID = scanner.nextLine();
        boolean removed = employeeManager.removeEmployeeByID(ID);
        if (removed) {
            System.out.println("Employee with ID '" + ID + "' removed successfully.");
        } else {
            System.out.println("Employee with ID '" + ID + "' not found.");
        }
    }

    private static void saveEmployeesToFile(EmployeeManager employeeManager, Scanner scanner) {
        System.out.print("Enter the file name to save: ");
        String fileName = scanner.nextLine();
        employeeManager.saveToFile(fileName);
    }

    private static void loadEmployeesFromFile(EmployeeManager employeeManager, Scanner scanner) {
        System.out.print("Enter the file name to load: ");
        String fileName = scanner.nextLine();
        employeeManager.readFromFile(fileName);
    }
}