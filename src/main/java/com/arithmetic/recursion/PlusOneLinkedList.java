package com.arithmetic.recursion;


public class PlusOneLinkedList {
    public static void main(String[] args) {
        ListNode node3 = new ListNode(8);
        ListNode node2 = new ListNode(9,node3);
        ListNode node1 = new ListNode(9,node2);

        ListNode listNode = plusOne(node1);
        print(listNode);

    }

    public static ListNode plusOne(ListNode head){
        // 调用递归处理函数
        int carry = addOneRecursive(head);
        if (carry > 0){
            ListNode newData = new ListNode(1);
            newData.next = head;
            head = newData;
        }
        return head;
    }

    /**
     *  递归函数：从尾部加1，并返回是否有进位
     * @param node
     * @return 0 或 1 表示是否有进位
     */
    private static int addOneRecursive(ListNode node){
        if (node == null){
            return 1; // 初始+1
        }

        // 从后往前处理
        int carry = addOneRecursive(node.next);
        int sum = node.item + carry;
        node.item = sum%10;
        return sum/10; // 返回进位
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
