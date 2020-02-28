public class Main {
    public static void main(String[] args) {
        SingleLinkedList<String> str = new SingleLinkedList<>();
        SingleLinkedList<String> str2 = new SingleLinkedList<>();

        str.isEmpty();
        str.traverse();
        str.append("1");
        str.append("2");
        str.append("3");
        str.append("4");
        str.append("5");
        str2.append("satu");
        str.mergeAppend(str2);
        str.traverse();
        str.indexOf("satu");
        str.prependBeforeIndex("6", 0);
        str.traverse();

    }

}