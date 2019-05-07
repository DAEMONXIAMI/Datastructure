package main;

import java.util.Scanner;

public class NodeNum {
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
/*        int a, b;
        while(cin.hasNextInt())
        {
            a = cin.nextInt();
            b = cin.nextInt();
            System.out.println(a + b);
        }*/
        int n = cin.nextInt();
        int[][] a = new int[n][2];
        int i = 0;
        int num = n;
        while(cin.hasNextInt())
        {
            a[i][0] = cin.nextInt();
            a[i][1] = cin.nextInt();
            i++;
        }
        i = 0;

/*        while (a[i][0] != 0 && a[i][1] != 0) {
            int j = i+1;
            if (j < n && a[j][0] != 0 && a[j][1] != 0) {

                Boolean b = ifchonghe(a, i, i + 1);
                if (b) {
                    num --;
                    j ++;
                }
                j ++;
            }
        }*/

        while (i < n) {

           for (int j = i +1; j < n && a[j][0] != 0 && a[j][1] != 0;) {
                Boolean b = ifchonghe(a, i, j);
                if (b) {
                    num --;
                    a[j][0] = 0;
                    a[j][1] = 0 ;
                }
                j ++;
            }
            while (i + 1 < n ) {
                i = findi(a, i + 1, n);
            }
        }
        System.out.println(num);

    }

    private static int findi(int[][] a, int i, int n) {
        while (i < n){
        if (a[i][0] != 0 && a[i][1] != 0) {
            return i;
        } else {
            i++;
        }
        }
        return n;
    }

    public static Boolean ifchonghe(int[][] a, int a1, int a2) {
        if(a[a1][0] > a[a1][1] ) {
            int temp = a[a1][0];
            a[a1][0] =a[a1][1];
            a[a1][1] = temp;
        }
        if(a[a2][0] > a[a2][1] ) {
            int temp = a[a2][0];
            a[a2][0] =a[a2][1];
            a[a2][1] = temp;
        }
        if(a[a1][1] <= a[a2][1]){
            if (a[a1][1] >= a[a2][0]) {
                return true;
            }
        }
        if(a[a1][1] > a[a2][1]){
            if (a[a1][0] <= a[a2][1]) {
                return true;
            }
        }
        return false;
    }
}
