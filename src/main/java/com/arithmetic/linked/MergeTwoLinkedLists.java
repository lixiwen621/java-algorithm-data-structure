package com.arithmetic.linked;

/**
 *  合并两个有序链表
 *      输入：
 *          list1 = 1 -> 2 -> 4
 *          list2 = 1 -> 3 -> 4
 *      输出：
 *          1 -> 1 -> 2 -> 3 -> 4 -> 4
 */
public class MergeTwoLinkedLists {
    public static void main(String[] args) {
        ListNode node14 = new ListNode(4);
        ListNode node12 = new ListNode(2, node14);
        ListNode node11 = new ListNode(1,node12);
        print(node11);

        ListNode node25 = new ListNode(5);
        ListNode node24 = new ListNode(4,node25);
        ListNode node23 = new ListNode(3, node24);
        ListNode node21 = new ListNode(1,node23);
        print(node21);

        ListNode listNode = mergeTwoLists(node11, node21);
        print(listNode);
    }


    private static ListNode mergeTwoLists(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (node1 != null && node2 != null){
            if (node1.item <= node2.item){
                current.next = node1;
                node1 = node1.next;
            }else {
                current.next = node2;
                node2 = node2.next;
            }

            current = current.next;
        }

        // 剩下的节点, 直接接到 新节点上
        if (node1 != null) current.next = node1;
        if (node2 != null) current.next = node2;

        return dummy.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // 虚拟头节点
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.item < list2.item) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 将剩余部分直接接上去
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next;
    }


    private static class ListNode {
        int item;
        ListNode next;
        ListNode(){};
        ListNode(int item){
            this.item = item;
        }
        ListNode(int item, ListNode next){
            this.item = item;
            this.next = next;
        }
    }

    private static void print(ListNode node){
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
