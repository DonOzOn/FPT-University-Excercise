/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Scanner;

/**
 *
 * @author Don OzOn
 */
public class Validator {
    Scanner s=new Scanner(System.in);
    //check mark
     public float checkMark(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                float mark = Float.parseFloat(s.nextLine());//work if 0<=mark<=10
                if (mark > 10) {
                    System.out.println("must smaller equal than 10");
                } else if (mark < 0) {
                    System.out.println("must greater than 0");
                } else {
                    return mark;
                }
            } catch (Exception e) {
                System.out.println("it is not a number,try again");
            }
        }
    }
      public boolean checkYN() {
        while (true) {
            System.out.print("do you want add more??(Y/N): ");
            String yn = s.nextLine();
            if (yn.equalsIgnoreCase("Y")) { //lay ca chu thuong lan chu hoa
                return true;
            } else if (yn.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Input again!");
            }
        }
    }
    public String checkname(String mess) {
        while (true) {
            System.out.print(mess);
            String name = s.nextLine();
            if (name.isEmpty()) { //neu file rong thi thong bao va yeu cau nhap
                System.out.println("No data,please enter");
            }else if(!name.matches("^[a-zA-Z' ']{1,200}$")){ // chuoi lay 1-200  ki tu tu a-z 
                System.out.println("No number, no ki tu dac biet,please enter");   
            } else {
                name.trim(); //xoa khoang trang dau va cuoi
                name = name.replaceAll("\\s+", " "); //thay mot hoac nhieu khoang trang thanh 1 khoang trang
                return name;
            }
        }

    }
}
