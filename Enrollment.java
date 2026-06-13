/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ANU;

/**
 *
 * @author amalg
 */
public class Enrollment {
    private int studentId;
    private String studentName;
    private String courseName;
    
    public Enrollment(int studentId, String studentName, String courseName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourseName() {
        return courseName;
    }
    
}
