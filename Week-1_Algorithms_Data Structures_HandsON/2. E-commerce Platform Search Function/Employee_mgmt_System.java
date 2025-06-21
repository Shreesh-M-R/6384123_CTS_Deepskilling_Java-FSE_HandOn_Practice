/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employee_mgmt_system;

import java.util.Scanner;

public class Employee_mgmt_System {

   static Employee[] employees = new Employee[100]; 
    static int count = 0;

    // Add employee
    public static void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count] = e;
            count++;
            System.out.println("Employee added");
        } else {
            System.out.println("Employee list is full");
        }
    }

    // Search employee by ID
    public static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee Found:");
                employees[i].display();
                return;
            }
        }
        System.out.println("Employee not found");
    }

    // Traverse (show all employees)
    public static void showAllEmployees() {
        if (count == 0) {
            System.out.println("No employees in the system");
            return;
        }
        System.out.println("Employee List:");
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    // Delete employee by ID
    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                // Shift remaining elements
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                System.out.println("Employee deleted");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Management Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Show All Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Position: ");
                    String position = sc.nextLine();

                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();

                    addEmployee(new Employee(id, name, position, salary));
                }

                case 2 -> {
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    searchEmployee(searchId);
                }

                case 3 -> showAllEmployees();

                case 4 -> {
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();
                    deleteEmployee(deleteId);
                }

                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
