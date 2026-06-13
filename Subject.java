
package ANU;

import java.util.ArrayList;

public class Subject  {
    protected String teacherAssigned;
    protected String Subject_Name;
    protected ArrayList<Subject> subjects;

    public Subject() {
    }

    public Subject(String teacherAssigned, String Subject_Name, ArrayList<Subject> subjects) {
        this.teacherAssigned = teacherAssigned;
        this.Subject_Name = Subject_Name;
        this.subjects = subjects;
    }
    
    public String getSubject_Name() {
        return Subject_Name;
    }

    public void setSubject_Name(String Subject_Name) {
        this.Subject_Name = Subject_Name;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }


    public Subject(String teacherAssigned) {
        this.teacherAssigned = teacherAssigned;
    }

    public String getTeacherAssigned() {
        return teacherAssigned;
    }

    public void setTeacherAssigned(String teacherAssigned) {
        this.teacherAssigned = teacherAssigned;
    }

    public void create() {
        System.out.println("Created subject: " + Subject_Name);
    }

    public void edit(String newName) {
        this.Subject_Name = newName;
        System.out.println("Edited subject: " + Subject_Name);
    }

    
    public void delete() {
        System.out.println("Deleted subject: " + Subject_Name);
    }
}


