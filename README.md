🏫 School Management System

A Java desktop application for managing students, teachers, courses, and enrollment in a school environment. Built with Java Swing and SQLite.

---

## 📋 Features

- **Login System** — Role-based login for Students, Teachers, and Managers
- **Student Management** — Add, edit, view, and manage student records (name, email, phone, major, year)
- **Teacher Management** — Add and manage teacher profiles with subject assignments
- **Course & Enrollment** — Handle course data and student enrollment
- **Payment Tracking** — Basic payment record support
- **Profile Management** — User profile handling per role
- **Data Tables** — View and manage student and teacher tables with a GUI interface

---

## 🛠️ Built With

- **Java** (Swing / NetBeans GUI Builder)
- **SQLite** — Local database (`FINAL.db`)
- **JDBC** — Database connectivity

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 11 or higher
- NetBeans IDE (recommended) or any Java IDE
- SQLite JDBC driver

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/school-management.git
   ```

2. Open the project in NetBeans (File → Open Project → select the `FINAL` folder).

3. Update the database path in `DB.java` to match your local machine:
   ```java
   private static final String DB_PATH = "jdbc:sqlite:YOUR_PATH_HERE/FINAL.db";
   ```

4. Build and run the project (`Shift + F6` or Run → Run Project).

---

## 🗄️ Database Schema

| Table      | Key Fields                                              |
|------------|---------------------------------------------------------|
| `users`    | users_email, users_password, users_role                 |
| `Student`  | student_id, student_name, student_email, student_phone, student_major, student_year |
| `teachers` | id, name, email, password, phone, subject               |

---

## 🤝 Contributing

Contributions are welcome! To contribute:

1. Fork this repository.
2. Create a new branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Make your changes and commit:
   ```bash
   git commit -m "Add: description of your change"
   ```
4. Push to your branch:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a Pull Request and describe what you changed and why.

### Guidelines

- Keep code clean and commented where necessary.
- Follow the existing package structure (`ANU` package).
- Test your changes before submitting a PR.
- One feature or fix per pull request.

---

## 📄 License

This project is for educational purposes.
