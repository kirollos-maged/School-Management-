
package ANU;


public abstract class Person {
      protected String Name;

    public Person() {
    }

    public Person(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public abstract void display_The_Person();
    
}
