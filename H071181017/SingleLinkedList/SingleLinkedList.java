import java.util.NoSuchElementException;

public class SingleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void append(T data) {
        if (head == null) {
            head = new Node<T>(data);
            size++;
            return;
        }
        if (tail == null) {
            tail = new Node<T>(data);
            head.setPointer(tail);
            size++;
            return;
        }
        Node<T> newNode = new Node<T>(data);
        tail.setPointer(newNode);
        tail = newNode;
        size++;
    }

    public void appendAfterData(T data, T after) {
        if (head == null) {
            head = new Node<T>(data);
            size++;
            return;
        }
        if (tail == null) {
            tail = new Node<T>(data);
            head.setPointer(tail);
            size++;
            return;
        }

        Node<T> node = head;
        Node<T> newNode = new Node<T>(data);

        while (node.getPointer() != null) {
            if (node.getData() == after) {
                newNode.setPointer(node.getPointer());
                node.setPointer(newNode);
                size++;
                return;
            }
            if (tail.getData() == after || node.getData() != after) {
                append(data);
                size++;
                return;
            }
            node = node.getPointer();
        }
    }

    public void appendAfterIndex(T data, int index) {
        if (head == null) {
            head = new Node<T>(data);
            size++;
            return;
        }
        if (tail == null) {
            tail = new Node<T>(data);
            head.setPointer(tail);
            size++;
            return;
        }

        int pos = 0;
        Node<T> node = head;
        Node<T> newNode = new Node<T>(data);

        while (node.getPointer() != null) {
            if (pos == index) {
                newNode.setPointer(node.getPointer());
                node.setPointer(newNode);
                size++;
                return;
            }
            pos++;
            node = node.getPointer();
        }
        if ((size - 1) == index || pos != index) {
            append(data);
            size++;
            return;
        }
    }

    public void appendVarargs(T... datas) {
        for (T data : datas) {
            append(data);
            size++;
        }
    }

    public void prependVarargs(T... datas) {
        for (T data : datas) {
            prepend(data);
            size++;
        }
    }

    public void mergeAppend(SingleLinkedList<T> list) {
        tail.setPointer(list.head);
        tail = list.tail;
        size += list.size;
        return;
    }

    public void mergePrepend(SingleLinkedList<T> list) {
        head = list.head;
        list.tail.setPointer(list.head);
        size += list.size;
        return;
    }

    public void prepend(T data) {
        if (head == null) {
            head = new Node<T>(data);
            size++;
            return;
        }

        if (tail == null) {
            tail = head;
            Node<T> newNode = new Node<T>(data);
            newNode.setPointer(tail);
            head = newNode;
            size++;
            return;
        }
        Node<T> newNode = new Node<T>(data);
        newNode.setPointer(head);
        head = newNode;
        size++;
    }

    public void prependBeforeData(T data, T before) {
        Node<T> newNode = new Node<T>(data);

        if (head == null) {
            head = new Node<T>(data);
            size++;
            return;
        }
        if (tail == null) {
            tail = head;
            newNode.setPointer(tail);
            head = newNode;
            size++;
            return;
        }

        Node<T> node = head;

        while (node.getPointer().getPointer() != null) {
            if (node.getPointer().getData() == before) {
                newNode.setPointer(node.getPointer());
                node.setPointer(newNode);
                size++;
                return;
            }
            if (node.getData() == before || node.getData() != before) {
                prepend(data);
                size++;
                return;
            }
            node = node.getPointer();
        }
    }

    public void prependBeforeIndex(T data, int index) {
        if (head == null) {
            head = new Node<T>(data);
            size++;
            return;
        }
        if (tail == null) {
            tail = new Node<T>(data);
            head.setPointer(tail);
            size++;
            return;
        }

        int pos = 0;
        Node<T> node = head;
        Node<T> newNode = new Node<T>(data);

        while (node.getPointer().getPointer() != null) {
            if ((pos + 1) == index) {
                newNode.setPointer(node.getPointer());
                node.setPointer(newNode);
                size++;
                return;
            }
            if (0 == index || pos != index) {
                prepend(data);
                size++;
                return;
            }
            node = node.getPointer();
            pos++;
        }
    }

    public void removeByData(T data) {
        Node<T> node = head;
        while (node.getPointer().getPointer() != null) {
            if (node.getPointer().getData() == data) {
                node.setPointer(node.getPointer().getPointer());
                size--;
                return;
            }
            if (node.getData() == data) {
                removeHead();
            }
            node = node.getPointer();
        }
        if (tail.getData() == data) {
            removeTail();
        }
    }

    public void removeByIndex(int index) {
        int pos = 0;
        Node<T> node = head;
        while (node.getPointer().getPointer() != null) {
            if (index - pos == 1) {
                node.setPointer(node.getPointer().getPointer());
                size--;
                return;
            }
            pos++;
            node = node.getPointer();
        }
        if (0 == index) {
            removeHead();
        }
        if (size == index) {
            removeTail();
        }
        if ((size - 1) < index) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
    }

    public void removeAfterData(T data) {
        Node<T> node = head;
        while (node.getPointer() != null) {
            if (node.getData() == data) {
                node.setPointer(node.getPointer().getPointer());
                size--;
                return;
            }
            node = node.getPointer();
        }
        if (node.getPointer() == tail) {
            node.setPointer(null);
            tail = node;
        }
    }

    public void removeAfterIndex(int index) {
        int pos = 0;
        Node<T> node = head;
        while (node.getPointer().getPointer() != null) {
            if (pos == index) {
                node.setPointer(node.getPointer().getPointer());
                size--;
                return;
            }
            pos++;
            node = node.getPointer();
        }
        if (size - index == 2) {
            removeTail();
        }
        if ((size - 1) < index) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
    }

    public void removeBeforeData(T data) {
        Node<T> node = head;
        while (node.getPointer().getPointer() != null) {
            if (node.getData() == data) {
                node.setPointer(node.getPointer().getPointer());
                size--;
                return;
            }
            node = node.getPointer();
        }
        if (head.getData() == data) {
            removeHead();
        }
    }

    public void removeBeforeIndex(int index) {
        Node<T> node = head;
        int pos = 0;

        if ((pos + 1) == index) {
            head = head.getPointer();
            size--;
            return;
        }
        while (node.getPointer() != null) {
            if ((index) - pos == 2) {
                node.setPointer(node.getPointer().getPointer());
                size--;
                return;
            }
            node = node.getPointer();
            pos++;
        }
        throw new IndexOutOfBoundsException("Index Out Of Bounds");
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
        Node<T> node = head;
        while (node.getPointer().getPointer() != null) {
            node = node.getPointer();
        }
        node.setPointer(null);
        tail = node;
        size--;
    }

    public void removeForwardData(T data) {
        Node<T> node = head;
        int count = 0;
        try {
            while (node.getData() != data) {
                node = node.getPointer();
                count++;
            }
            node.setPointer(null);
            size = count + 1;
        } catch (Exception e) {
            throw new NoSuchElementException("No Such Element");
        }
    }

    public void removeForwardIndex(int index) {
        Node<T> node = head;
        int pos = 0;
        int count = 0;
        try {
            while (pos != index) {
                node = node.getPointer();
                count++;
                pos++;
            }
            node.setPointer(null);
            size = count + 1;
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
    }

    public void removeBackwardData(T data) {
        Node<T> node = head;
        int count = 0;
        try {
            while (node.getData() != data) {
                node = node.getPointer();
                count++;
            }
            head = node;
            size -= count;
        } catch (Exception e) {
            throw new NoSuchElementException("No Such Element");
        }
    }

    public void removeBackwardIndex(int index) {
        int pos = 0;
        int count = 0;
        Node<T> node = head;
        try {
            while (pos != index) {
                node = node.getPointer();
                count++;
                pos++;
            }
            head = node;
            size -= count;
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
    }

    public void describeNodeData(T data) {
        if (head == null) {
            throw new NoSuchElementException("Empty List");
        }
        if (head.getData() == data) {
            System.out.printf("{\n  data\t: %s\n  index\t: %d\n}\n", head.getData(), 0);
            return;
        }
        if (tail.getData() == data) {
            System.out.printf("{\n  data\t: %s\n  index\t: %d\n}\n", tail.getData(), size - 1);
            return;
        }
        Node<T> node = head;
        int index = 0;
        while (node.hasPointer()) {
            if (node.getData() == data) {
                System.out.printf("{\n  data\t: %s\n  index\t: %d\n}\n", node.getData(), index);
                return;
            }
            node = node.getPointer();
            index++;
        }
        throw new NoSuchElementException("No Such Element");
    }

    public void describeNodeIndex(int index) {
        if (head == null) {
            throw new NoSuchElementException("Empty List");
        }
        if (0 == index) {
            System.out.printf("{\n  data\t: %s\n  index\t: %d\n}\n", head.getData(), 0);
            return;
        }
        if ((size - 1) == index) {
            System.out.printf("{\n  data\t: %s\n  index\t: %d\n}\n", tail.getData(), size - 1);
            return;
        }
        Node<T> node = head;
        int pos = 0;
        while (node.hasPointer()) {
            if (pos == index) {
                System.out.printf("{\n  data\t: %s\n  index\t: %d\n}\n", node.getData(), pos);
                return;
            }
            node = node.getPointer();
            pos++;
        }
        throw new NoSuchElementException("No Such Element");
    }

    public int indexOf(T data) {
        int pos = 0;
        Node<T> node = head;

        while (node.getPointer() != null) {
            pos++;
            node = node.getPointer();
            if (node.getData() == data) {
                System.out.printf("indeks => %s\n", pos);
                return pos;
            }
        }
        throw new NoSuchElementException("No Such Element");
    }

    public boolean isEmpty() {
        if (size == 0) {
            System.out.println("List is Empty");
            return true;
        }
        System.out.println("List is filled");
        return false;
    }

    public void unique() {
    }

    public void sort() {
    }

    public void updateByData(T data, T newData) {
        if (head == null)
            throw new NoSuchElementException("Empty List");

        Node<T> node = head;
        Node<T> newNode = new Node<T>(newData);

        if (node.getData() == data) {
            head = newNode;
            newNode.setPointer(node.getPointer());
            node.setPointer(null);
            return;
        }
        while (node.getPointer().getPointer() != null) {
            if (node.getPointer().getData() == data) {
                newNode.setPointer(node.getPointer().getPointer());
                node.setPointer(newNode);
                return;
            }
            node = node.getPointer();
        }
        if (tail.getData() == data) {
            newNode.setPointer(null);
            node.setPointer(newNode);
            tail = newNode;
            return;
        }
        if (node.getPointer().getData() != data) {
            throw new NoSuchElementException("No Such Element");
        }
    }

    public void updateByIndex(int index, T newData) {
        if (head == null)
            throw new NoSuchElementException("Empty List");

        int pos = 0;
        Node<T> node = head;
        Node<T> newNode = new Node<T>(newData);

        if (0 == index) {
            head = newNode;
            newNode.setPointer(node.getPointer());
            node.setPointer(null);
            return;
        }
        while (node.getPointer().getPointer() != null) {
            if (index - pos == 1) {
                newNode.setPointer(node.getPointer().getPointer());
                node.setPointer(newNode);
                return;
            }
            pos++;
            node = node.getPointer();
        }
        if ((size - 1) == index) {
            newNode.setPointer(null);
            node.setPointer(newNode);
            tail = newNode;
            return;
        }
        if ((size - 1) < index)
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("Empty Linked List");
            return;
        }
        Node<T> node = head;
        while (node.hasPointer()) {
            System.out.printf("[%s] -> ", node.getData());
            node = node.getPointer();
        }
        System.out.printf("[%s] -> null\n", node.getData());
    }

    public boolean contain(T data) {
        Node<T> node = head;
        while (node.getPointer() != null) {
            node = node.getPointer();
        }
        if (node.getData() == data) {
            System.out.println("Data is true");
            return true;
        } else {
            throw new NoSuchElementException("No Such Element");
        }
    }

    public T get(int index) {
        Node<T> node = head;
        int pos = 0;
        while (node.getPointer() != null) {
            if (pos == index) {
                System.out.printf("data => [%s]\n", node.getData());
                return node.getData();
            }
            node = node.getPointer();
            pos++;
        }
        if (size - 1 == index) {
            System.out.printf("data => [%s]\n", node.getData());
            return node.getData();
        }
        throw new IndexOutOfBoundsException("Index Out Of Bounds");
    }

    public int size() {
        System.out.println("Size ::> " + size);
        return size;
    }

    public void traverseFromData(T data) {
        try {
            if (head == null) {
                System.out.println("Empty Linked List");
                return;
            }
            Node<T> node = head;
            while (node.getData() != data) {
                node = node.getPointer();
            }
            while (node.getPointer() != null) {
                System.out.printf("[%s] -> ", node.getData());
                node = node.getPointer();
            }
            System.out.printf("[%s] -> null\n", node.getData());
        } catch (Exception E) {
            throw new NoSuchElementException("No Such Element");
        }
    }

    public void traverseFromIndex(int index) {
        Node<T> node = head;
        int pos = 0;
        while (node.getPointer().getPointer() != null) {
            pos++;
            node = node.getPointer();
        }
        if (pos == index) {
            while (node.getPointer() != null) {
                System.out.printf("[%s] -> ", node.getData());
                node = node.getPointer();
            }
            System.out.printf("[%s] -> null\n", node.getData());
            return;
        }
        if (pos != index) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
    }

}
