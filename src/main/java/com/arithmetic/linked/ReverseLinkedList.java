package com.arithmetic.linked;

/**
 *  反转链表
 *      输入：1 → 2 → 3 → 4 → 5 → null
 *      输出：5 → 4 → 3 → 2 → 1 → null
 *
 *      prev = null;
 *      curr = 1->2->3->4->5
 */
public class ReverseLinkedList {
    public static void main(String[] args) {

        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        print(node1);
        ListNode listNode = reverseList(node1);
        print(listNode);

    }

    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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
