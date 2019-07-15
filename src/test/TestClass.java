package test;


import main.ListNode;
import main.MyThreadPool;
import main.Solution;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

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

    @Test
    public void test2() {
        Solution ss = new Solution();
        int num =1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(num++ +" ");
            }
            System.out.println();
        }
        int[][] gm = ss.generateMatrix(4);

        for (int i = 0; i < gm.length; i++) {
            for (int j = 0; j < gm.length; j++) {
                System.out.print(gm[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void test3(){
        Solution ss = new Solution();
        int[] nums = {1,3,5,6,4,8,2,1,3,5,6,4,8};
        int num = ss.singleNumber(nums);
        System.out.println(num);

    }

    @Test
    public void test4() {
        Solution ss = new Solution();
        int[] nums1 = {1, 2};
        int[] nums2 = {1, 2, 1, 3};

         int[] ans = ss.intersect(nums1, nums2);
         for(int i: ans)
        System.out.println(i);


    }

    @Test
    //junit单元测试不支持多线程
    public void testMyThreadPool(){
        int kkk = 0;
        MyThreadPool myThreadPool = new MyThreadPool(3, 6);
        for (int i = 0; i < 6; i++) {
            System.out.println("222222");
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("一个线程被放到仓库中");
                    try {
                        Thread.sleep(25000);
                    } catch (InterruptedException e) {
                        System.out.println("一个线程被唤醒了");
                    }
                }
            });
        }
        System.out.println(kkk);
    }

    @Test
    public void testTest() {
        Solution.RandomListNode r1 = new Solution.RandomListNode(1);
        Solution.RandomListNode r2 = new Solution.RandomListNode(2);
        Solution.RandomListNode r3 = new Solution.RandomListNode(3);
        Solution.RandomListNode r4 = new Solution.RandomListNode(4);
        Solution.RandomListNode r5 = new Solution.RandomListNode(5);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        r5.next = null;
        r1.random = r3;
        r2.random = r5;
        r3.random = null;
        r4.random = r2;
        r5.random = null;

        Solution.RandomListNode n1 = Solution.Clone(r1);
    }
    @Test
    public void mathTest(){
        float f1 = -3.5f;
        float f2 = 3.5f;
        float f3 = -3.6f;
        //Math.round()是+0.5然后向下取整，即在数轴上向左取整数
        System.out.println(Math.round(f1));
        System.out.println(Math.round(f2));
        System.out.println(Math.round(f3));
    }

    @Test
    public void gitTest(){
        System.out.println("这是IDEA的git测试");
    }

    @Test
    public void testNumberOf1Between1AndN_Solution (){
        /*Solution ss = new Solution();
        int[] numbers = {};
        boolean ans = ss.isContinuous(numbers);
        System.out.println(ans);*/
        LinkedList<Integer> head = new LinkedList<>();
        //System.out.println(head);
        Iterator iterator = head.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
