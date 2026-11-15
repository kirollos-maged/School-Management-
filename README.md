# School Management System

A Java Swing desktop application prototype for school administration. The repository contains NetBeans GUI Builder forms and Java source files for login, student and teacher management, and related screens.

Repository: [kirollos-maged/School-Management-](https://github.com/kirollos-maged/School-Management-)

## What is in the repository

- **Swing screens:** Login with student, teacher, and manager role choices; student and teacher management forms and tables; and student and teacher schedule screens.
- **Student database operations:** `DB.java` contains SQLite operations to add, list, update, and delete student records. The student fields are ID, name, email, phone, major, and year.
- **Teacher database operations:** The source contains operations to add, list, and delete teacher records, with name, email, phone, salary, and subject fields. The teacher update query refers to a column name that does not match the created table, so teacher updates should not be assumed to work.
- **Course and enrollment code:** `Course`, `Subject`, and `Enrollment` model classes are present. Database methods also refer to `Course` and `Student_Course` tables, but the application does not create those tables.
- **Payment and profile code:** `Payment` is an interface, not a payment-processing implementation. `ProfileManager` displays and changes student object fields in memory; it does not persist profile changes to the database.

These are capabilities represented in the source, not a claim that every workflow is operational. In particular, the login query expects `users_email`, `users_password`, and `users_role`, while the separate `createTablesIfNotExist()` method defines `email`, `password`, and `role` for `users`. That method is not called by the `DB` constructor, and its schema does not match the login query.

## Requirements and project layout

- JDK 15 or newer (Java text blocks are used); JDK 17 or newer is recommended.
- SQLite JDBC driver, which is not included in this repository.
- NetBeans is recommended for editing the adjacent `.form` files with the GUI Builder.

The Java sources and `.form` files are at the repository root. The Java files declare package `ANU`, but are not stored in an `ANU` subdirectory. Open the repository root as the source folder; there is no `FINAL` subfolder or checked-in Maven, Gradle, or NetBeans project configuration.

## Build and run on Windows

1. Clone the repository and enter its root:

   ```powershell
   git clone https://github.com/kirollos-maged/School-Management-.git
   Set-Location School-Management-
   ```

2. Add a SQLite JDBC driver JAR at `lib\sqlite-jdbc.jar` (or update the classpath below to its actual location). The driver is not vendored here.

3. Compile and launch the login screen:

   ```powershell
   New-Item -ItemType Directory -Force out | Out-Null
   javac -cp ".;lib\sqlite-jdbc.jar" -d out *.java
   java -cp "out;lib\sqlite-jdbc.jar" ANU.LoginSchool
   ```

   The database path is hard-coded in `DB.java` and several UI classes as `D:\L1\Tasks 2\Tasks OOP\FINAL\FINAL.db`. There is no configuration option or database file in this repository. The application must be adapted to use a local database path before database-backed screens can be used on another machine.

   The database helper creates `Student` and `Teacher` tables. Its `users` table helper defines `name`, `email`, `password`, and `role`, which do not match the column names used by the login query. Course and enrollment methods also query tables that are not created by the helper. These schema and path limitations need to be resolved before treating the full application as runnable.

## Database tables created by the helper

`DB.java` creates these tables when its database connection succeeds:

| Table | Columns |
|---|---|
| `Student` | `student_id` (primary key), `student_name` (required), `student_email` (required, unique), `student_phone`, `student_major`, `student_year` |
| `Teacher` | `teacher_name`, `teacher_email` (required, unique), `teacher_phone`, `teacher_sallary`, `teacher_subject` |

The spelling `teacher_sallary` is used in the source. The separate `createTablesIfNotExist()` method defines `users` with columns `name`, `email`, `password`, and `role`; it is not called by the constructor and does not match the login query. No schema for `Course` or `Student_Course` is created in `DB.java`.

## Contributing

Contributions are welcome. Keep each change focused, preserve the paired `.java` and `.form` files when changing GUI forms, and test changes with a configured local JDK, SQLite JDBC driver, and database.

## License

No `LICENSE` file is included. The educational-purpose description is not a license grant.
