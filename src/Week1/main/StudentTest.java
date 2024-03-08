package Week1.main;

import java.io.*;
import java.util.*;

public class StudentTest {
    private static Set<Lecture> leaders;

    private static ArrayList<Student> students = new ArrayList<>();

    private static ObjectOutputStream writer;
    private static ObjectInputStream reader;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args) {
        try {
            File fs = new File("file1.bin");
            if (fs.exists()) {
                reader = new ObjectInputStream(new FileInputStream("file1.bin"));
                students = (ArrayList<Student>) reader.readObject();

                students.stream()
                        .filter(student -> student.getStudentType().equals("FULL"))
                        .map(student -> {
                            student.setName(student.getName().toUpperCase());
                            return student;
                        })
                        .sorted(Comparator.comparingDouble(Student::getGPA).reversed())
                        .forEach(System.out::println);
            }

            while (true) {
                System.out.print("Enter id: ");
                int id = scanner.nextInt();
                System.out.print("Enter name: ");
                String name = scanner.next();
                System.out.print("Enter major: ");
                String major = scanner.next();
                System.out.print("Enter student type");
                String studentType = scanner.next();
                System.out.print("Enter GPA: ");
                double GPA = scanner.nextDouble();
                Student s1 = new Student(id, name, major, GPA, studentType);
                students.add(s1);

                System.out.print("Do you want to add another student? (yes/no): ");
                String choice = scanner.next();
                if (!choice.equalsIgnoreCase("yes")) {
                    break;
                }
            }

            writer = new ObjectOutputStream(new FileOutputStream("file1.bin"));
            writer.writeObject(students);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter data of the correct type.");
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (writer != null)
                    writer.close();
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
