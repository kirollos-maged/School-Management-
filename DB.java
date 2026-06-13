
package ANU;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class DB {
    private static final String DB_PATH = "jdbc:sqlite:D:\\L1\\Tasks 2\\Tasks OOP\\FINAL\\FINAL.db";
    private static Connection conn;

    public DB() {
        try {
            conn = DriverManager.getConnection(DB_PATH);
              conn.setAutoCommit(true); 
            System.out.println("Connect Success");
            createTables();
        } catch (SQLException e) {
            System.out.println("Connect failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createTables() {
        try {
            String createStudentsTable = """
                CREATE TABLE IF NOT EXISTS Student (
                    student_id INTEGER PRIMARY KEY,
                    student_name TEXT NOT NULL,
                    student_email TEXT UNIQUE NOT NULL,
                    student_phone TEXT,
                    student_major TEXT,
                    student_year TEXT
                )
            """;
           
                String createTeachersTable = """
                CREATE TABLE IF NOT EXISTS Teacher(
                    teacher_name TEXT ,
                    teacher_email TEXT UNIQUE NOT NULL,
                    teacher_phone TEXT,
                    teacher_sallary TEXT,
                    teacher_subject TEXT
                )
           """;                   
            

         
            Statement stmt = conn.createStatement();
            stmt.execute(createStudentsTable);
           stmt.execute(createTeachersTable);

            System.out.println("Tables created successfully");
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }

    public static String login(String email, String password, String role) {
        String sql = "SELECT users_role FROM users WHERE users_email = ? AND users_password = ? AND users_role = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("users_role");
            }
        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return null;
    }

    public static boolean addStudent(Student student) {
        String query = "INSERT INTO Student (student_id, student_name, student_email, student_phone, student_major, student_year) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getPhone());
            stmt.setString(5, student.getMajor());
            stmt.setString(6, student.getYear());

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.out.println("Error while saving student: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addTeacher(Teacher t) {
        String query = "INSERT INTO Teacher (teacher_name, teacher_email, teacher_phone, teacher_sallary, teacher_subject) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
             stmt.setString(2, t.email);
            stmt.setString(1, t.name);
            stmt.setString(3, t.phone);
            stmt.setDouble(4, t.salary);
            stmt.setString(5, t.subject);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.out.println("Error while saving teacher: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

 

    public static void createTablesIfNotExist() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                     "name TEXT Not Null, " +
                     "email TEXT PRIMARY KEY, " +
                     "password TEXT NOT NULL, " +
                     "role TEXT NOT NULL" +
                     ");";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Users table checked/created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating users table: " + e.getMessage());
        }
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();

        String sql = "SELECT student_id, student_name, student_email, student_phone, student_major, student_year FROM Student";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Student student = new Student(
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getString("student_email"),
                    rs.getString("student_phone"),
                    rs.getString("student_major"),
                    rs.getString("student_year")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
 public ArrayList<Teacher> getAllTeachers() {
        ArrayList<Teacher> teachers = new ArrayList<>();

        String sql = "SELECT teacher_name, teacher_email, teacher_phone, teacher_sallary, teacher_subject FROM Teacher";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Teacher teacher = new Teacher(
                        rs.getString("teacher_name"),
                        rs.getString("teacher_email"),
                        rs.getString("teacher_phone"),
                        rs.getDouble("teacher_sallary"),
                        rs.getString("teacher_subject")
                );
                teachers.add(teacher);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error loading teachers.");
            e.printStackTrace();
        }

        return teachers;
    }
    
    public static void deleteStudentFromDatabase(int id) {
        String sql = "DELETE FROM Student WHERE student_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "error in deleting student " + ex.getMessage());
        }
    }
    public static void deleteTeacherFromDatabase(String email) {
        String sql = "DELETE FROM Teacher WHERE teacher_email= ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, email);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "error in deleting teacher " + ex.getMessage());
        }
    }
  public static void updateStudent(int id, String name, String email, String phone, String major, String year) {
    String sql = "UPDATE Student SET student_name = ?, student_email = ?, student_phone = ?, student_major = ?, student_year = ? WHERE student_id = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setString(3, phone);
        pstmt.setString(4, major);
        pstmt.setString(5, year);
        pstmt.setInt(6, id);

        int rowsAffected = pstmt.executeUpdate();
        System.out.println("Rows updated: " + rowsAffected);

        // ✅ تحقق من التحديث
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Student WHERE student_id = " + id);
        if (rs.next()) {
            System.out.println("Updated name: " + rs.getString("student_name"));
            System.out.println("Updated email: " + rs.getString("student_email"));
            System.out.println("Updated phone: " + rs.getString("student_phone"));
            System.out.println("Updated major: " + rs.getString("student_major"));
            System.out.println("Updated year: " + rs.getString("student_year"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
  public static void updateTeacher(String name, String email, String number, double salary, String subject) {
    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\L1\\Tasks 2\\Tasks OOP\\FINAL\\FINAL.db")) {
        String sql = "UPDATE Teacher SET teacher_name = ?, teacher_number = ?, teacher_sallary = ?, teacher_subject = ? WHERE teacher_email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, number);
            pstmt.setDouble(3, salary);
            pstmt.setString(4, subject);
            pstmt.setString(5, email);

            int rows = pstmt.executeUpdate();
            if (rows == 0) {
                JOptionPane.showMessageDialog(null, "No teacher found with this email.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to update teacher.");
    }
}


       public List<String[]> mmgetAllStudents() {
    List<String[]> students = new ArrayList<>();
    String query = "SELECT student_id, student_name FROM Student";
    
    try (Connection conn = DriverManager.getConnection(DB_PATH);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        while (rs.next()) {
            String[] student = new String[2];
            student[0] = rs.getString("student_id");
            student[1] = rs.getString("student_name");
            students.add(student);
        }
    } catch (SQLException e) {
        System.err.println("Error getting students: " + e.getMessage());
    }
    return students;
}

public List<String[]> getAllCourses() {
    List<String[]> courses = new ArrayList<>();
    String query = "SELECT course_name FROM Course";
    
    try (Connection conn = DriverManager.getConnection(DB_PATH);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        while (rs.next()) {
            String[] course = new String[1];
            course[0] = rs.getString("course_name");
            courses.add(course);
        }
    } catch (SQLException e) {
        System.err.println("Error getting courses: " + e.getMessage());
    }
    return courses;
}

public boolean enrollStudent(String studentId, String courseName, String courseName1) {
    String query = "INSERT INTO Student_Course (student_id, course_name) VALUES (?, ?)";
    
    
         try(PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setString(1, studentId);
        pstmt.setString(2, courseName);
        
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    } catch (SQLException e) {
        System.err.println("Error enrolling student: " + e.getMessage());
        return false;
    }
}

public List<String[]> getCurrentEnrollments() {
    List<String[]> enrollments = new ArrayList<>();
    String query = "SELECT sc.student_id, s.student_name, sc.course_name FROM Student_Course sc JOIN Student s ON sc.student_id = s.student_id";
    
    try (
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        while (rs.next()) {
            String[] enrollment = new String[3];
            enrollment[0] = rs.getString("student_id");
            enrollment[1] = rs.getString("student_name");
            enrollment[2] = rs.getString("course_name");
            enrollments.add(enrollment);
        }
    } catch (SQLException e) {
        System.err.println("Error getting enrollments: " + e.getMessage());
    }
    return enrollments;
}

public boolean enrollStudent(int studentId, String courseName,String studentName) {
    if (!studentExists(studentId)) {
        return false;
    }
    
    String query = "INSERT INTO Student_Course (student_id, course_name ,student_name) VALUES (?, ?,?)";
    
    try (
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, studentId);
        pstmt.setString(2, courseName);
        pstmt.setString(3,studentName);
        return pstmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.err.println("Error enrolling student: " + e.getMessage());
        return false;
    }
}

private boolean studentExists(int studentId) {
    String query = "SELECT 1 FROM Student WHERE student_id = ?";
    try (
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, studentId);
        return pstmt.executeQuery().next();
    } catch (SQLException e) {
        System.err.println("Error checking student: " + e.getMessage());
        return false;
    }
}

}
