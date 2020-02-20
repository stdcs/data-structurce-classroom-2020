package com.belajar;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<String> sl1 = new SingleLinkedList<>();
        sl1.append("data1");
        sl1.append("data2", "data1");
        sl1.append("data3", "data4");
        sl1.append("data4", 10);
        sl1.prepand("data5", "data6");
        sl1.prepand("data6", 10);
        sl1.print();
    }
}