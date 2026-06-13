/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ANU;

public class Student extends Person {
    
    protected int id;
    protected String email;
    protected String phone;
    protected String major;
    protected String year;

    public Student() {
    }


    public Student( int id,String Name , String email, String phone, String major, String year) {
        super(Name);
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.major = major;
        this.year = year;
    }
    
    public Student (String name, String email, String phone, String major, String year){
        this.Name = name;
        this.email = email;
        this.phone = phone;
        this.major = major;
        this.year = year;
        
    
    } 

     

    
    public void display_The_Person() {
         System.out.println(getName() + " is a student");;
    }

    
   
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
@Override
    public void setName(String name) {
        this.Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String getName() {
        return super.getName();
    }

  
} 

