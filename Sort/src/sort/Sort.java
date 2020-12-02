package sort;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Sort extends Exception {

    private static Scanner t = new Scanner(System.in);

    static void bubbleIncreasing(int[] ar) {
        int n = ar.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (ar[j - 1] > ar[j]) {
                    //swap elements  
                    temp = ar[j];
                    ar[j] = ar[j - 1];
                    ar[j - 1] = temp;
                }

            }

        }
        for (int i = 0; i < n; i++) {
            System.out.print("[" + ar[i] + "]");
            if (i < n - 1) {
                System.out.print("-->");
            }
        }
        System.out.println();

    }

    static void bubbleDecreasing(int[] ar) {
        int n = ar.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (ar[j - 1] < ar[j]) {
                    //swap elements  
                    temp = ar[j - 1];
                    ar[j - 1] = ar[j];
                    ar[j] = temp;
                }

            }

        }
        for (int i = 0; i < n; i++) {
            System.out.print("[" + ar[i] + "]");
            if (i < n - 1) {
                System.out.print("<--");
            }
        }
        System.out.println();
    }

    static int[] inputArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("arr[" + i + "]" + " : ");
                    a[i] = Integer.parseInt(t.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("It mus number ! ");
                }
            }

        }
        return a;
    }

    static int size() {
        int size;
        while (true) {

            try {
                System.out.print("Enter size of arr:  ");
                size = Integer.parseInt(t.nextLine());
                if (size <= 0) {
                    System.out.println("size of Array mus>0");
                } else {
                    break;

                }
            } catch (Exception e) {
                System.out.println("must number");

            }
        }
        return size;

    }

    public static int checkChoose(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                int num = Integer.parseInt(t.nextLine());
                if (num > 4) {
                    System.out.println("must <=4 !");
                } else if (num <= 0) {
                    System.out.println("must >0 !");
                } else {
                    return num;
                }
            } catch (Exception e) {
                System.out.println("must be number");
            }

        }
    }

    public static void main(String[] args) {
        int choose;
        int[] arr = null;
        int sizeArr;
        while (true) {
            System.out.println("1.Input Element");
            System.out.println("2.Sort Acreasing");
            System.out.println("3.Sort decreasing");
            System.out.println("4.Exit");
            choose = checkChoose("Enter your choose: ");
            switch (choose) {
                case 1:
                    sizeArr = size();
                    arr = inputArray(sizeArr);
                    break;
                case 2:
                    bubbleIncreasing(arr);
                    break;
                case 3:
                    bubbleDecreasing(arr);
                    break;
                case 4:
                    System.exit(0);

            }

        }
    }
}
