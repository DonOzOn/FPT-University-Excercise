/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Don OzOn
 */
public class StudentFuntion {

    Validator val = new Validator();
    Scanner t = new Scanner(System.in);
    ArrayList<Student> listStudents = new ArrayList<>();

    public Student add() {
        Student std = new Student();
        std.setName(val.checkname("Enter name: "));
        System.out.print("Enter class:  ");
        std.setClasses(t.nextLine());
        std.setMark((float) val.checkMark("Enter mark :  "));
        return std;
    }

    List<Student> sortStudent(List<Student> students) {
        Collections.sort(students);
        return students;
    }

    public String toString(Student std) {
        return "name: " + std.getName() + "\n" + "class: " + std.getClasses() + "\n" + "mark: " + std.getMark();
    }
    public void display(List<Student> students){
           for (int i = 0; i < students.size(); i++) {
            System.out.println("-- -- -- Student" + (i + 1) + "-- -- --");
            System.out.println(toString(students.get(i)));
        }
    }
    public void input(List<Student> students){
         do {
           students.add(add());
        } while (val.checkYN());
    }
    
}
