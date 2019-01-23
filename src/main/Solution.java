package main;

import java.util.Arrays;
import java.util.HashSet;

//注释内容：包含题号和题目，测试代码再test中，每次做题都把上一次方法改成非静态。
public class Solution {
    //389 找不同
    /*给定两个字符串 s 和 t，它们只包含小写字母。
     *字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     *请找出在 t 中被添加的字母
     */
    public char findTheDifference(String s, String t) {
        //char difference;
        char[] sc = s.toCharArray();//将string转成char数组
        char[] tc = t.toCharArray();
        //Arrays.sort(sc);
        //Arrays.sort(tc);
        char[] newl = sc.length>tc.length?sc:tc;//newl为两个字符串中长的那一个
        char[] news = sc.length<tc.length?sc:tc;//news为短的那一个
        Arrays.sort(newl);//排序
        Arrays.sort(news);
        //两个字符串做减法，当不等于0的时候输出对应下标的长字符串
        //int flag = 0;//flag=0表示没有找到
        if(news.length == newl.length)
            return '/';
        for(int i = 0; i<news.length; i++){
            if(news[i] != newl[i])return newl[i];
        }
        return newl[newl.length-1];
    }

    //929 独特的电子邮件地址
    public int numUniqueEmails(String[] emails) {
        public int numUniqueEmails(String[] emails) {
            HashSet<String> addSet = new HashSet();
            String realAdd;
            for(String s : emails){
                String[] add = s.split("@");
                //if(add[0].charAt('+') !=0)
                realAdd = add[0].substring(0, add[0].indexOf("+")).replaceAll(".","");
                addSet.add(realAdd+add[1]);
            }
            return addSet.size();
        }
    }

    //905按奇偶数组排序
    public int[] sortArrayByParity(int[] A) {
        int temp;

        for (int i = 0, j = A.length - 1; i <= j; ) {
            //当A[i]是奇数，A[j]是偶数，则交换
            if (A[i]%2 == 1 && A[j]%2 == 0){
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            //当A[i]是奇数，A[j]是奇数，则j--
            else if(A[i]%2 == 1 && A[j]%2 == 1){
                j--;
            }
            //当A[i]是偶数数，A[j]是奇数，则j--，i++
            else if(A[i]%2 == 0 && A[j]%2 == 1){
                i++;
                j--;
            }
            //当A[i]是偶数数，A[j]是偶数，则i++
            else if(A[i]%2 == 0 && A[j]%2 == 0){
                i++;
            }
        }
        return A;
    }

    //832反转图像
    public int[][] flipAndInvertImage(int[][] A) {
            int length = A[0].length;
            int temp;
            for(int i = 0; i<length; i++){
                for(int j =0; j <length/2; j++){
                    temp = A[i][j]==1?0:1;
                    A[i][j] = A[i][length-1-j]==1?0:1;
                    A[i][length-1-j] = temp;
                }
                if(length%2==1){
                    A[i][length/2] = A[i][length/2]==1?0:1;
                }
            }
            return A;
    }

    //237. 删除链表中的节点
    public void deleteNode(ListNode node) {
        ListNode head = node;
        ListNode tail = node;
        while(head.next != null){
            head.val = head.next.val;
            tail = head;
            head = head.next;
            }
            tail.next = null;
    }

    //292Nim游戏
    public boolean canWinNim(int n) {
        return(n%4 != 0);
    }

    //344 翻转字符串
    public void reverseString(char[] s) {
        int lo = 0;
        int hi = s.length -1;
        char temp;
        while(lo<hi && s != null){
            temp = s[lo];
            s[lo++] = s[hi];
            s[hi--] = temp;
        }
    }
}
