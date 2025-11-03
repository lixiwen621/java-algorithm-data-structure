package com.arithmetic.linked;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        SinglyLinked<String> stringSinglyLinked = new SinglyLinked<>();
        stringSinglyLinked.append("lixin");
        stringSinglyLinked.append("apple");
        stringSinglyLinked.append("lixiwen");
        stringSinglyLinked.remove("apple");
        stringSinglyLinked.appendFirst("liyirui");
        System.out.println(stringSinglyLinked);
        SinglyLinked<String> stringSinglyLinked1 = new SinglyLinked<>();
        System.out.println(stringSinglyLinked1);
        //System.out.println(Arrays.toString(stringSinglyLinked.toArray()));

        DoublyLinkedList<String> doublyLinkedLis = new DoublyLinkedList<>();
        doublyLinkedLis.add("lixiwen");
        doublyLinkedLis.add("lixiwen123");
        doublyLinkedLis.add("lixiwen456");
        doublyLinkedLis.add("lixiwen789");
        doublyLinkedLis.add("lixiwen1011");
        doublyLinkedLis.add("lixiwen1213");

        System.out.println(doublyLinkedLis);
        System.out.println(doublyLinkedLis.size());
        System.out.println(doublyLinkedLis.indexOf("lixiwen789"));
        DoublyLinkedList.Node<String> node = doublyLinkedLis.node(3);
        System.out.println(node.element);
    }
}
