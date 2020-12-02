/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Don OzOn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        Validator val = new Validator();
        StudentFuntion stdf = new StudentFuntion();
        stdf.input(students);
        students = stdf.sortStudent(students);
        stdf.display(students);
        
    }
    
}
