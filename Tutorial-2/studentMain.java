import java.util.Scanner;
import java.io.*;

public static void main(String[] args) throws FileNotFoundException {
    Scanner fileInput = new Scanner(new File("students.txt"));
    while (fileInput.hasNextLine()) {
        String line = fileInput.nextLine();
        System.out.println(line);
    }
    fileInput.close();
}