package main;

import java.util.*;

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
/*
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
*/
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
    //557.反转字符串中的单词
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        String rs = "";
        for(int i=0; i<s1.length; i++){
            char[] sc = s1[i].toCharArray();

            for(int k=0, j=sc.length-1; k<j ;){
                char temp;
                temp = sc[k];
                sc[k++] =sc[j];
                sc[j--] = temp;
            }
            if(i==0) rs = rs + (new String(sc));
            else rs = rs + " " + (new String(sc)) ;
        }

        return rs;
    }
    //206.反转链表
    public static ListNode reverseList(ListNode head) {
        ListNode next = null;
        if(head == null) return null;
        ListNode star = head.next;
        ListNode current = head;
        if(current != null){
            star = current.next;
            current.next = next;
            next = current;
            current = star;
        }

        return next;
    }
    //59.螺旋矩阵
    public int[][] generateMatrix(int n) {
        int direction = 0; //1:right, 2:down, 3:left, 4:up;
        int[][] gm = new int[n][n];
        int i = 0;
        int j = 0;
        int num = 1;
        gm[0][0] = 1;
        while (num != n*n ) {
            switch (direction) {
                case 0:
                    try {
                        System.out.println("gm[1][1]" +":"+gm[1][1]);
                        if(gm[i][++j] == 0){
                        gm[i][j] = ++num;
                        System.out.println("gm[" +i+"]"+"["+j+"]"+":"+gm[i][j]);
                        System.out.println("gm[1][2]:" + gm[1][2]);}
                        else {
                            j--;
                            direction = 1;
                        }
                    } catch (Exception e) {
                        direction = 1;
                        j--;
                        //num--;
                    }
                    break;
                case 1:
                    try {
                        if(gm[++i][j] == 0){
                            System.out.println("gm[1][2]::" + gm[1][2]);
                            gm[i][j] = ++num;
                            System.out.println("gm[" +i+"]"+"["+j+"]"+"::"+gm[i][j]); }
                        else {
                            i--;
                            direction = 2;
                        }
                    } catch (Exception e) {
                        direction = 2;
                        i--;
                        //num--;
                    }
                    break;
                case 2:
                    try {
                        if(gm[i][--j] == 0){
                            gm[i][j] = ++num;
                            System.out.println("gm[" +i+"]"+"["+j+"]"+":::"+gm[i][j]);}
                        else {
                            j++;
                            direction = 3;}
                    } catch (Exception e) {
                        direction = 3;
                        j++;
                        //num--;
                    }
                    break;
                case 3:
                    try {
                        if(gm[--i][j] == 0){
                            gm[i][j] = ++num;
                            System.out.println("gm[" +i+"]"+"["+j+"]"+"::::"+gm[i][j]);}
                        else {
                            i++;
                            direction = 0;}
                    } catch (Exception e) {
                        direction = 0;
                        i++;
                        //num--;
                    }
                    break;
            }
        }
        return gm;
    }
    //136.只出现一次的数字
    public int singleNumber(int[] nums) {
        int num = 0;
        Arrays.sort(nums);
        for(int i=0, j=1; j<nums.length; i=i+2,j=j+2){
            if (nums[i] != nums[j]) {
                int c = nums[j+1];
                return c==nums[i]?nums[j]:nums[i];
            }
        }
        return nums[nums.length-1];
    }
    //169.求众数
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    //235.二叉搜索树的最近公共祖先
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;

        if(root.val>=p.val && root.val<=q.val) return root;

        if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left, p, q);

        if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right, p, q);

        return root;
    }
    //9.回文数
    public boolean isPalindrome(int x){
        return String.valueOf(x).equals(new StringBuffer(x + "").reverse().toString());
    }
    //21.合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(00);
        ListNode root = cur;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            cur.next = l2;
        }else{
            cur.next = l1;
        }

        return root.next;
    }
    //122. 买股票的最佳时机 ||
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int buytime = 0, selltime = 1; buytime < selltime && selltime < prices.length; ){
            if(prices[buytime] > prices[selltime]){
                buytime++;
                selltime++;
                continue;
            }

            if(selltime < prices.length-1 && prices[selltime] < prices[selltime+1]){
                selltime++;
                continue;
            }

            profit = profit + prices[selltime] - prices[buytime];
            buytime = selltime + 1;
            selltime = selltime + 2;
        }

        return profit;
    }
    //面试题3. 二维数组中的查找
    public Boolean searchMatrix (int[][] matrix, int target){

        if(matrix==null||matrix.length==0||(matrix.length==1&&matrix[0].length==0)) return false;

        for(int i = 0, j = matrix[0].length - 1; i <= matrix.length-1 && j >= 0; ){
            if(target == matrix[i][j]) return true;

            if(target > matrix[i][j]){
                i++;
                continue;
            }

            if (target < matrix[i][j]){
                j--;
                continue;
            }
        }

        return false;
    }
    //面试题4. 替换空格
    public String replaceBlank(String string){
        StringBuffer str = new StringBuffer(string);
        int blankcount = 0;

        if (string == null) return null;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                blankcount++;
            }
        }

        int lengthNew = str.length() + blankcount*2;
        str.setLength(lengthNew);

        int indexOfOriginal = str.length() - 1;
        int indexOfNew = lengthNew - 1;

        while (indexOfOriginal != indexOfNew) {
            if(str.charAt(indexOfOriginal) == ' '){
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
            }
            else {
                str.setCharAt(indexOfNew--, str.charAt(indexOfOriginal--));
            }
        }

        return str.toString();
    }
    //剑指offer5. 从尾到头打印链表
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        if (listNode != null) {
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return  arrayList;
    }
    //剑指offer6.重建二叉树
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return null;
    }
    //剑指offer7，用两个栈实现队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    //剑指offer8 旋转数组的最小值
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) return 0;
        int min = array[0];
        int i = 0;
        int j = array.length-1;
        while(i<j-1){
            int mid = (i + j)/2;
            if(array[mid] > array[j]){
                i = mid;
            }else{
                j =mid;
            }
        }
        return array[j];
    }
    //剑指offer 9 斐波那契数列
    //解法1：性能最差，写法最简单，因为重复计算许多数
    public int Fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return Fibonacci(n-1) +Fibonacci(n-2);
    }
    //解法2：死方法，比递归想法简单，而且比递归快速
    public int Fibonacci2(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int FibonacciA = 0;
        int FibonacciB = 1;
        int FibonacciN = 0;
        for(int i = 2; i <= n; i ++){
            FibonacciN = FibonacciA + FibonacciB;
            FibonacciA = FibonacciB;
            FibonacciB = FibonacciN;
        }
        return FibonacciN;
    }
    //804唯一莫尔斯密码
    public int uniqueMorseRepresentations(String[] words) {
        if(words ==null || words[0] == "") return 0;

        int l = words.length;
        String unWords = null;
        Set wordSet = new HashSet();
        String[] morseTable = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
                "...","-","..-","...-",".--","-..-","-.--","--.."};
        for(int i = 0; i < l; i ++){
            unWords = null;
            String n = words[i];
            char[] n1 = n.toCharArray();
            int n1l = n.length();
            for(int j =0; j < n1l; j++){
                int key = n1[j] - 97;
                unWords = unWords + morseTable[key];
            }
            wordSet.add(unWords);
        }
        return wordSet.size();
    }
    //383. 赎金信
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null) return false;
        if(ransomNote != null && magazine == null) return false;

        char[] ransomChar = ransomNote.toCharArray();
        char[] magazineChar = magazine.toCharArray();
        int[] ransomNum = new int[26];
        int[] magazineNum = new int[26];
        int subscrip = 0;

        for(int i = 0; i < ransomChar.length; i++){
            subscrip = ransomChar[i] - 'a';
            ransomNum[subscrip] ++;
        }
        for(int i = 0; i < magazineChar.length; i++){
            subscrip = magazineChar[i] - 'a';
            magazineNum[subscrip] ++;
        }
        for(int i = 0; i < 26; i ++){
            if(ransomNum[i] > magazineNum[i]) return false;
        }
        return true;
    }
    //14.最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs[0] == "") return "";
        StringBuffer lcp = new StringBuffer();
        int l = strs.length;
        for (int i = 0; i < strs[0].length(); i++) {
            char flag = strs[0].toCharArray()[i];
            for (int j = 1; j < l; j++) {
                if(flag != strs[j].toCharArray()[i]) return "";
            }
            lcp.append(flag);
        }
        return lcp.toString();
    }
    //14. 最长公共前缀
    public String longestCommonPrefix2(String[] strs) {
        int ll = 0;
        if(strs == null ) return "";
        if(strs.length == 1) return strs[0];
        if(strs.length > 1)
        {ll = strs[0].length();}

        StringBuilder lcp = new StringBuilder();
        int l = strs.length;

        outer:
        for (int i = 0; i < ll; i++) {
            char flag = strs[0].toCharArray()[i];
            for (int j = 1; j < l; j++) {
                if(strs[j].toCharArray().length > i){
                    if(flag != strs[j].toCharArray()[i]) break outer;}
                else{
                    break outer;
                }
            }
            lcp.append(flag);
        }
        return lcp.toString();
    }
}
