package main;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import javax.sound.midi.Sequence;
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
    /*public int maxProfit(int[] prices) {
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
    }*/
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

    public boolean isPalindrome(String s) {
        if(s == ""||s == " ") return true;
        s = s.toLowerCase();
        int charNum = 0;
        char[] sc = s.toCharArray();
        for (int i = 0, j = sc.length - 1; i < j;) {
            if ('a' <= sc[i] && sc[i] <= 'z') {
                if ('a' <= sc[j] && sc[j] <= 'z') {
                    if (sc[i] == sc[j]) {
                        charNum = 1;
                        i++;
                        j--;
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    j --;
                    continue;
                }
            } else {
                i ++;
                continue;
            }
        }
        if (charNum == 0) {
            return false;
        }
        return true;
    }

    // *****121 买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        //if(prices == 0)
        return max(prices, prices.length - 1);
    }
    public int max(int[] prices, int l){
        int profit = 0;
        if(l == 0) profit =0;
        if(l == 1) profit = (prices[1] - prices[0]) > 0 ? (prices[1] - prices[0]) : 0;
        else{
            profit = profit + Math.max(max(prices, l - 1), prices[l] - minPrice(prices, l - 1));
        }
        return profit;
    }

    public int minPrice (int[] prices, int l2){
        int min = prices[l2];
        for(int i = l2; i > 0; ){
            if(prices[i] < prices[i - 1]) {
                min = prices[i] ;
                i --;
            }
            else{
                i --;
            }
        }
        return min;
    }
    //二进制中1的个数
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n & flag) != 0){
                count ++;
                flag = flag << 1;
            }else{
                flag = flag << 1;
            }
        }
        return count;
    }
    //数值的整数次方
    public double Power(double base, int exponent) {
        double answer = 1.0;
        if (exponent == 0) {
            return 1;
        }
        if (base == 0) {
            return 0;
        }
        if (exponent > 0) {
            for (int i = 1; i <= exponent; i++) {
                answer = answer * base;
            }
        }
        if (exponent < 0) {
            for (int i = -1; i >= exponent; i--) {
                answer = answer * base;
            }
            answer = 1.0 / answer;
        }
        return answer;
    }
    //调整数字位置，使得奇数在前，偶数在后
    public void reOrderArray(int [] array) {
        for(int i = 0, j = array.length - 1; i < j;){
            while(!isOdd(array[i]) && i < j){
                i ++;
            }
            while(isOdd(array[j]) && i < j){
                j --;
            }
            if(i >= j) break;

            swap(array, i, j);
            i ++;
            j --;
        }
    }

    public Boolean isOdd(int num){
        Boolean boo = (num % 2) == 0;
        System.out.println(num +":"+ boo);
        return (num % 2) == 0;
    }

    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //
/*    public int removeDuplicates(int[] nums) {
        Set<Integer> rmnums = new HashSet<Integer>();
        for(int i = 0; i <= nums.length - 1; i++){
            rmnums.add(nums[i]);
        }
        Object[] ans = rmnums.toArray();
        int ans2 = Integer.parseInt(ans.toString());
        return nums.length;
    }*/
    //
    public void rotate(int[] nums, int k) {
        if(k == 0 || nums.length == 1) return;
        int sub = 0;
        int start = 0;
        int nextSub = 0;
        int temp = nums[0];
        int temp2 = 0;
        for(int i = 0; i < nums.length; i ++){
            nextSub = (sub + k) <= (nums.length - 1) ? (sub + k) : ((sub + k) % nums.length);
            temp2 = nums[nextSub];
            nums[nextSub] = temp;
            temp = temp2;
            sub = nextSub;
            ArrayList arrayList = new ArrayList();
          //Integer[] adaf =  (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
            if(nextSub == start){
                start = ++sub;
                temp = nums[sub];
            }
        }
    }
    //
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length; ){
            if(nums1[i] == nums2[j]){
                ans.add(nums1[i]);
                i ++;
                j ++;
                continue;
            }
            if(nums1[i] > nums1[j]){
                j ++;
                continue;
            }
            if(nums1[i] < nums1[j]){
                i ++;
                continue;
            }
        }
        int[] ans2 = new int[ans.size()];
        int sub = 0;
        for(int i : ans){
            ans2[sub++] = i;
        }
        return ans2;
    }
    //链表中倒数第k个节点
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0) return null;
        ListNode cur = head;
        ListNode ans = head;
        for(int i = 0; i < k - 1; i ++){
            if(cur.next != null){
                cur = cur.next;
            }else{
                return null;
            }
        }
        while(cur.next != null){
            cur = cur.next;
            ans = ans.next;
        }
        return ans;
    }
    //反转链表
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode next = head.next;
        ListNode pre = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }
    //合并两个有序链表
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head = null;
        if(list1.val < list2.val){
            head = list1;
            head.next = Merge(list1.next, list2);
        }else{
            head = list2;
            head.next = Merge(list1, list2.next);
        }
        return head;
    }
    //树的子结构
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                result = doesTree1HaveTree2(root1, root2);
            }
            if(!result)
                result = HasSubtree(root1.left, root2);
            if(!result)
                result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    public boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if(root2 == null){
            return true;
        }
        else if(root1 == null){
            return false;
        }
        else if(root1.val != root2.val){
            return false;
        }

        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
    //二叉树镜像
    public void Mirror(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return ;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null){
            Mirror(root.left);
        }
        if(root.right != null){
            Mirror(root.right);
        }
    }
    //纸牌游戏
    public void cardGame(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        while(sc.hasNext()){
            for(int i = 0; i < n; i ++){
                a[i] = sc.nextInt();
            }
        }
        Arrays.sort(a);
        int c = 0;
        int b = 0;
        boolean flag = true;
        for(int i = n - 1; i >= 0; i --){
            if(flag){
                b = b + a[i];
                flag = false;
            }else{
                c = c + a[i];
                flag = true;
            }
        }
        int ans = b - c;
        System.out.println(ans);
    }
    //顺时针打印矩阵
    /*public ArrayList<Integer> printMatrix(int [][] matrix) {
        
    }*/

    //买卖股票的最佳时机
    public int maxProfit1(int[] prices) {
        int maxMoney = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int tar = prices[i] - prices[j];
                maxMoney = maxMoney <= tar ? maxMoney : tar;
            }
        }
        return maxMoney < 0 ? - maxMoney : 0;
    }

    //包含min()函数的栈
     class minStackSolution {

        Stack stack = new Stack();
        Stack tarStack = new Stack();
        public void push(int node) {
            stack.push(node);
            if (!tarStack.isEmpty()) {
                if (node <= (int) tarStack.peek()) {
                    tarStack.push(node);
                } else {
                    tarStack.push(tarStack.peek());
                }
            } else {
                tarStack.push(node);
            }
        }

        public void pop() {
            stack.pop();
            tarStack.pop();
        }

        public int top() {
            return (int)stack.peek();
        }

        public int min() {
            return (int)tarStack.peek();
        }
    }

    //面试题23 从上往下打印二叉树 广度优先遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> fromTopToBottomList = new ArrayList<Integer>();
        Deque<Object> deque = new ArrayDeque<Object>();
        TreeNode currentNode = root;

        while (currentNode != null) {
            fromTopToBottomList.add(currentNode.val);
            if(currentNode.left != null)deque.offer(currentNode.left);
            if(currentNode.right != null) deque.offer(currentNode.right);
            currentNode = (TreeNode) deque.poll();
        }

        return fromTopToBottomList;
    }

    //面试题24 二叉搜索树的后续遍历序列
    public boolean VerifySquenceOfBST(int [] sequence){
        if (sequence.length <= 0) {
            return false;
        }
        return VerifySquenceOfBSTNew(sequence, 0, sequence.length-1);
    }
    public boolean VerifySquenceOfBSTNew(int [] sequence, int l, int r) {
        if (l >= r) {
            return true;
        }

        int root = sequence[r];

        //找到左子树和右子树
        int right = r;
        for (int i = l; i < r; i++) {
            if (sequence[i] > root) {
                right = i;
                break;
            }
        }

        //判断右子树是否有小于根节点的
        for (int i = right; i < r; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }

        //递归调用Verify函数，判断左子树和右子树是否符合

        return VerifySquenceOfBSTNew(sequence, l, right-1)&&VerifySquenceOfBSTNew(sequence, right, r-1);
    }

    //面试题25 二叉树中和为某一值的路径
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> pathAll = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        find(root, target, pathAll, path);
        return pathAll;
    }

    private void find(TreeNode root, int target, ArrayList<ArrayList<Integer>> pathAll, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        target = target- root.val;

        path.add(root.val);

        if (target == 0 && root.right == null && root.left == null) {
            pathAll.add(new ArrayList<Integer>(path));
        }

        if (root.left != null) {
            find(root.left, target, pathAll, path);
        }
        if (root.right != null) {
            find(root.right, target, pathAll, path);
        }

        path.remove(path.size() - 1);
}

    //面试题26 复杂链表的复制
    public static class RandomListNode {
        int label;
        public RandomListNode next = null;
        public RandomListNode random = null;

        public RandomListNode(int label) {
            this.label = label;
        }
    }
    public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        RandomListNode pHeadNew = new RandomListNode(pHead.label);
        RandomListNode current = pHead;
        RandomListNode currentNew = pHeadNew;
        currentNew.next = null;
        while(current != null /*&& currentNew != null*/){
            if(current.next != null){
                currentNew.next = new RandomListNode(current.next.label);
            }
            //currentNew.next = null;
            current = current.next;
            currentNew = currentNew.next;
        }
        current = pHead;
        currentNew = pHeadNew;
        while(current != null){
            if(current.random == null){
                currentNew.random = null;
                current = current.next;
                currentNew = currentNew.next;

            }
            else{
                RandomListNode random = pHead;
                RandomListNode randomNew = pHeadNew;
                while(current.random != random && random != null){
                    random = random.next;
                    randomNew = randomNew.next;
                }
                currentNew.random = randomNew;
                current = current.next;
                currentNew = currentNew.next;
            }
        }
        return pHeadNew;
    }

    //
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode last = null;
        TreeNode linkNode = pRootOfTree;
        while (linkNode != null && linkNode.left != null) {
            linkNode = linkNode.left;
        }

        Convert2(pRootOfTree, last);

        return linkNode;
    }

    private void Convert2(TreeNode pRootOfTree, TreeNode last) {
        if (pRootOfTree == null) {
            return;
        }

        TreeNode curr = pRootOfTree;
        if (pRootOfTree != null && pRootOfTree.left != null) {
            Convert2(pRootOfTree.left, last);
        }
        pRootOfTree.left = last;
        if (last != null) {
            last.right = pRootOfTree;
        }
        last = pRootOfTree;

        if (pRootOfTree.right != null) {

            Convert2(pRootOfTree.right, last);

        }

    }

    //整数中1出现的次数
    public int NumberOf1Between1AndN_Solution(int n) {
        int num = 0;
        for (int i = 1; i <= n; i = i * 10) {
            int k = n % (i * 10);
            num = num + n / (10 * i) * i;
            if (k > (i * 2 - 1)) {
                num = num + i;
            } else if (k < i) {
                num = num + 0;
            }else {
                num = num + k - i + 1;
            }
        }
        return num;
    }


    //把数组排成最小的数
    public String PrintMinNumber(int [] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                String ij = numbers[i] + "" + numbers[j];
                String ji = numbers[j] + "" + numbers[i];
                if (Integer.parseInt(ij) > Integer.parseInt(ji)) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < numbers.length; k++) {
            stringBuilder.append(numbers[k]);
        }
        return  stringBuilder.toString();
    }

    //丑数
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return -1;
        }
        if (index == 1) {
            return 1;
        }
        int i = 0;
        int Number = 1;
        while (i < index) {
            if (isUgly(Number)) {
                i++;
                Number++;
            }else {
                Number++;
            }
        }

        return Number--;
    }

    public Boolean isUgly(int Number) {
        while(Number%2 == 0){
            Number = Number / 2;
        }
        while(Number%3 == 0){
            Number = Number / 3;
        }
        while(Number%5 == 0){
            Number = Number / 5;
        }
        if (Number == 1) {
            return true;
        }
        return false;
    }

    public int GetUglyNumber_Solution2(int index) {
        if (index <= 0) {
            return -1;
        }
        if (index == 1) {
            return 1;
        }

        HashSet<Integer> hashSet = new HashSet<Integer>();

        hashSet.add(1);

        while (true) {

        }
    }

    //第一个只出现一次的字符
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))) {
                hashMap.put(str.charAt(i), (hashMap.get(str.charAt(i)) + 1));
            } else {
                hashMap.put(str.charAt(i), 1);
            }
        }

        for (int k = 0; k < str.length(); k++) {
            if (hashMap.get(str.charAt(k)) == 1) {
                return k;
            }
        }
        return -1;
    }

    //数组中的逆序对
    public int InversePairs(int [] array) {
        int p = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    p++;
                }
            }
        }

        return p%1000000007;
    }

    //输入两个链表，找出它们的第一个公共节点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int len1 = 0;
        int len2 = 0;
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;

        while (cur1 != null) {
            len1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            len2++;
            cur2 = cur2.next;
        }
        cur1 = pHead1;
        cur2 = pHead2;
        if (len1 > len2) {
            for (int i = 1; i <= len1 - len2; i++) {
                cur1 = cur1.next;
            }
        }else {
            for (int i = 1; i <= len2 - len1; i++) {
                cur2= cur2.next;
            }
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public int GetNumberOfK(int [] array , int k) {
        int index = findIndex(array, k, 0, array.length-1);
        if(index == -1){
            return 0;
        }
        int i = index - 1;
        int j = index + 1;
        int num = 1;
        while (i >= 0 && array[i] == k) {
            num++;
            i--;
        }
        while (j < array.length && array[j] == k) {
            num++;
            j++;
        }

        return num;
    }
    public int findIndex(int[] array,int k, int l, int r){
        if(l > r){
            return -1;
        }
        int mid = (l + r)/2;
        if(array[mid] == k){
            return mid;
        }
        if(array[mid] > k){
            return findIndex(array, k, l, mid-1);
        }
        if(array[mid] < k){
            return findIndex(array, k, mid +1, r);
        }
        return -1;
    }

    //二叉树的深度
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return Math.max(left, right) + 1;
    }

    //平衡二叉树
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        int dif = left - right;
        if (dif != 0) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left > right ? (left + 1) : (right + 1);
    }

    //数组中只出现一次的数字
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

    }

    //和为S的连续证书序列
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       // ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (sum < 3) {
            return null;
        }
        int pl = 0;
        int pr = 1;

        while (pl < pr) {
            int num = (pr + pl) * (pr - pl + 1) / 2;
            if (num == sum) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = pl; i <= pr; i++) {
                    arrayList.add(i);
                }
                result.add(arrayList);
                pr++;
            } else if (num < sum) {
                pr++;
            }else {
                pl++;
            }
        }
        return result;
    }

    //和为S的两个数字
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int pl = 0;
        int ph = array.length - 1;
        while (pl < ph) {
            int cur = array[pl] + array[ph];
            if (cur == sum) {
                result.add(array[pl]);
                result.add(array[ph]);
                return result;
            } else if (cur < sum) {
                pl++;
            } else {
                ph--;
            }
        }
        return result;
    }

    //左旋转字符串
    public String LeftRotateString(String str,int n) {
        if (n > str.length()) {
            return "";
        }
        String copy = str;
        String l = copy.substring(0, n);
        String r = str.substring(n);
        return r+l;
    }

    //翻转单词顺序
    public String ReverseSentence(String str) {
        if(str == null || str == "" ||str == " "){
            return "";
        }
        String[] strings = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            stringBuilder.append(strings[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
        return stringBuilder.toString();
    }

    //扑克牌顺子
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return false;
        }
        boolean result = false;
        int num = numbers.length;

        Arrays.sort(numbers);

        int keys = 0;
        for (int i = 0; i < num; i++) {
            if (numbers[i] == 0) {
                keys++;
            }
        }


        for (int k = num - 2;k >= 0 && numbers[k] != 0; k--) {
            int div = numbers[k + 1] - numbers[k];
            if (div == 0) {
                return false;
            } else {
                keys = keys - (div - 1);
            }
        }
        if (keys >= 0) {
            result = true;
        }
        return result;
    }


    //孩子们的游戏
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        LinkedList<Integer> head = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            head.add(i);
        }

        int bt = 0;
        while (head.size() > 1) {
            bt = (bt + m - 1) % head.size();
            head.remove(bt);
        }
        return head.size() == 1 ? head.get(0) : -1;
    }

    //求1+2+3+。。。+n
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
