package com.arithmetic.sum;

/**
 *  两数相加
 *  给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *  请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 *  你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *  例如：
 *      2 -> 4 -> 3
 *      5 -> 6 -> 4
 *  返回：
 *      7 -> 0 -> 8
 *
 *  输入：l1 = [2,4,3], l2 = [5,6,4]
 *  输出：[7,0,8]
 *  解释：342 + 465 = 807.
 *
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

//        Node n13 = new Node(3);
//        Node n12 = new Node(4,n13);
//        Node n11 = new Node(2,n12);
//
//        Node n23 = new Node(4);
//        Node n22 = new Node(6,n23);
//        Node n21 = new Node(5,n22);

        Node n17 = new Node(9);
        Node n16 = new Node(9,n17);
        Node n15 = new Node(9,n16);
        Node n14 = new Node(9,n15);
        Node n13 = new Node(9,n14);
        Node n12 = new Node(9,n13);
        Node n11 = new Node(9,n12);

        Node n24 = new Node(9);
        Node n23 = new Node(9,n24);
        Node n22 = new Node(9,n23);
        Node n21 = new Node(9,n22);

        Node node = addTwoNumber(n11, n21);
        print(node);
    }

    public static Node addTwoNumber(Node n1,Node n2){
        // 可以先虚拟一个头节点简化操作
        Node dummyHead = new Node(0);
        Node p1 = n1, p2 = n2, currnet = dummyHead;
        // 判断是否需要进位
        int carry=0;

        while (p1 != null || p2 != null){
            int item1 = (p1 != null) ? p1.item : 0;
            int item2 = (p2 != null) ? p2.item : 0;
            int sum = item1 + item2 + carry;
            // 处理进位
            carry = sum/10;
            currnet.next = new Node(sum%10);
            currnet = currnet.next;

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        // 最后一个还要处理进位
        if (carry > 0){
            currnet.next = new Node(carry);
        }

        return dummyHead.next;
    }


    private static class Node {
        int item;
        Node next;
        Node(){};
        Node(int item){
            this.item = item;
        }
        Node(int item,Node next){
            this.item = item;
            this.next = next;
        }
    }

    private static void print(Node node){
        StringBuilder builder = new StringBuilder();
        while (node != null){
            builder.append(node.item);
            if (node.next != null){
                builder.append("->");
            }
            node = node.next;
        }
        System.out.println(builder);
    }
}
