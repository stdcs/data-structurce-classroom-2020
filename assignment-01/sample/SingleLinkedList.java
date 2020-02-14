import java.util.NoSuchElementException;

public class SingleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            size++;
            return;
        }
        if (tail == null) {
            tail = new Node(data);
            head.setPointer(tail);
            size++;
            return;
        }
        Node newNode = new Node(data);
        tail.setPointer(newNode);
        tail = newNode;
        size++;
    }

    public void append(int data, int newData) {
    }

    public void prepend(int data) {
        if (head == null) {
            head = new Node(data);
            size++;
            return;
        }
        Node newNode = new Node(data);
        newNode.setPointer(head);
        head = newNode;
        size++;
    }

    public void removeHead() {
        if (head == null) {
            throw new NoSuchElementException("Empty List");
        }
        head = head.getPointer();
        size--;
    }

    public void removeTail() {
        if (head == null) {
            throw new NoSuchElementException("Empty List");
        } else if (tail == null) {
            throw new NoSuchElementException("Head");
        } else if (tail == head) {
            throw new NoSuchElementException("Head is Tail");
        }
        Node node = head;
        while (node.getPointer().getPointer() != null) {
            node = node.getPointer();
        }
        node.setPointer(null);
        tail = node;
        size--;
    }

    public void contain(int data) {
        if (head == null) {
            throw new NoSuchElementException("Empty List");
        }
        if (head.getData() == data) {
            System.out.printf("{\n  data\t: %d\n  index\t: %d\n}\n", head.getData(), 0);
            return;
        }
        if (tail.getData() == data) {
            System.out.printf("{\n  data\t: %d\n  index\t: %d\n}\n", tail.getData(), size - 1);
            return;
        }
        Node node = head;
        int index = 0;
        while (node.hasPointer()) {
            if (node.getData() == data) {
                System.out.printf("{\n  data\t: %d\n  index\t: %d\n}\n", node.getData(), index);
                return;
            }
            node = node.getPointer();
            index++;
        }
        throw new NoSuchElementException("No Such Element");
    }

    public void unique() {
    }

    public void sort() {
    }

    public void traverse() {
        if (head == null) {
            System.out.println("Empty Linked List");
            return;
        }
        Node node = head;
        while (node.hasPointer()) {
            System.out.printf("[%d] -> ", node.getData());
            node = node.getPointer();
        }
        System.out.printf("[%d] -> null\n", node.getData());
    }
}
