public class Node {
    private int data;
    private Node pointer;

    public Node(int data) {
        this.data = data;
    }

    public Node getPointer() {
        return pointer;
    }

    public void setPointer(Node pointer) {
        this.pointer = pointer;
    }

    public int getData() {
        return data;
    }

    public boolean hasPointer() {
        return pointer != null;
    }
}
