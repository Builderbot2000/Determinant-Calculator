package com.kevintang;

public class Matrix {
    int rows;
    int columns;
    int[][] field;

    Matrix(int height, int width) {
        rows = height;
        columns = width;
        field = new int[rows][columns];
    }

    void setRow(int index, int[] input) {
        System.arraycopy(input, 0, field[index], 0, columns);
    }

    void prt() {
        if (field == null) {
            System.out.println("NULL matrix!");
        } else {
            System.out.println("----------------->");
            for (int i = 0; i < rows; i++) {
                String out = "";
                for (int j = 0; j < columns; j++) {
                    String val = String.valueOf(field[i][j]);
                    out = out.concat(val + " ");
                }
                System.out.println(out);
            }
            System.out.println("----------------->");
        }
    }

    int getDet(Matrix part) {
        // base case
        if (part.rows == 2 && part.columns == 2) {
            return part.field[0][0] * part.field[1][1] - part.field[0][1] * part.field[1][0];
        }
        // recursive case
        int det = 0;
        for (int i = 0; i < part.columns; i++) {
            //construct partition for cofactor expansion
            Matrix partition = new Matrix(part.rows - 1, part.columns - 1);
            int r = 1;
            while (r <= part.rows - 1) {
                //System.out.println("Filling row " + r);
                int c = 0, c2 = 0;
                while (c <= partition.columns) {
                    if (c != i) {
                        partition.field[r - 1][c2] = part.field[r][c];
                        c2++;
                    }
                    c++;
                }
                r++;
            }
            // recursive procedure
            // partition.prt();
            // System.out.println("det += " + Math.pow(-1, i) + " x " + part.field[0][i] + " x " + getDet(partition));
            det += Math.pow(-1, i) * part.field[0][i] * getDet(partition);
        }
        return det;
    }

    int selfDet() {
        return getDet(this);
    }
}
