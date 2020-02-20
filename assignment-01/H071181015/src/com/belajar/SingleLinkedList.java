package com.belajar;

import java.util.NoSuchElementException;

public class SingleLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    void append(T data) {
        if (head == null) {
            head = new Node<T>(data);
            tail = head;
            size++;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node<T> newNode = new Node<T>(data);
        temp.next = newNode;
        tail = newNode;
        size++;
    }

    void append(T data, T after) {
        Node<T> temp = head;
        if (head == null) {
            prepand(data);
            return;
        }
        if (tail.data == after) {
            append(data);
            return;
        }
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.data == after) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            append(data);
            return;
        }
        Node<T> newNode = new Node<T>(data);
        Node<T> temp2 = temp.next;
        temp.next = newNode;
        newNode.next = temp2;
        size++;
    }

    void append(T data, int after) {
        Node<T> temp = head;
        int start = 0;
        if ((after + 1) == size) {
            append(data);
            return;
        } else {
            boolean cek = false;
            while (temp.next != null) {
                temp = temp.next;
                start++;
                if (start == after) {
                    cek = true;
                    break;
                }
            }
            if (!cek) {
                append(data);
                return;
            }
            Node<T> temp2 = temp.next;
            Node<T> newNode = new Node<T>(data);
            temp.next = newNode;
            newNode.next = temp2;
            size++;
        }
    }

    void append(T data[]) {
        for (T a : data) {
            append(a);
        }
    }

    void prepand(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    void prepand(T data, T before) {
        if (head.data == before) {
            prepand(data);
            return;
        }
        Node<T> temp = head;
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.data == before) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            prepand(data);
            return;
        }
        Node<T> newNode = new Node<T>(data);
        Node<T> temp2 = temp.next;
        temp.next = newNode;
        newNode.next = temp2;
        size++;
    }

    void prepand(T data, int index) {
        if (index == 0) {
            prepand(data);
            return;
        }
        if (index + 1 == size) {
            append(data);
            return;
        }
        Node<T> temp = head;
        int start = 1;
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            start++;
            if (start == index) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            prepand(data);
            return;
        }
        Node<T> newNode = new Node<T>(data);
        Node<T> temp2 = temp.next;
        temp.next = newNode;
        newNode.next = temp2;
        size++;
    }

    void prepand(T data[]) {
        for (T a : data) {
            prepand(a);
        }
    }

    void update(T data, T newData) {
        Node<T> temp = head;
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.data == data) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            throw new NoSuchElementException("DATA YANG DIMAKSUD TIDAK ADA");
        }
        temp.data = newData;
    }

    void update(T data, int index) {
        Node<T> temp = head;
        int start = 0;
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            start++;
            if (start == index) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            throw new IndexOutOfBoundsException("INDEKS DILUAR BATAS");
        }
        temp.data = data;
    }

    void clear() {
        head = null;
        size = 0;
    }

    void remove(T data) {
        Node<T> temp = head;
        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }
        if (tail.data == data) {
            removeTail();
            return;
        }
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.data == data) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            throw new NoSuchElementException("DATA TIDAK ADA");
        }
        temp.next = temp.next.next;
        size--;
    }

    void remove(int index) {
        int start = 1;
        if (index == 0) {
            removeHead();
            return;
        }
        if ((index + 1) == size) {
            removeTail();
            return;
        }
        Node<T> temp = head;
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            start++;
            if (start == index) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            throw new IndexOutOfBoundsException("INDEX DILUAR BATAS");
        }
        temp.next = temp.next.next;
        size--;
    }

    void removeHead() {
        head = head.next;
        size--;
    }

    void removeTail() {
        Node<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    void removeAfter(T data) {
        Node<T> temp = head;
        if (tail.data == data) {
            throw new NoSuchElementException("DATA TIDAK ADA");
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    void removeAfter(int index) {
        Node<T> temp = head;
        int start = 0;
        if ((index + 1) == size) {
            throw new IndexOutOfBoundsException("INDEKS DILUAR BATAS");
        }
        while (start != index) {
            temp = temp.next;
            start++;
        }
        temp.next = temp.next.next;
        size--;
    }

    void removeBefore(T data) {
        Node<T> temp = head;
        if (head.data == data) {
            throw new NoSuchElementException("DATA TIDAK ADA");
        }
        if (head.next.data == data) {
            removeHead();
            return;
        }
        while (temp.next.next.data != data) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    void removeBefore(int index) {
        Node<T> temp = head;
        int start = 0;
        if (index == 0) {
            throw new IndexOutOfBoundsException("INDEKS DILUAR BATAS");
        }
        if (index == 1) {
            removeHead();
            return;
        }
        while (start + 2 != index) {
            temp = temp.next;
            start++;
        }
        temp.next = temp.next.next;
        size--;
    }

    void removeForward(T data) {
        Node<T> temp = head;
        int start = 0;
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            start++;
            if (temp.data == data) {
                cek = false;
                break;
            }
        }
        if (!cek) {
            throw new NoSuchElementException("DATA TIDAK ADA");
        }
        temp.next = null;
        tail = temp;
        size = start + 1;
    }

    void removeForward(int index) {
        Node<T> temp = head;
        int start = 0;
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            start++;
            if (start - 1 == index) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            throw new IndexOutOfBoundsException("INDEKS DILUAR BATAS");
        }
        temp.next = null;
        tail = temp;
        size = index + 1;
    }

    void removeBackward(T data) {
        Node<T> temp = head;
        int start = 0;
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            start++;
            if (temp.data == data) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            throw new NoSuchElementException("DATA TIDAK ADA");
        }
        Node<T> temp2 = temp.next;
        head = temp;
        head.next = temp2;
        size = size - start;
    }

    void removeBackward(int index) {
        Node<T> temp = head;
        int start = 0;
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            start++;
            if (start - 1 == index) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            throw new IndexOutOfBoundsException("DATA DILUAR DATA");
        }
        Node<T> temp2 = temp.next;
        head = temp;
        head.next = temp2;
        size = size - start;
    }

    void mergeAppend(SingleLinkedList<T> list) {
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = list.head;
        tail = list.tail;
        size += list.size();
    }

    void mergePrepand(SingleLinkedList<T> list) {
        list.tail.next = head;
        head = list.head;
        size += list.size();
    }

    void print() {
        Node<T> temp = head;
        System.out.println(size);
        if (temp == null) {
            System.out.println("EMPTY LIST");
            return;
        }
        while (temp.next != null) {
            System.out.printf("[%s] -> ", temp.data);
            temp = temp.next;
        }
        System.out.printf("[%s] -> null\n", temp.data);
    }

    void printFrom(T data) {
        Node<T> temp = head;
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.data == data) {
                cek = true;
                break;
            }
            break;
        }
        if (!cek) {
            throw new NoSuchElementException("DATA TIDAK ADA");
        }
        System.out.println(size);
        while (temp.data != data) {
            temp = temp.next;
        }
        while (temp.next != null) {
            System.out.printf("%s -> ", temp.data);
            temp = temp.next;
        }
        System.out.printf("%s\n", temp.data);

        System.out.printf("head : %s -> tail : %s\n", head.data, tail.data);
    }

    void printFrom(int index) {
        Node<T> temp = head;
        int start = 0;
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            start++;
            if (start - 1 == index) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            throw new IndexOutOfBoundsException("INDEKS DILUAR BATAS");
        }
        System.out.println(size);
        while (temp.next != null) {
            System.out.printf("%s -> ", temp.data);
            temp = temp.next;
        }
        System.out.printf("%s\n", temp.data);

        System.out.printf("head : %s -> tail : %s\n", head.data, tail.data);
    }

    void describeNode(String data) {
        Node<T> temp = head;
        int start = 0;
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            start++;
            if (temp.data == data) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            throw new NoSuchElementException("DATA TIDAK ADA");
        }
        System.out.println("{");
        System.out.printf("\t\"Data\" : %s,\n", data);
        System.out.printf("\t\"Index\" : %s\n", start);
        System.out.println("}");
    }

    void describeNode(int index) {
        Node<T> temp = head;
        int start = 0;
        boolean cek = false;
        while (temp.next != null) {
            temp = temp.next;
            start++;
            if (start - 1 == index) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            throw new IndexOutOfBoundsException("DATA DILUAR BATAS");
        }
        System.out.println("{");
        System.out.printf("\tNode \t: %s\n", temp.data);
        System.out.printf("\tIndex \t: %s\n", index);
        System.out.println("}");
    }

    T get(int index) {
        Node<T> temp = head;
        int start = 0;
        while (start != index) {
            temp = temp.next;
            start++;
        }
        return temp.data;
    }

    int indexOf(T data) {
        Node<T> temp = head;
        int start = 0;
        while (temp.data != data) {
            temp = temp.next;
            start++;
        }
        return start;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    boolean isContain(T data) {
        Node<T> temp = head;
        boolean cek = false;
        while (temp.next != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
            if (temp.data == data) {
                cek = true;
                break;
            }
        }
        if (!cek) {
            throw new NoSuchElementException("DATA TIDAK ADA");
        }
        return cek;
    }
}