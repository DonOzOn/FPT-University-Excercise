/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Don OzOn
 */
public class Main {

    private static Validator val = new Validator();
    private static Information in = new Information();
    private static ArrayList<Doctor> doc = new ArrayList<>();

    public static void main(String[] args) throws IOException {
   
        while (true) {
            System.out.println("========= Doctor Management ==========");
            System.out.println("1.Add");;
            System.out.println("2.Update");;
            System.out.println("3.Delete");;
            System.out.println("4.Search");;
            System.out.println("5.Exit");;
            switch (val.checkChoose("Your choose (1-5): ")) {
                case 1:
                    System.out.println("-- -- -- -- - Add Doctor -- -- -- -- --");
                    in.add(doc);
                  
                    break;
                case 2:
                    System.out.println("-- -- -- -- - Update Doctor -- -- -- -");
                    doc = in.updateInformation(doc);
                    break;
                case 3:
                    System.out.println("-- -- -- -- - Delete Doctor -- -- -- -");
                    doc = in.deleteDoctor(doc);
                    break;
                case 4:
                    System.out.println("-- -- -- -- -- Search Doctor -- -- -- --");
                    doc = in.searchDoctor(doc);
                    break;
                case 5:
                
                    System.exit(0);
                    break;
            }

        }
    }
}
