
package ANU;
import java.util.ArrayList;
public class Course {
    protected String instructor;
    protected String schedule;
    protected ArrayList<Subject> subjects;
    protected String assigned;
    protected String name;
    public Course() {
    }

    public Course(String instructor, String schedule, ArrayList<Subject> subjects, String assigned) {
        this.instructor = instructor;
        this.schedule = schedule;
        this.subjects = subjects;
        this.assigned = assigned;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        System.out.println("Subject " + subject.getSubject_Name() + " added to Course " + name);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
        System.out.println("Subject " + subject.getSubject_Name() + " removed from Course " + name);
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getCourseName() {
        return name;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    



}
