/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageStudent;

import java.util.Scanner;

/**
 *
 * @author Don OzOn
 */
public class Validator {

    Scanner t = new Scanner(System.in);
//check Name and Speciality 

    public String checkString(String mess, boolean check) {
        String value;
        while (true) {
            do {
                System.out.print(mess);
                value = t.nextLine();
                if (value.isEmpty()) {
                    System.out.println("no data , please enter !");
                }
            } while (value.isEmpty());
            if (check) {//for Name
                if (!value.matches("^[a-zA-Z' ']{1,200}$")) { // chuoi lay 1-200  ki tu tu a-z 
                    System.out.println("No number, no ki tu dac biet,please enter");
                } else {
                    value.trim(); //xoa khoang trang dau va cuoi
                    value = value.replaceAll("\\s+", " "); //thay mot hoac nhieu khoang trang thanh 1 khoang trang
                    return value;
                }
            } else {//for Speciality
                if (value.equalsIgnoreCase("java") || value.equalsIgnoreCase(".net") || value.equalsIgnoreCase("C/C++")) {
                    return value;
                } else {
                    System.out.println("must Java||.Net||c/c++");
                }
            }

        }
    }
//check availability

    public int checkSemester(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                int avail = Integer.parseInt(t.nextLine());//work if availbility >0
                if (avail <= 0) {
                    System.out.println("must greater than 0");
                } else {
                    return avail;
                }
            } catch (Exception e) {
                System.out.println("it is not a number,try again");
            }
        }
    }
//check Choose

    public int checkChoose(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                int choose = Integer.parseInt(t.nextLine());//work if 0<=choose=<5
                if (choose > 5) {
                    System.out.println("must smaller equal than 5");
                } else if (choose < 0) {
                    System.out.println("must greater than 0");
                } else {
                    return choose;
                }
            } catch (Exception e) {
                System.out.println("it is not a number,try again");

            }
        }
    }
// check yes or no

    public boolean checkYN() {
        while (true) {
            System.out.print("do you want add more??(Y/N): ");
            String yn = t.nextLine();
            if (yn.equalsIgnoreCase("Y")) { //work if input Yes/no
                return true;
            } else if (yn.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Input again!");
            }
        }
    }

    public String checkUD(String mess) {
        String ud;
        while (true) {
            System.out.println(mess);
            ud = t.nextLine();
            if (ud.equalsIgnoreCase("U") || ud.equalsIgnoreCase("D")) {//work if enter U or D
                return ud;
            } else {
                System.out.println("Please enter U or D");
            }

        }
    }
}
