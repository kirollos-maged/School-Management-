
package ANU;
public class Teacher extends Person implements Payment {
    protected String name;
    protected String id;
    protected String email;
    protected String phone;
    protected double salary;
    protected boolean is_Sallary_Paid;
    protected String subject;
    public Teacher() {
    }


    
    public Teacher(String name,String email, String phone, double salary,String subject ) {
        this.name= name;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.subject=subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
  public boolean isIs_Sallary_Paid() {
        return is_Sallary_Paid;
    }

    public void setIs_Sallary_Paid(boolean is_Sallary_Paid) {
        this.is_Sallary_Paid = is_Sallary_Paid;
    }

    
    @Override
    public void payment_process(double amount) {
         if (amount >= salary) {
            is_Sallary_Paid = true;
            System.out.println(getName() + " received their salary of " + salary+"$");
        } else {
            System.out.println("not enough to pay " + getName());
        }
    }


  @Override
    public void display_The_Person() {
        System.out.println("\n--- Teacher Info ---");
        System.out.println("Name: " + super.Name);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Salary: $" + salary);
    }
  

    
  
   }

    


