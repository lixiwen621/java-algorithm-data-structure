package com.arithmetic.linked;

/**
 *  排序链表
 *      输入：4 → 2 → 1 → 3
 *      输出：1 → 2 → 3 → 4
 *
 *  使用归并排序的思路, 进行排序
 *
 */
public class SortLinkedList {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(6,node4);
        ListNode node2 = new ListNode(8,node3);
        ListNode node1 = new ListNode(1,node2);

        ListNode listNode = sortList(node1);
        print(listNode);
    }

    public static ListNode sortList(ListNode head){
        if (head == null || head.next == null) return head;

        // 用快慢指针确定 链表的 mid
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 确定 mid
        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // 合并 已经排好序的链表
        return merge(left,right);
    }

    // 合并两个有序链表（和 21 题类似）
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode mergeLinkedList = new ListNode(-1);
        ListNode current = mergeLinkedList;

        while (l1 != null && l2 != null){
            if (l1.item <= l2.item){
                current.next = l1;
                l1 = l1.next;
            }else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return mergeLinkedList.next;
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
