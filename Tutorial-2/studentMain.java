import java.io.*;
import java.util.*;

public static void main(String[] args) throws FileNotFoundException {
    // 1. Check arguments
    if (args.length != 2) {
        System.out.println("Usage: $>java studentMain -[n/f/l] [filename]");
        return;
    }
    String option = args[0];
    String filename = args[1];

    // 2. Read student data from file
    List<studentClass> students = new ArrayList<>();
    Scanner fileScanner = new Scanner(new File(filename));

    while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        String[] data = line.split(",");

        if (data.length > 3 && isNumber(data[1])) {
            int sid = Integer.parseInt(data[1].trim()); // Column 2: is ID
            String fname = data[2].trim(); // Column 3: is First Name
            String lname = data[3].trim(); // Column 4: is Last Name
            students.add(new studentClass(sid, fname, lname));
        }
    }

    // 3. Sort based on the option
    if (option.equals("-n")) {
        // Sort by student ID
        System.out.println("Sorting by student ID: ");
        students.sort((s1, s2) -> s1.getSid() - s2.getSid());
    } else if (option.equals("-f")) {
        // Sort by first name
        System.out.println("Sorting by first name: ");
        students.sort((s1, s2) -> s1.getFname().compareTo(s2.getFname()));
    } else if (option.equals("-l")) {
        // Sort by last name
        System.out.println("Sorting by last name: ");
        students.sort((s1, s2) -> s1.getLname().compareTo(s2.getLname()));
    }

    // 4. Print sorted student data
    for (studentClass student : students) {
        System.out.println(student.getSid() + ", " + student.getFname() + ", " + student.getLname());
    }
    fileScanner.close();
}

public static boolean isNumber(String str) {
    try {
        Integer.parseInt(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}