import java.io.*;
import java.util.*;

public class studentMain {
    public static void main(String[] args) throws FileNotFoundException {
        // 1. Check arguments
        String filename = args[args.length - 1];

        // 2. Read student data from file
        List<studentClass> students = new ArrayList<>();
        Scanner fileScanner = new Scanner(new File(filename));

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] data = line.split(",");

            if (data.length > 3 && isNumber(data[1])) {
                int position = Integer.parseInt(data[0].trim()); // Column 1: is Position
                int sid = Integer.parseInt(data[1].trim()); // Column 2: is ID
                String fname = data[2].trim(); // Column 3: is First Name
                String lname = data[3].trim(); // Column 4: is Last Name
                // Create studentClass object and add to list
                // Adding position avoiding confusion and checking purpose
                students.add(new studentClass(position, sid, fname, lname));
            }
        }
        fileScanner.close();

        // 3. Loop through all arguments except the last one (filename)
        for (int i = 0; i < args.length - 1; i++) {
            String option = args[i];

            System.out.println("\n--- Sorting by " + option + " ---");

            if (option.equals("-n")) {
                // Sort by student ID
                System.out.println("Sorting by student ID: ");
                students.sort((s1, s2) -> s1.getSid() - s2.getSid());
                printStudents(students);
            } else if (option.equals("-f")) {
                // Sort by first name
                System.out.println("Sorting by first name: ");
                students.sort((s1, s2) -> s1.getFname().compareTo(s2.getFname()));
                printStudents(students);
            } else if (option.equals("-l")) {
                // Sort by last name
                System.out.println("Sorting by last name: ");
                students.sort((s1, s2) -> s1.getLname().compareTo(s2.getLname()));
                printStudents(students);
            }
        }
    }

    // Method to print student data
    public static void printStudents(List<studentClass> students) {
        for (studentClass student : students) {
            System.out.println(student.getPosition() + ": " + student.getSid() + " " + student.getFname() + " "
                    + student.getLname());
        }
    }

    // Method to check if a string is a number
    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
