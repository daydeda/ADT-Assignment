import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkshopMain {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        Random random = new Random();

        System.out.println("Adding 10 applicants to the list...");
        for (int i = 1; i <= 10; i++) {
            List<String> vaccines = new ArrayList<>();
            if (i % 2 == 0)
                vaccines.add("Pfizer");
            if (i % 3 == 0)
                vaccines.add("Moderna");
            if (vaccines.isEmpty())
                vaccines.add("Sinovac");

            list.insertLast(new CovidVaccine(
                    "SID" + String.format("%03d", i),
                    "First" + i,
                    "Last" + i,
                    vaccines));
        }
        list.traversal();
        System.out.println("Current size: " + list.getSize());
        System.out.println("--------------------------------------------------");

        System.out.println("Deleting 2 applicants at random indices...");
        int size = list.getSize();
        if (size >= 2) {
            int index1 = random.nextInt(size);
            int index2;
            do {
                index2 = random.nextInt(size - 1);
            } while (index2 == index1);

            list.deleteAtIndex(index1);

            int newSize = list.getSize();
            int finalIndex2 = random.nextInt(newSize);
            list.deleteAtIndex(finalIndex2);
        }
        System.out.println("--------------------------------------------------");

        System.out.println("Traversing Key List (Should have 8 nodes):");
        list.traversal();
        System.out.println("Current size: " + list.getSize());
        System.out.println("--------------------------------------------------");

        System.out.println("Deleting all applicants...");
        list.deleteAll();
        System.out.println("--------------------------------------------------");
        System.out.println("Checking if list is empty...");
        if (list.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            System.out.println("List is NOT empty. Size: " + list.getSize());
        }
        list.traversal();
    }
}
