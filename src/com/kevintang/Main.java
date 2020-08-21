package com.kevintang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // size entry
        System.out.println("Please enter the size of desired n x n square matrix in format of [n n]:");
        System.out.println("Do not leave space beyond the last entry");
        Scanner in = new Scanner(System.in);
        String size = in.nextLine();
        if (size.length() == 0 || size.length() > 3) {
            System.out.println("Invalid Input!");
            System.exit(-1);
        }
        Reader input = new Reader(size);
        int[] sizeNum = input.readLine();
        int m = sizeNum[0], n = sizeNum[1];
        if (m != n) {
            System.out.println("Invalid Input!");
            System.exit(-1);
        }

        // matrix entry
        System.out.println("Please enter a " + m + " x " + n + " matrix to compute its determinant:");
        System.out.println("Use format [a1 a2 a3 a4 ... an] for entries 1 to n");
        Matrix target = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            System.out.println("Row " + i + ":");
            String line = in.nextLine();
            if (line.length() != 2 * n - 1) {
                System.out.println("Invalid Input!");
                System.exit(-1);
            }
            Reader inLine = new Reader(line);
            int[] inNum = inLine.readLine();
            target.setRow(i, inNum);
        }

        // Print matrix
        target.prt();

        // Print determinant of matrix
        System.out.println("The determinant of this matrix is: " + target.selfDet());
    }
}
