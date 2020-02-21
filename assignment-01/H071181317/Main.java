public class Main {
    public static void main(String[] args) {
        SingleLinkedList<String> str = new SingleLinkedList<>();
        SingleLinkedList<String> str2 = new SingleLinkedList<>();
	SingleLinkedList<Integer> integer = new SingleLinkedList<Integer>();	

        str.isEmpty();
        str.traverse();
        str.append("1");
        str.append("2");
        str.append("3");
        str.append("4");
        str.append("5");
        str2.append("data1");
        str.mergeAppend(str2);
        str.traverse();
        str.indexOf("data1");
        str.prependBeforeIndex("6", 0);
        str.traverse();

    }

}