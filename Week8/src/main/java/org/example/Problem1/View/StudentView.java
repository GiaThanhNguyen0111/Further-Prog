package org.example.Problem1.View;

import org.example.Problem1.View.Controller.StudentController;
import org.example.Problem1.View.Controller.StudentInterface;
import org.example.Problem1.View.Model.StudentModel;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StudentView {
    private Set<StudentModel> setStudent;

    private Scanner scanner;

    private final StudentInterface studentInterface;

    public StudentView() {
        this.setStudent = new HashSet<>();
        this.studentInterface = new StudentController();
        this.scanner = new Scanner(System.in);
    }

    public void editStudent() {
        System.out.println("Edit a Student");
        System.out.print("Enter id: ");
        Long id = scanner.nextLong();
        System.out.print("Enter name to change: ");
        String fullName = scanner.next();
        System.out.print("Enter major to change: ");
        String major = scanner.next();
        System.out.print("Enter address to change: ");
        String address = scanner.next();
        System.out.print("Enter GPA to change: ");
        Double GPA = scanner.nextDouble();

        StudentModel newStudent = new StudentModel(id, fullName, address, major, GPA);

        studentInterface.editStudent(newStudent, setStudent);
    }

    public void addStudent() {
        System.out.println("Create new Student");
        System.out.print("Enter id: ");
        Long id = scanner.nextLong();
        System.out.print("Enter name: ");
        String fullName = scanner.next();
        System.out.print("Enter major: ");
        String major = scanner.next();
        System.out.print("Enter address: ");
        String address = scanner.next();
        System.out.print("Enter GPA: ");
        Double GPA = scanner.nextDouble();

        StudentModel newStudent = new StudentModel(id, fullName, address, major, GPA);

        studentInterface.createStudent(newStudent, setStudent);
    }

    public void closeScanner() {
        scanner.close();
    }
}
