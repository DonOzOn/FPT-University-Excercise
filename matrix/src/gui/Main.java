package gui;

import bo.matrix;
import java.util.Scanner;
import ultil.Cal;
import ultil.Validator;

public class Main {

    static matrix ma = new matrix();
    private static Cal cal = new Cal();
    private static Validator val = new Validator();
    Scanner t = new Scanner(System.in);

    public static void main(String[] args) {
        int choose = 0;
        do {
            System.out.println("==========calculator program=======");
            System.out.println("1.Addition matrix");
            System.out.println("2.Subtraction matrix");
            System.out.println("3.Multiplication matrix");
            System.out.println("4.Quit");
            switch (val.checkChoose("your choose (1-4) :  ")) {
                case 1:
                    cal.option1();
                    break;
                case 2:
                    cal.option2();
                    break;
                case 3:
                    cal.option3();
                    break;
                case 4:
                    System.exit(0);
            }
        }while(choose!=4);
    }
}
