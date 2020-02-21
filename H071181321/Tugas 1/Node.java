public class Node<T> {
    private T data;
    private Node<T> pointer;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getPointer() {
        return pointer;
    }

    public void setPointer(Node<T> pointer) {
        this.pointer = pointer;
    }

    public T getData() {
        return data;
    }

    public boolean hasPointer() {
        return pointer != null;
    }
}
