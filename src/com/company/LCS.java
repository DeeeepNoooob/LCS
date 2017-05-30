package com.company;

public class LCS {
    private char[] x;
    private char[] y;
    private int[][] c;
    private int[][] b;
    private int rl;
    private char[] r;

    LCS(char[] x, char[] y) {
        this.x = x;
        this.y = y;
        this.rl = ll(x, y);
        this.r = new char[rl];
    }

    public int ll(char[] x, char[] y) {
        this.x = x;
        this.y = y;
        int m = this.x.length;
        int n = this.y.length;
        c = new int[m + 1][n + 1];
        b = new int[m + 1][n + 1];
        int i, j;
        for (i = 0; i <= m; i++) {
            c[i][0] = 0;
        }
        for (i = 0; i <= n; i++) {
            c[0][i] = 0;
        }
        for (i = 1; i <= m; i++) {

            for (j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i - 1][j] > c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 2;
                } else if (c[i - 1][j] <= c[i][j - 1]) {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 3;
                }

            }

        }
        return c[m][n];
    }

    public void lcs(int i, int j, char[] x, char[] y) {
        if (i == 0 || j == 0) {
            return;
        }
        if (b[i][j] == 1) {
            r[rl - 1] = x[i - 1];
            rl--;
            lcs(i - 1, j - 1, x, y);
        } else {
            if (b[i][j] == 2) {
                lcs(i - 1, j, x, y);
            } else if (b[i][j] == 3) {
                lcs(i, j - 1, x, y);
            } else
                lcs(i - 1, j, x, y);

        }
    }


    public static void main(String[] args) {
        char a[] = new Char().Chars();
        System.out.print("字符串A：" + " ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        char b[] = new Char().Chars();
        System.out.print("字符串B：" + " ");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+" ");
        }
        System.out.println();
        LCS lcs = new LCS(a, b);
        lcs.lcs(a.length, b.length, a, b);
        System.out.print("最长公共子序列：" + " ");
        for (int i = 0; i < lcs.r.length; i++)
            System.out.print(lcs.r[i] + " ");
    }
}
