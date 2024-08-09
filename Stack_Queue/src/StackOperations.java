import java.util.Scanner;
import java.util.Stack;

public class StackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        while (true) {
            System.out.println("=============================================");
            System.out.println("               Stack Operations Menu         ");
            System.out.println("=============================================");
            System.out.println("1. Push an item");
            System.out.println("2. Delete item");
            System.out.println("3. Show the number of items");
            System.out.println("4. Show min and max items");
            System.out.println("5. Print all items");
            System.out.println("6. Find all primes in stack");
            System.out.println("7. Delete all items");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter item to push: ");
                    int item = scanner.nextInt();
                    stack.push(item);
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        stack.pop();
                        System.out.println("Item deleted.");
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 3:
                    System.out.println("Number of items in stack: " + stack.size());
                    break;
                case 4:
                    showMinMax(stack);
                    break;
                case 5:
                    printAllItems(stack);
                    break;
                case 6:
                    findAllPrimes(stack);
                    break;
                case 7:
                    stack.clear();
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

    private static void showMinMax(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int item : stack) {
            if (item < min) min = item;
            if (item > max) max = item;
        }
        System.out.println("Min item: " + min);
        System.out.println("Max item: " + max);
    }

    private static void printAllItems(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack items:");
        for (int item : stack) {
            System.out.println(item);
        }
    }

    private static void findAllPrimes(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Prime numbers in stack:");
        for (int item : stack) {
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
