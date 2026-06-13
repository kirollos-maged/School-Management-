/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ANU;

/**
 *
 * @author kirom
 */
public class ProfileManager extends javax.swing.JFrame {
    
     public void viewProfile(Student student) {
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Phone: " + student.getPhone());
        System.out.println("Major: " + student.getMajor());
        System.out.println("Year: " + student.getYear());
    }
  public void updateEmail(Student student, String newEmail) {
        student.setEmail(newEmail);
    }  
  public void updatePhone(Student student, String newPhone) {
        student.setPhone(newPhone);
    }
}
