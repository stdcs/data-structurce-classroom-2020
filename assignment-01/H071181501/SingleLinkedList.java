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

    public void appends(T ... datas){
        for(T data : datas){
            append(data);
            size++;
        }
    }


    public void appendAfterData(T data, T after){
        Node<T> newNode = new Node<T>(data);
        Node<T> node = head;
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
        if (head.getData() == after){
            newNode.setPointer(node.getPointer());
            head.setPointer(newNode);
            size++;
        }
        while(node.getPointer() != null){
            if(node.getPointer().getData() == after){
                newNode.setPointer(node.getPointer().getPointer());
                node.getPointer().setPointer(newNode);
                size++;
                return;
            }
            node = node.getPointer();
        }
        if(node.getData() != data){
            append(data);
            size++;
            return;
        }
    }

    public void appendAfterIndex(T data, int indeks){
        Node<T> newNode = new Node<T>(data);
        Node<T> node = head;
        int pos = 0;
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
        while(node.getPointer() != null){
            if (pos == indeks){
                newNode.setPointer(node.getPointer());
                node.setPointer(newNode);
                size++;
                return;
            }
            pos++;
            node = node.getPointer();
        }
        if(pos == indeks ){
            append(data);
            size++;
            return;
        }
        if(pos != indeks){
            append(data);
            size++;
            return;
        }
    }

    public void update(T newData, T data) {
        Node<T> newNode = new Node<T>(newData);
        Node<T> node = head;

        if (head == null) {
            throw new NoSuchElementException("Empty List");
        }
        if (head.getData() == data){
            head = newNode;
            newNode.setPointer(node.getPointer());
            node.setPointer(null);
            return;
        }
        while (node.getPointer() != null){
            if(node.getPointer().getData() == data ){
                newNode.setPointer(node.getPointer().getPointer());
                node.setPointer(newNode);
                return;
            }
            node = node.getPointer();
        }
        throw new NoSuchElementException("No Such Element");
    }
    
    public void updateIndeks(T newData, int indeks){
        Node<T> newNode = new Node<T>(newData);
        Node<T> node = head;
        int pos = 0;

        if (head == null) {
            throw new NoSuchElementException("Empty List");
        }
        if(0 == indeks){
            head = newNode;
            newNode.setPointer(node.getPointer());
            node.setPointer(null);
            return;
        }
        while(node.getPointer() != null){
            if((pos+1) == indeks){
                newNode.setPointer(node.getPointer().getPointer());
                node.setPointer(newNode);
                return;
            }
            node = node.getPointer();
            pos++;
        }
        throw new IndexOutOfBoundsException("Index Out Of Bounds");
    }

    public void prepend(T data) {
        if (head == null) {
            head = new Node<T>(data);
            size++;
            return;
        }
        Node<T> newNode = new Node<T>(data);
        newNode.setPointer(head);
        head = newNode;
        size++;
    }

    public void prependBeforeData(T data, T before){
        Node<T> newNode = new Node<T>(data);
        Node<T> node = head;
        if (head == null) {
            head = new Node<T>(data);
            size++;
            return;
        }
        if (head.getData() == before){
            newNode.setPointer(head);
            head = newNode;
            size++;
            return;
        }
        while (node.getPointer() != null){
            if(node.getPointer().getData() == before){
                newNode.setPointer(node.getPointer());
                node.setPointer(newNode);
                size++;
                return;
            }
            node = node.getPointer();
        }
        if (node.getData() != data){
            prepend(data);
            size++;
            return;
        }
    }

    public void prependBeforeIndex(T data, int indeks){
        Node<T> newNode = new Node<T>(data);
        Node<T> node = head;
        int pos = 0;

        if (head == null) {
            head = new Node<T>(data);
            size++;
            return;
        }
        if(indeks == 0){
            newNode.setPointer(head);
            head = newNode;
            size++;
            return;
        }
        while(node.getPointer() != null){
            if((pos+1) == indeks){
                newNode.setPointer(node.getPointer());
                node.setPointer(newNode);
                size++;
                return;
            }
            node = node.getPointer();
            pos++;
        }
        if(pos != indeks){
            prepend(data);
            size++;
            return;
        }
    }

    public void prepends(T ... datas){
        for(T data : datas){
            prepend(data);
            size++;
        }
    }

    public void clear() {
        head = null;
        size = 0;
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

    public void remove(T data){
        Node<T> node = head;

        if(head.getData() == data){
            removeHead();
            return;
        }
        while(node.getPointer() != null){
            if(node.getPointer().getData() == data){
                node.setPointer(node.getPointer().getPointer());
                size--;
                return;
            }
            node = node.getPointer();
        }
        throw new NoSuchElementException("No Such Element");       
    }

    public void removeIndeks(int indeks){
        Node<T> node = head;
        int pos = 0;

        if (indeks == 0){
            removeHead();
            return;
        }
        while(node.getPointer() != null){
            if((pos+1) == indeks){
                node.setPointer(node.getPointer().getPointer());
                size--;
                return;
            }
            node = node.getPointer();
            pos++;
        }
        throw new IndexOutOfBoundsException("Index Out Of Bounds");
    }

    public void removeAfterData(T data){
        Node<T> node = head;
        while(node.getPointer() != null){
            if(node.getData() == data){
                node.setPointer(node.getPointer().getPointer());
                size--;
                return;
            }
            node = node.getPointer();
        }
        throw new NoSuchElementException("No Such Element");
    }

    public void removeAfterIndeks(int indeks){
        Node<T> node = head;
        int pos = 0;
        while(node.getPointer() != null){
            if(pos == indeks){
                node.setPointer(node.getPointer().getPointer());
                size--;
                return;
            }
            node = node.getPointer();
            pos++;
        }
        throw new IndexOutOfBoundsException("Index Out Of Bounds");
    }

    public void removeBeforeData(T data) {
        Node<T> node = head;
        try{
            if(head.getPointer().getData() == data){
                head = head.getPointer();
                size--;
                return;
            }
            while(node.getPointer() != null){
                if(node.getPointer().getPointer().getData() == data){
                    node.setPointer(node.getPointer().getPointer());
                    size--;
                    return;
                }
                node = node.getPointer();
            }
        }catch (Exception e){
             throw new NoSuchElementException("No Such Element");
        }
    }
    public void removeBeforeIndeks(int indeks) {
        Node<T> node = head;
        int pos = 0;

        if((pos+1) == indeks){
            head = head.getPointer();
            size--;
            return;
        }
        while(node.getPointer() != null){
            if((indeks) - pos == 2){
                node.setPointer(node.getPointer().getPointer());
                size--;
                return;
            }
            node = node.getPointer();
            pos++;
        }
        throw new IndexOutOfBoundsException("Index Out Of Bounds");
    }

    public void removeForward(T data){
        Node<T> node = head;
        int count = 0;
        try{
            while(node.getData() != data){
                node = node.getPointer();
                count++;
            }
            node.setPointer(null);
            size = count + 1;
        }catch (Exception e){
             throw new NoSuchElementException("No Such Element");
        }
    }

    public void removeForwardIndeks(int indeks){
        Node<T> node = head;
        int pos = 0;
        int count = 0;
        try{
            while(pos != indeks){
                node = node.getPointer();
                count++;
                pos++;
            }
            node.setPointer(null);
            size = count+1;
        }catch (Exception e){
             throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
    }

    public void removeBackward(T data){
        Node<T> node = head;
        int count = 0;
        try{
            while(node.getData() != data){
                node = node.getPointer();
                count++;
            }
            head = node;
            size -= count;
        }catch (Exception e){
            throw new NoSuchElementException("No Such Element");
        }
    }

    public void removeBackwardIndeks(int indeks){
        Node<T> node = head;
        int count = 0; 
        int pos = 0;
        try{
            while(pos != indeks){
                node = node.getPointer();
                count++;
                pos++;
            }
            head = node;
            size -= count;
        }
        catch (Exception e){
             throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
    }

    public void describeNode(T data) {
        if (head == null) {
            throw new NoSuchElementException("Empty List");
        }
        if (head.getData() == data) {
            System.out.printf("{\n  data\t: %s\n  index\t: %s\n}\n", head.getData(), 0);
            return;
        }
        if (tail.getData() == data) {
            System.out.printf("{\n  data\t: %s\n  index\t: %s\n}\n", tail.getData(), size - 1);
            return;
        }
        Node<T> node = head;
        int index = 0;
        while (node.hasPointer()) {
            if (node.getData() == data) {
                System.out.printf("{\n  data\t: %s\n  index\t: %s\n}\n", node.getData(), index);
                return;
            }
            node = node.getPointer();
            index++;
        }
        throw new NoSuchElementException("No Such Element");
    }

    public void describeNodeIndeks(int indeks){
        int pos = 0; 
        if (head == null) {
            throw new NoSuchElementException("Empty List");
        }
        if (0 == indeks) {
            System.out.printf("{\n  data\t: %s\n  index\t: %s\n}\n", head.getData(), 0);
            return;
        }
        if ((size-1) == indeks) {
            System.out.printf("{\n  data\t: %s\n  index\t: %s\n}\n", tail.getData(), size - 1);
            return;
        }
        Node<T> node = head;
        int index = 0;
        while (node.hasPointer()) {
            if (pos == indeks) {
                System.out.printf("{\n  data\t: %s\n  index\t: %s\n}\n", node.getData(), index);
                return;
            }
            node = node.getPointer();
            index++;
            pos++;
        }
        throw new IndexOutOfBoundsException("Index Out Of Bounds");
    }

    public void mergeAppend(SingleLinkedList<T> list){
        tail.setPointer(list.head);
        tail = list.tail;
        size += list.size;
        return;
    }
    public void mergePrepend(SingleLinkedList<T> list){
        head = list.tail;
        list.tail.setPointer(list.head);
        size += list.size;
        return;
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

    public void traverseFromData(T data){
        try{
        if (head==null){
            System.out.println("Empty Linked List");
            return;
        }
        Node<T> node = head;
        while (node.getData() != data){
            node = node.getPointer();
        }
        while (node.getPointer() != null){
            System.out.printf("[%s] -> ", node.getData());
            node = node.getPointer();
        }
        System.out.printf("[%s] -> null\n", node.getData());
        }catch (Exception E){
            throw new NoSuchElementException("No Such Element");
        }
    }

    public void traverseFromIndex(int indeks){
        try{
            Node<T> node = head;
            int pos = 0;

            while(pos != indeks){
                node = node.getPointer();
                pos++;
            }
            if(pos == indeks){
                while(node.getPointer() != null){
                    System.out.printf("[%s] -> ", node.getData());
                    node = node.getPointer();
                }
                System.out.printf("[%s] -> null\n", node.getData());
            }
        }catch (Exception E){
            throw new NoSuchElementException("No Such Element");
        }
    }
    public void get(int indeks) {
        Node<T> node = head;
        int pos = 0;
        while(node.getPointer() != null){
            if(pos == indeks){
                System.out.printf("data => [%s]\n", node.getData());
                return;
            }
            node = node.getPointer();
            pos++;
        }
        if (size-1 == indeks){
             System.out.printf("data => [%s]\n", node.getData());
             return;
        }
        throw new IndexOutOfBoundsException("Index Out Of Bounds");
    }

    public void indexOf(T data){
        Node<T> node = head;
        int pos =0;
        while(node.getPointer() != null){
            pos++;
            node = node.getPointer();
            if(node.getData() == data){
                System.out.printf("indeks => %s\n", pos);
                return;
            }
        }
        throw new NoSuchElementException("No Such Element");
    }

    public int size(){
        System.out.println("Size ==> " + size);
        return size;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    public boolean contain(T data){
        Node<T> node = head;
        while(node.getPointer() != null){
            if(node.getData() == data){
                return true;
            }
            node = node.getPointer();
        }
        return false;
    }
}
