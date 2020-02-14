public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 200, 390, 9, 23, 56, 78};
        SingleLinkedList list = new SingleLinkedList();
        for (int number : numbers) {
            list.append(number);
        }
        list.traverse();
        list.removeTail();
        list.traverse();
        list.contain(56);
    }
}
