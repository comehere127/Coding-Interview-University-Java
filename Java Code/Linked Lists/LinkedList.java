// Implementation without the help of tail pointer

class Node {
    Node next;
    int data;
    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
    Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data) {
         Node newHead = new Node(data);
         newHead.next = head;
         head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int size() {
        if (head == null) return 0;

        Node current = head;
        int i = 0;
        while (current != null) {
            i++;
            current = current.next;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,7,8,9};
        // Creating a linked list with help of an array
        LinkedList l = new LinkedList();
        for (int i=0;i<arr.length;i++) {
            l.append(arr[i]);
        }

        // Printing the linked list
        l.print();

        // Getting the size of linked list
        System.out.println(l.size());
    }
}
