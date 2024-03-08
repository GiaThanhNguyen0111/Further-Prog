package Week1.test;

import Week1.main.Student;

public class StudentTest2 {
    public static void main(String [] args) {
        Student student = new Student();
        student.setStudentId(1);
        student.setName("Thanh");
        student.setMajor("IT");

        System.out.println(student);
    }
}
