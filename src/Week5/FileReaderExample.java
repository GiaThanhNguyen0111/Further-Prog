package Week5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderExample {
    public static void main(String[] args) {
        // Get list of integers from user
        List<Integer> integers = getIntegersFromUser();

        // Save list to binary file
        saveToBinaryFile(integers);

        // Save list to text file
        saveToTextFile(integers);

        // Compare the size and content of the two files
        compareFiles();
    }

    private static List<Integer> getIntegersFromUser() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = new ArrayList<>();

        System.out.println("Enter a list of integers (one per line, enter -1 to finish):");
        int input;
        while ((input = scanner.nextInt()) != -1) {
            integers.add(input);
        }

        return integers;
    }

    private static void saveToBinaryFile(List<Integer> integers) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("integers.bin"))) {
            outputStream.writeObject(integers);
            System.out.println("List of integers saved to binary file.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving to binary file: " + e.getMessage());
        }
    }

    private static void saveToTextFile(List<Integer> integers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("integers.txt"))) {
            for (Integer integer : integers) {
                writer.println(integer);
            }
            System.out.println("List of integers saved to text file.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving to text file: " + e.getMessage());
        }
    }

    private static void compareFiles() {
        File binaryFile = new File("integers.bin");
        File textFile = new File("integers.txt");

        System.out.println("Comparison results:");
        System.out.println("Binary file size: " + binaryFile.length() + " bytes");
        System.out.println("Text file size: " + textFile.length() + " bytes");

        try (BufferedReader binaryReader = new BufferedReader(new FileReader(binaryFile));
             BufferedReader textReader = new BufferedReader(new FileReader(textFile))) {
            String binaryLine;
            String textLine;
            int lineNumber = 1;
            while ((binaryLine = binaryReader.readLine()) != null && (textLine = textReader.readLine()) != null) {
                if (!binaryLine.equals(textLine)) {
                    System.out.println("Difference found at line " + lineNumber);
                    break;
                }
                lineNumber++;
            }
            System.out.println("Files compared successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while comparing files: " + e.getMessage());
        }
    }


    private static void problem1(Scanner scanner) {
        System.out.print("Enter the name of the text file: ");
        String fileName = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println("<<Content of line>>\n" + line);
                System.out.println("Continue (Enter) or Exit (X, then Enter)? ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("X")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
