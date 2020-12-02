package ManageStudent;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Manage {

    private static Validator val = new Validator();
    private static Scanner t = new Scanner(System.in);

    public Student addInformation(ArrayList<Student> students) {
        boolean check = false;
        Student std = new Student();
        String code = null;
        do {
            System.out.print("Enter code: ");
            code = t.nextLine();
            String course;
            int n;
            check = false;
            if (!code.isEmpty()) {
                for (Student student : students) {
                    if (code.equalsIgnoreCase(student.getId())) {
                        //reenter Semester and Course name if duplicate
                        System.out.println("Code is duplicate");
                        do {
                            n = val.checkSemester("enter Semester : ");
                            course = val.checkString("enter CourseName : ", false);
                            if (n == student.getSemester() && course.equals(student.getCourseName())) {
                                System.out.println("semester have this course already , enter again");
                            }//cant exits same Course name in Same Semester
                        } while (n == student.getSemester() && course.equals(student.getCourseName()));
                        return new Student(code, student.getStudentName(), n, course);
                    }
                }
            } else {
                System.out.println("code is not empty");
                check = true;
            }
        } while (check);
        std.setId(code);
        std.setStudentName(val.checkString("enter name : ", true));
        std.setSemester(val.checkSemester("enter Semester : "));
        std.setCourseName(val.checkString("enter CourseName : ", false));

        return std;
    }
//Sort by Name with colection.sort

//    ArrayList<Student> sortStudent(ArrayList<Student> students) {
//        
//        return students;
//    }
//Search Student

    public ArrayList<Student> sortaAndSearchStudent(ArrayList<Student> students) {
        ArrayList<Student> al = new ArrayList<>();//Create new Array to save data of student we found
        Collections.sort(students);
        display(students);
        boolean check;
        do {
            check = true;
            System.out.print("Enter text:");
            String text = t.nextLine();
            for (Student student : students) {
                {//if your text contain in Name 
                    if ((student.getStudentName().contains(text))) {
                        check = false;
                        al.add(student);//add that  information to new arraylist
                    }
                }
            }
        } while (check);
        //display new ArrayList contain data student we searched
        System.out.println("-- -- -- -- - Result -- -- -- -- -- --");

        for (Student student : al) {
            System.out.println(student.getStudentName());
            System.out.println(student.getSemester());
            System.out.println(student.getCourseName());
        }

        return students;
    }

    public ArrayList<Student> updateOrDelete(ArrayList<Student> students) {
        boolean check;
        do {
            check = true;
            System.out.print("Enter code:");
            String code = t.nextLine();
            for (Student student : students) {
                if (code.equalsIgnoreCase(student.getId())) {//work if code enter exist in arraylist
                    check = false;
                    System.out.println("");

                    switch (val.checkUD("you want up or de")) {
                        case "U":
                            student.setStudentName(val.checkString("Update Name: ", true));
                            student.setSemester(val.checkSemester("Update Semester: "));
                            student.setCourseName(val.checkString("Update course name: ", false));
                            break;
                        case "u":
                            student.setStudentName(val.checkString("Update Name: ", true));
                            student.setSemester(val.checkSemester("Update Semester: "));
                            student.setCourseName(val.checkString("Update course name: ", false));
                            break;
                        case "D":
                            students.remove(student);
                            break;
                        case "d":
                            students.remove(student);
                            break;

                    }
                }
                if (check) {
                    System.out.println("Code not exist");
                }
            }
        } while (check);
        displayAll(students);
        return students;

    }

    public void report(ArrayList<Student> students) {
        int[] totalCourses = new int[students.size()];
        for (int i = 0; i < students.size(); i++) {
            totalCourses[i] = 1;
        }
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (totalCourses[i] != 0
                        && students.get(i).getId().equalsIgnoreCase(students.get(j).getId())
                        && students.get(i).getCourseName().equalsIgnoreCase(students.get(j).getCourseName())) {
                    totalCourses[i]++;
                    totalCourses[j] = 0;
                }
            }
        }
        for (int i = 0; i < students.size(); i++) {
            if (totalCourses[i] != 0) {
                System.out.println(students.get(i).getStudentName() + " | "
                        + students.get(i).getCourseName() + " | "
                        + totalCourses[i]);
            }
        }
        System.out.println();
    }
//display all Student's Infor
    public void displayAll(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
//display name Student and course name
    public void display(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(student.getStudentName());
            System.out.println(student.getCourseName());

        }
    }
//Add Student's infor to Array list
    public void add(ArrayList<Student> students) {
        int i = 1;
        //enter least 5
        do {
            students.add(addInformation(students));
            i++;
        } while (i < 2);
        do {
            students.add(addInformation(students));
        } while (val.checkYN());
        displayAll(students);
    }
}
