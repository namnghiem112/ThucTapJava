import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        while (true) {
            System.out.println("=============================================");
            System.out.println("               Queue Operations Menu         ");
            System.out.println("=============================================");
            System.out.println("1. Add an item");
            System.out.println("2. Delete item");
            System.out.println("3. Show the number of items");
            System.out.println("4. Show min and max items");
            System.out.println("5. Print all items");
            System.out.println("6. Find all primes in queue");
            System.out.println("7. Delete all items");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter item to add: ");
                    int item = scanner.nextInt();
                    queue.add(item);
                    break;
                case 2:
                    if (!queue.isEmpty()) {
                        queue.remove();
                        System.out.println("Item deleted.");
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 3:
                    System.out.println("Number of items in queue: " + queue.size());
                    break;
                case 4:
                    showMinMax(queue);
                    break;
                case 5:
                    printAllItems(queue);
                    break;
                case 6:
                    findAllPrimes(queue);
                    break;
                case 7:
                    queue.clear();
                    System.out.println("All items deleted.");
                    break;
                case 8:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }
    }

    private static void showMinMax(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int item : queue) {
            if (item < min) min = item;
            if (item > max) max = item;
        }
        System.out.println("Min item: " + min);
        System.out.println("Max item: " + max);
    }

    private static void printAllItems(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue items:");
        for (int item : queue) {
            System.out.println(item);
        }
    }

    private static void findAllPrimes(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Prime numbers in queue:");
        for (int item : queue) {
            if (isPrime(item)) {
                System.out.println(item);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
