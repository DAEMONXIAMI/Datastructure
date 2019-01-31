package test;


import main.ListNode;

import main.Solution;
import org.junit.Test;

import java.util.HashSet;

public class TestClass {
    @Test
    public void test1(){
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i <= 5; i++) {
            ListNode next = new ListNode(i);
            current.next = next;
            current = next;
            System.out.println(current.val);
        }
        while (head.next != null) {
            System.out.print(head.val);
            head = head.next;
            System.out.println(head.val);
            System.out.println(current.val);
        }

        ListNode head2 = Solution.reverseList(head);
        if (head2.next != null) {
            System.out.println(head.val);
            head2  = head2.next;
        }
    }

}
