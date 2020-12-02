package ManageStudent;

import java.util.ArrayList;

public class Main {

    private static Validator val = new Validator();
    private static Manage ma = new Manage();
    private static ArrayList<Student> std = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("========= Student Management ==========");
            System.out.println("1.Creat");;
            System.out.println("2.Find/sort");;
            System.out.println("3.Update/delete");;
            System.out.println("4.Report");;
            System.out.println("5.Exit");;
            switch (val.checkChoose("Your choose (1-5): ")) {
                case 1:
                    System.out.println("-- -- -- -- - Creat -- -- -- -- --");
                    ma.add(std);
                    break;
                case 2:
                    System.out.println("-- -- -- -- - Find/Sort-- -- -- -");
//                    std = ma.sortStudent(std);
                    std = ma.sortaAndSearchStudent(std);
                    break;
                case 3:
                    System.out.println("-- -- -- -- - Update/Delete -- -- -- -");
                    std = ma.updateOrDelete(std);
                    break;
                case 4:
                    ma.report(std);
                    break;
                case 5:

                    System.exit(0);
                    break;
            }

        }

    }

}
