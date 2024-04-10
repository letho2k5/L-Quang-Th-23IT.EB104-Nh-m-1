import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Employee implements IEmployee, Serializable {
    private static final long serialVersionUID = 1L;
    protected String ID;
    protected String fullName;
    protected String birthDay;
    protected String phone;
    protected String email;
    protected String employeeType;
    protected int employeeCount;

    public Employee(String ID, String fullName, String birthDay, String phone, String email, String employeeType, int employeeCount) {
        this.ID = ID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        this.employeeCount = employeeCount;
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Full Name: " + fullName);
        System.out.println("Birth Day: " + birthDay);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Employee Type: " + employeeType);
        System.out.println("Employee Count: " + employeeCount);
    }
}