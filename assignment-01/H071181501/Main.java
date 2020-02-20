public class Main {
    public static void main(String[] args) {
        SingleLinkedList<String> str = new SingleLinkedList<String>();
        SingleLinkedList<String> str2 = new SingleLinkedList<String>();
        SingleLinkedList<Integer> integer = new SingleLinkedList<Integer>();
        // int[] numbers = {1, 200, 390, 9, 23, 56, 78};
        // SingleLinkedList list = new SingleLinkedList();
        // for (int number : numbers) {
        //     list.append(number);
        // }
        str.append("1");
        str.append("2");
        str.append("3");
        str.append("4");
        str.traverse();
        str2.append("data 1");
        str2.append("data 2");
        str2.append("data 3");
        str2.append("data 4");
        str.mergeAppend(str2);
        str.traverse();
        str.get(5);
        str.indexOf("data 3");

        // str.indexOf("6");
        // str.get(2);
        // str.size();
        // str.size();
        // str.clear();
        // System.out.println(str.isEmpty());
        // System.out.println(str.contain("6"));
    }
}
