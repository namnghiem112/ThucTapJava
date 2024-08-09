public class Main {
    public static Node insertNode(Node head, int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node current = head;
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position is greater than the length of the list.");
            return head;
        }

        newNode.next = current.next;
        current.next = newNode;

        return head;
    }
    public static Node deleteNode(Node head, int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return head;
        }

        if (position == 0) {
            head = head.next;
            return head;
        }

        Node current = head;
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Position is greater than the length of the list.");
            return head;
        }

        current.next = current.next.next;

        return head;
    }

    public static int count(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    public static int max(Node head) {
        if (head == null) {
            return -1;
        }

        int max = head.data;
        Node current = head;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }

    public static void main(String[] args) {

        Node head = null;
        head = insertNode(head, 10, 0);
        head = insertNode(head, 20, 1);
        head = insertNode(head, 30, 2);
        head = insertNode(head, 40, 1);

        head = deleteNode(head, 2);

        int count = count(head);
        System.out.println("Number of elements in the list: " + count);

        int maxValue = max(head);
        System.out.println("Maximum value in the list: " + maxValue);
    }
}