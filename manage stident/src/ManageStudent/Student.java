/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageStudent;

/**
 *
 * @author Don OzOn
 */
public class Student  implements Comparable<Student>{

   private String id;
   private String studentName;
   private int semester;
   private String courseName;
   Student(){
       
   }

    public  Student(String id, String studentName, int semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", studentName=" + studentName + ", semester=" + semester + ", courseName=" + courseName + '}';
    }

    @Override
    public int compareTo(Student o) {
       return this.studentName.compareToIgnoreCase(o.studentName);   
    }
   
}