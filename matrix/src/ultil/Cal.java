/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultil;

import bo.matrix;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Don OzOn
 */
public class Cal {

    Validator val = new Validator();
    matrix ma = new matrix();
    Scanner t = new Scanner(System.in);

    public int[][] input(int row, int col) {
        int matrix[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = val.checkIntRC("matrix" + "[" + (i + 1) + "]" + "[" + (j + 1) + "]" + ": ", false);
            }
        }

        return matrix;
    }

    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2, int row, int col) {
        int sum[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("-------------result-----------------");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("+");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=");
        return sum;
    }

    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2, int row, int col) {
        int sub[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sub[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        System.out.println("-------------result-----------------");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=");

        return sub;
    }

    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2, int row1, int col1, int row2, int col2) {
        row1 = matrix1.length;
        col1 = matrix1[0].length;
        row2 = matrix2.length;
        col2 = matrix2[0].length;
        if (col1 != row1) {
            throw new RuntimeException("Ile");
        }
        int mul[][] = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    mul[i][j] = mul[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("-------------result-----------------");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("*");
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                System.out.print(mul[i][j] + " ");
            }
            System.out.println();
        }
        return mul;
    }

    public void displayMatrix(int[][] matrix1, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void option1() {
        int matrix1[][] = new int[ma.getRowa()][ma.getCola()];
        int matrix2[][] = new int[ma.getRowa()][ma.getCola()];
        int sum[][] = new int[ma.getRowa()][ma.getCola()];
        ma.setRowa(val.checkIntRC("enter row ", true));
        ma.setCola(val.checkIntRC("enter colum ", true));
        System.out.println("Matrix 1:");
        matrix1 = input(ma.getRowa(), ma.getCola());
        System.out.println("Matrix 2: ");
        matrix2 = input(ma.getRowa(), ma.getCola());
        sum = additionMatrix(matrix1, matrix2, ma.getRowa(), ma.getCola());
        displayMatrix(sum, ma.getRowa(), ma.getCola());

    }

    public void option2() {
        int matrix2[][] = new int[ma.getRowa()][ma.getCola()];
        int matrix1[][] = new int[ma.getRowa()][ma.getCola()];
        int sub[][] = new int[ma.getRowa()][ma.getCola()];
        ma.setRowa(val.checkIntRC("enter row ", true));
        ma.setCola(val.checkIntRC("enter colum ", true));
        System.out.println("Matrix 1:");
        matrix1 = input(ma.getRowa(), ma.getCola());
        System.out.println("Matrix 2:");
        matrix2 = input(ma.getRowa(), ma.getCola());
        sub = subtractionMatrix(matrix1, matrix2, ma.getRowa(), ma.getCola());
        displayMatrix(sub, ma.getRowa(), ma.getCola());

    }

    public void option3() {
        int matrix2[][] = new int[ma.getRowa()][ma.getCola()];
        int matrix1[][] = new int[ma.getRowa()][ma.getCola()];
        int mul[][] = new int[ma.getRowa()][ma.getColb()];
        ma.setRowa(val.checkIntRC("enter row ", true));
        ma.setCola(val.checkIntRC("enter colum ", true));
        matrix1 = input(ma.getRowa(), ma.getCola());
        ma.setRowb(val.checkIntRC("enter row ", true));
        ma.setColb(val.checkIntRC("enter colum ", true));
        matrix2 = input(ma.getRowb(), ma.getColb());
        mul = multiplicationMatrix(matrix1, matrix2, ma.getRowa(), ma.getCola(), ma.getRowb(), ma.getColb());
    }

}
