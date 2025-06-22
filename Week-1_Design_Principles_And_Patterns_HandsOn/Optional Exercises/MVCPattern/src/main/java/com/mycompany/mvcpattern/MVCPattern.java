package com.mycompany.mvcpattern;
import java.util.Scanner;
public class MVCPattern {

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter student grade: ");
        String grade = sc.nextLine();

        Student student = new Student(name, id, grade);
        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        controller.updateView();

        System.out.println("\nUpdate student info? (yes/no): ");
        String choice = sc.nextLine().toLowerCase();

        if (choice.equals("yes")) {
            System.out.print("New name: ");
            controller.setStudentName(sc.nextLine());

            System.out.print("New ID: ");
            controller.setStudentId(sc.nextLine());

            System.out.print("New grade: ");
            controller.setStudentGrade(sc.nextLine());

            System.out.println("\nUpdated student details:");
            controller.updateView();
        }

        sc.close();
    }
}